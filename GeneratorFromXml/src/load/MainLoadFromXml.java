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
import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;




public class MainLoadFromXml{
	
	private static final String DIR = "c:/temp";
	private static final String TEMP_DIR = "templates";
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Start");
		
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			XStream xstream = new XStream(new DomDriver());
			FMModel model= (FMModel) xstream.fromXML(in);
			FMModel.getInstance().getClasses().addAll(model.getClasses());
			
			ejbOptions();
			
		}
	   
	}
	
	public static void ejbOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions(DIR , "ejbclass", TEMP_DIR,"{0}EJBModel.java",true,"generator.mbrs.model");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator" ,generatorOptions);
		generatorOptions.setTemplateDir("F:\\fax\\mas\\Mbrs\\Gen\\MDDServicesApplication\\GeneratorFromXml\\resources\\templates");
        EJBGenerator ejbGenerator = new EJBGenerator(generatorOptions);
        ejbGenerator.generate();
	}

}
