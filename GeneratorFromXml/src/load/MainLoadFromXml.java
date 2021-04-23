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
import myplugin.generator.RoutingModuleGenerator;
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
			DIR = "/home/dijana/temp"; //ko koristi windows zakomentarise
			
			ejbOptions();
			angularHtmlComponents();
			angularCssComponents();
			angularTsComponents();
			angularTsModel();
			angularTsService();
			routingModule();
			appHtmlComponent();
			appModule();
			navigationCss();
			navigationHtml();
			navigationTs();
			dtoOptions();
			appProperties();
			pomXml();
			springMain();
			repositoryOptions();
			service();
			serviceImpl();
		}
	   
	}
	
	public static void ejbOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "ejbclass", TEMP_DIR,"{0}.java",true,"mbrs.src.main.java.generator.mbrs.model");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        EJBGenerator ejbGenerator = new EJBGenerator(generatorOptions);
        ejbGenerator.generate();
	}
	
	public static void dtoOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "dtoModel", TEMP_DIR,"{0}Dto.java",true,"mbrs.src.main.java.generator.mbrs.dto");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        EJBGenerator ejbGenerator = new EJBGenerator(generatorOptions);
        ejbGenerator.generate();
	}
	
	public static void repositoryOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "repository", TEMP_DIR,"{0}Repository.java",true,"mbrs.src.main.java.generator.mbrs.repository");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        EJBGenerator ejbGenerator = new EJBGenerator(generatorOptions);
        ejbGenerator.generate();
	}
	
	public static void service() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "service", TEMP_DIR,"{0}Service.java",true,"mbrs.src.main.java.generator.mbrs.service");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        EJBGenerator ejbGenerator = new EJBGenerator(generatorOptions);
        ejbGenerator.generate();
	}
	
	public static void serviceImpl() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "serviceImpl", TEMP_DIR,"{0}ServiceImpl.java",true,"mbrs.src.main.java.generator.mbrs.service.impl");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
        EJBGenerator ejbGenerator = new EJBGenerator(generatorOptions);
        ejbGenerator.generate();
	}
	
	public static void appProperties() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "appProperties", TEMP_DIR,"{0}.properties",true,"mbrs.src.main.resources");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator ejbGenerator = new RoutingModuleGenerator(generatorOptions);
        ejbGenerator.generate("application");
	}
	
	public static void pomXml() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "pom", TEMP_DIR,"{0}.xml",true,"mbrs");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator ejbGenerator = new RoutingModuleGenerator(generatorOptions);
        ejbGenerator.generate("pom");
	}
	
	public static void springMain() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "springMain", TEMP_DIR,"{0}.java",true,"mbrs.src.main.java.generator.mbrs");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator ejbGenerator = new RoutingModuleGenerator(generatorOptions);
        ejbGenerator.generate("MbrsApplication");
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
	
	public static void routingModule() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "routingModule", TEMP_DIR, "{0}"+".module.ts", true, "FrontEnd.src.app");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator moduleGenerator = new RoutingModuleGenerator(generatorOptions);
		moduleGenerator.generate("app-routing");
	}
	
	public static void appHtmlComponent() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "appHtmlComponent", TEMP_DIR, "{0}"+".component.html", true, "FrontEnd.src.app");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator moduleGenerator = new RoutingModuleGenerator(generatorOptions);
		moduleGenerator.generate("app");
	}
	
	public static void appModule() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "appModuleTs", TEMP_DIR, "{0}"+".module.ts", true, "FrontEnd.src.app");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator moduleGenerator = new RoutingModuleGenerator(generatorOptions);
		moduleGenerator.generate("app");
	}
	
	public static void navigationTs() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "navigationTs", TEMP_DIR, "{0}"+".component.ts", true, "FrontEnd.src.app.navigation");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator moduleGenerator = new RoutingModuleGenerator(generatorOptions);
		moduleGenerator.generate("navigation");
	}
	
	public static void navigationHtml() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "navigationHtml", TEMP_DIR, "{0}"+".component.html", true, "FrontEnd.src.app.navigation");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator moduleGenerator = new RoutingModuleGenerator(generatorOptions);
		moduleGenerator.generate("navigation");
	}
	
	public static void navigationCss() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR, "navigationCss", TEMP_DIR, "{0}"+".component.css", true, "FrontEnd.src.app.navigation");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RoutingModuleGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir(PROJECT_PATH + File.separator +"resources" +File.separator+ "templates");
		RoutingModuleGenerator moduleGenerator = new RoutingModuleGenerator(generatorOptions);
		moduleGenerator.generate("navigation");
	}
	
	
}
