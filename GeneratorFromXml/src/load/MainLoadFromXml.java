package load;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.nomagic.magicdraw.plugins.Plugin;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import myplugin.generator.EJBGenerator;
import myplugin.generator.FrontGenerator;
import myplugin.generator.FrontModelGenerator;
import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;




public class MainLoadFromXml{
	
	private static String DIR = "c:/fax/temp";

	private static final String TEMP_DIR = "templates";
	private static final String PROJECT_PATH = new File("").getAbsolutePath();
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			XStream xstream = new XStream(new DomDriver());
			FMModel model= (FMModel) xstream.fromXML(in);
			FMModel.getInstance().getClasses().addAll(model.getClasses());
//			DIR = "/home/dijana/temp"; //ko koristi windows zakomentarise
			
			ejbOptions();
			angularHtmlComponents();
			angularCssComponents();
			angularTsComponents();
			angularTsModel();
			angularTsService();
		}
	   
	}
	
	public static void ejbOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "ejbclass", TEMP_DIR,"{0}EJBModel.java",true,"generator.mbrs.model");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        EJBGenerator ejbGenerator = new EJBGenerator(generatorOptions);
        ejbGenerator.generate();
	}
	
	public static void angularHtmlComponents() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR,"htmlComponent", TEMP_DIR,"{0}".toLowerCase()+".component.html",true,
				"FrontEnd.app.components");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("FrontGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        FrontGenerator ejbGenerator = new FrontGenerator(generatorOptions);
        ejbGenerator.generate();		
	}
	
	public static void angularCssComponents() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR,"cssComponent", TEMP_DIR,"{0}".toLowerCase()+".component.css",true,
				"FrontEnd.app.components");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("FrontGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        FrontGenerator ejbGenerator = new FrontGenerator(generatorOptions);
        ejbGenerator.generate();		
	}
	
	public static void angularTsComponents() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR,"tsComponent", TEMP_DIR,"{0}".toLowerCase()+".component.ts",true,
				"FrontEnd.app.components");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("FrontGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        FrontGenerator ejbGenerator = new FrontGenerator(generatorOptions);
        ejbGenerator.generate();		
	}
	
	public static void angularTsModel() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR,"frontModel", TEMP_DIR,"{0}".toLowerCase()+".model.ts",true,
				"FrontEnd.src.app.model");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("FrontModelGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        FrontModelGenerator ejbGenerator = new FrontModelGenerator(generatorOptions);
        ejbGenerator.generate();
	}
	
	public static void angularTsService() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR,"frontService", TEMP_DIR,"{0}".toLowerCase()+".service.ts",true,
				"FrontEnd.src.app.service");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("FrontModelGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        FrontModelGenerator ejbGenerator = new FrontModelGenerator(generatorOptions);
        ejbGenerator.generate();
	}
}
