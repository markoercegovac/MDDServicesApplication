package myplugin.analyzer;

import java.util.Iterator;
import java.util.List;

import myplugin.generator.fmmodel.CascadeType;
import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMEnumeration;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.fmmodel.FMPerisistentProperty;
import myplugin.generator.fmmodel.FMProperty;
import myplugin.generator.fmmodel.FMReferencedProperty;
import myplugin.generator.fmmodel.FetchType;
import myplugin.generator.fmmodel.Strategy;

import com.nomagic.magicdraw.uml.symbols.reflect.PersistentProperty;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.*;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.sun.xml.internal.ws.server.sei.ValueGetter;


/** Model Analyzer takes necessary metadata from the MagicDraw model and puts it in 
 * the intermediate data structure (@see myplugin.generator.fmmodel.FMModel) optimized
 * for code generation using freemarker. Model Analyzer now takes metadata only for ejb code 
 * generation

 * @ToDo: Enhance (or completely rewrite) myplugin.generator.fmmodel classes and  
 * Model Analyzer methods in order to support GUI generation. */ 


public class ModelAnalyzer {	
	//root model package
	private Package root;
	
	//java root package for generated code
	private String filePackage;
	
	public ModelAnalyzer(Package root, String filePackage) {
		super();
		this.root = root;
		this.filePackage = filePackage;
	}

	public Package getRoot() {
		return root;
	}
	
	public void prepareModel() throws AnalyzeException {
		FMModel.getInstance().getClasses().clear();
		FMModel.getInstance().getEnumerations().clear();
		processPackage(root, filePackage);
	}
	
	private void processPackage(Package pack, String packageOwner) throws AnalyzeException {
		//Recursive procedure that extracts data from package elements and stores it in the 
		// intermediate data structure
		
		if (pack.getName() == null) throw  
			new AnalyzeException("Packages must have names!");
		
		String packageName = packageOwner;
		if (pack != root) {
			packageName += "." + pack.getName();
		}
		
		if (pack.hasOwnedElement()) {
			
			for (Iterator<Element> it = pack.getOwnedElement().iterator(); it.hasNext();) {
				Element ownedElement = it.next();
				if (ownedElement instanceof Class) {
					Class cl = (Class)ownedElement;
					FMClass fmClass = getClassData(cl, packageName);
					FMModel.getInstance().getClasses().add(fmClass);
				}
				
				if (ownedElement instanceof Enumeration) {
					Enumeration en = (Enumeration)ownedElement;
					FMEnumeration fmEnumeration = getEnumerationData(en, packageName);
					FMModel.getInstance().getEnumerations().add(fmEnumeration);
				}								
			}
			
			for (Iterator<Element> it = pack.getOwnedElement().iterator(); it.hasNext();) {
				Element ownedElement = it.next();
				if (ownedElement instanceof Package) {					
					Package ownedPackage = (Package)ownedElement;
					if (StereotypesHelper.getAppliedStereotypeByString(ownedPackage, "BusinessApp") != null)
						//only packages with stereotype BusinessApp are candidates for metadata extraction and code generation:
						processPackage(ownedPackage, packageName);
				}
			}
			
			/** @ToDo:
			  * Process other package elements, as needed */ 
		}
	}
	
	private FMClass getClassData(Class cl, String packageName) throws AnalyzeException {
		if (cl.getName() == null) 
			throw new AnalyzeException("Classes must have names!");
		
		FMClass fmClass = new FMClass(cl.getName(), packageName, cl.getVisibility().toString());
		Iterator<Property> it = ModelHelper.attributes(cl);
		while (it.hasNext()) {
			Property p = it.next();
			FMProperty prop = getPropertyData(p, cl);
			fmClass.addProperty(prop);	
		}	
		
		/** @ToDo:
		 * Add import declarations etc. */		
		return fmClass;
	}
	
