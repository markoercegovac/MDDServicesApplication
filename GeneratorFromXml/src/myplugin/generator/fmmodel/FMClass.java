package myplugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FMClass{	
	
	private String visibility;
	private String name;
	private String classPackage;
	private String typePackage;

	//Class properties
	private List<FMProperty> FMProperties = new ArrayList<FMProperty>();
	
	//list of packages (for import declarations) 
	private List<String> importedPackages = new ArrayList<String>();
	
	/** @ToDo: add list of methods */
	
	
	private FMFormClass fmFormClass;
	

	public List<FMProperty> getProperties(){
		return FMProperties;
	}


	public FMClass() {
		super();
	}


	public FMClass(String visibility, String name, String classPackage, String typePackage,
			List<FMProperty> fMProperties, List<String> importedPackages,FMFormClass formClass) {
		super();
		this.visibility = visibility;
		this.name = name;
		this.classPackage = classPackage;
		this.typePackage = typePackage;
		FMProperties = fMProperties;
		this.importedPackages = importedPackages;
		this.fmFormClass = formClass;
	}


	public FMFormClass getFmFormClass() {
		return fmFormClass;
	}


	public void setFmFormClass(FMFormClass fmFormClass) {
		this.fmFormClass = fmFormClass;
	}


	public Iterator<FMProperty> getPropertyIterator(){
		return FMProperties.iterator();
	}
	
	public void addProperty(FMProperty property){
		FMProperties.add(property);		
	}
	
	public int getPropertyCount(){
		return FMProperties.size();
	}
	
	public List<String> getImportedPackages(){
		return importedPackages;
	}

	public Iterator<String> getImportedIterator(){
		return importedPackages.iterator();
	}
	
	public void addImportedPackage(String importedPackage){
		importedPackages.add(importedPackage);		
	}
	
	public int getImportedCount(){
		return FMProperties.size();
	}
	
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTypePackage() {
		return typePackage;
	}


	public void setTypePackage(String typePackage) {
		this.typePackage = typePackage;
	}	

	
	
	
}
