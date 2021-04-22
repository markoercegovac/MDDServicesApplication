package myplugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.fmmodel.FMProperty;
import myplugin.generator.fmmodel.FetchType;
import myplugin.generator.options.GeneratorOptions;

/**
 * EJB generator that now generates incomplete ejb classes based on MagicDraw
 * class model
 * 
 * @ToDo: enhance resources/templates/ejbclass.ftl template and intermediate
 *        data structure (@see myplugin.generator.fmmodel) in order to generate
 *        complete ejb classes
 */

public class EJBGenerator extends BasicGenerator {

	public EJBGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}


	public void generate() {

		try {
			super.generate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		List<FMClass> classes = FMModel.getInstance().getClasses();
		
		

		for (int i = 0; i < classes.size(); i++) {
			FMClass cl = classes.get(i);
			List<FMProperty> properties = new ArrayList<>();
			List<FMProperty> temp= cl.getProperties();
			for(FMProperty p :temp) {
				FMProperty pro= p;
				if(pro.getPerisistentProperty()!= null) {
					pro.setColumnName(pro.getPerisistentProperty().getColumnName());
					pro.setLength(pro.getPerisistentProperty().getLength());
					pro.setPrecision(pro.getPerisistentProperty().getPrecision());
					pro.setStrategy(pro.getPerisistentProperty().getStrategy());
					pro.setPropertyType("persistent");
					
				}else {
					pro.setJoinTable(pro.getReferencedProperty().getJoinTable());
					pro.setJoinType(pro.getReferencedProperty().getJoinType());
					pro.setCascadeType(pro.getReferencedProperty().getCascadeType());
					pro.setFetchType(pro.getReferencedProperty().getFetchType());
					pro.setPropertyType("referenced");
				}
				
				properties.add(pro);
			}

			Writer out;
			Map<String, Object> context = new HashMap<String, Object>();
			try {
				out = getWriter(cl.getName(), cl.getTypePackage(), false);
				if (out != null) {
					context.clear();
					context.put("class", cl);
					context.put("properties", properties);
					context.put("importedPackages", cl.getImportedPackages());
					getTemplate().process(context, out);
					out.flush();
				}
			} catch (TemplateException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}
}