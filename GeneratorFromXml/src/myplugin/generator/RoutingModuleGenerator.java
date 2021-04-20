package myplugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.options.GeneratorOptions;

public class RoutingModuleGenerator extends BasicGenerator {

	public RoutingModuleGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
		// TODO Auto-generated constructor stub
	}
	
	public void generate(String fileName) {
		try {
			super.generate();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		List<FMClass> classes = FMModel.getInstance().getClasses();
		Writer out;
		Map<String, Object> context = new HashMap<String, Object>();
		
		try {
			out = getWriter(fileName,"test",false);
			if(out !=null) {
				context.clear();
				context.put("classes", classes);
				getTemplate().process(context, out);
				out.flush();
			}
		}catch (TemplateException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
