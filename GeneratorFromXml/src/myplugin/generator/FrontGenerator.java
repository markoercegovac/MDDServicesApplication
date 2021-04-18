package myplugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import b.a.f.c;
import freemarker.template.TemplateException;
import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMFieldProperty;
import myplugin.generator.fmmodel.FMFormClass;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.fmmodel.FMProperty;
import myplugin.generator.options.GeneratorOptions;

public class FrontGenerator extends BasicGenerator {

	public FrontGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
		// TODO Auto-generated constructor stub
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
			Writer out;
			Map<String, Object> context = new HashMap<String, Object>();
			try {
				FMFormClass fm = cl.getFmFormClass();
				String path = "FrontEnd.src.app.";
				if(fm.getComponentName()!=null) {
					path += fm.getComponentName().toLowerCase();
				}
				out = getWriter(cl.getName(), path, true);
				if (out != null) {
					context.clear();
					context.put("class", cl);
					context.put("properties", cl.getProperties());
					context.put("fmForm",cl.getFmFormClass());
					context.put("importedPackages", cl.getImportedPackages());
					List<FMFieldProperty> fmFields = new ArrayList<>();
					for(FMProperty prop:cl.getProperties()) {
						fmFields.add(prop.getFieldProperty());
					}
					
					context.put("listFields",fmFields);
					
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