	private FMProperty getPropertyData(Property p, Class cl) throws AnalyzeException {
		String attName = p.getName();
		if (attName == null) 
			throw new AnalyzeException("Properties of the class: " + cl.getName() +
					" must have names!");
		Type attType = p.getType();
		if (attType == null)
			throw new AnalyzeException("Property " + cl.getName() + "." +
			p.getName() + " must have type!");
		
		String typeName = attType.getName();
		if (typeName == null)
			throw new AnalyzeException("Type ot the property " + cl.getName() + "." +
			p.getName() + " must have name!");		
			
		int lower = p.getLower();
		int upper = p.getUpper();
		
		//Added stereotype for persistent property
		FMReferencedProperty referencedProperty = null;
		FMPerisistentProperty persistentProperty = null;
		
		if(p.getOpposite() != null) {
			referencedProperty = getReferecedProperty(p, cl);
		}
		else {
			persistentProperty = getPersistentProperty(p, cl, "PersistentProperty");	
		}
		
		FMProperty prop = new FMProperty(attName, typeName, p.getVisibility().toString(), lower, upper, persistentProperty, referencedProperty);
		return prop;
	}	
	
	private FMEnumeration getEnumerationData(Enumeration enumeration, String packageName) throws AnalyzeException {
		FMEnumeration fmEnum = new FMEnumeration(enumeration.getName(), packageName);
		List<EnumerationLiteral> list = enumeration.getOwnedLiteral();
		for (int i = 0; i < list.size() - 1; i++) {
			EnumerationLiteral literal = list.get(i);
			if (literal.getName() == null)  
				throw new AnalyzeException("Items of the enumeration " + enumeration.getName() +
				" must have names!");
			fmEnum.addValue(literal.getName());
		}
		return fmEnum;
	}	
	
	private FMPerisistentProperty getPersistentProperty(Property p, Class c, String stereotypeName) {
		Stereotype persistent = StereotypesHelper.getAppliedStereotypeByString(p, stereotypeName);
		String columnName = null;
		Integer length = 0;
		Integer precision = 0;
		String strategy = null;
		Strategy strategyEnum = null;
		
		if(persistent != null) {
			List<Property> tags = persistent.getOwnedAttribute();
			for(Property property : tags) {
				String tagName  = property.getName();
				List<?> value = StereotypesHelper.getStereotypePropertyValue(p, persistent, tagName);
				if(value.size() > 0) {
					switch (tagName) {
						case "columnName":
							columnName = (String) value.get(0);
							break;
						case "precision":
							precision = (Integer) value.get(0);
							break;
						case "length":
							length = (Integer) value.get(0);
							break;
						case "strategy":
							strategy = ((EnumerationLiteral) value.get(0)).getName();
							break;
					}
				}		
			}
		}
		if(strategy != null) {
			strategyEnum = Strategy.valueOf(strategy.toUpperCase());
		}
		FMPerisistentProperty fmPersistentProperty = new FMPerisistentProperty(columnName, length, precision, strategyEnum);
		return fmPersistentProperty;
	}
	
	private FMReferencedProperty getReferecedProperty(Property p, Class c) {
		Stereotype oneToMany = StereotypesHelper.getAppliedStereotypeByString(p, "OneToMany");
		Stereotype manyToOne = StereotypesHelper.getAppliedStereotypeByString(p, "ManyToOne");
		Stereotype referenced = StereotypesHelper.getAppliedStereotypeByString(p, "ReferencedProperty");
		Stereotype referencedStereotype = null;
		String fetch = null;
		FetchType fetchEnum = null;
		String cascade = null;
		CascadeType cascadeEnum = null;
		String columnName = null;
		String joinType = null;
		
		if(oneToMany != null) {
			referencedStereotype = oneToMany;
			joinType = "OneToMany";
		}
		if(manyToOne != null) {
			referencedStereotype = manyToOne;
			joinType = "ManyToOne";
		}
		
		if(referencedStereotype!=null) {
			List<Property> tags = referencedStereotype.getOwnedAttribute();
			for(Property property : tags) {
				String tagName = property.getName();
				List<?> value = StereotypesHelper.getStereotypePropertyValue(p, referencedStereotype, tagName);
				if(value.size()>0) {
					switch (tagName) {
						case "columnName":
							columnName = (String) value.get(0);
							break;
						case "cascade":
							cascade = ((EnumerationLiteral)value.get(0)).getName();
							break;
					}
				}
			}
			if(referenced != null) {
				fetch = referenced.getOwnedAttribute().get(0).getName();	
			}
			
		}
		
		if(fetch != null) {
			fetchEnum = FetchType.valueOf(fetch.toUpperCase());
		}
		if(cascade != null) {
			cascadeEnum = CascadeType.valueOf(cascade.toUpperCase());
		}
		
		FMReferencedProperty fmReferencedProperty = new FMReferencedProperty(columnName, null, joinType, cascadeEnum, fetchEnum);
		return fmReferencedProperty;
	}
	

	
}
