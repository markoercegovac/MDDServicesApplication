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

import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMModel;



public class MainLoadFromXml {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Start");
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			XStream xstream = new XStream(new DomDriver());
			FMModel model= (FMModel) xstream.fromXML(in);
			System.out.print(model);
		}
	   
	}

}
