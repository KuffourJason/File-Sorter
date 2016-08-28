package v3.data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

import v3.data.wrappers.ExtensionItem;
import v3.data.wrappers.Extensions;
import v3.data.wrappers.History;
import v3.data.wrappers.HistoryItem;
import v3.data.wrappers.SaveItem;
import v3.data.wrappers.SaveOption;
import v3.data.wrappers.Saves;


/**
 * @author jay
 *
 *This class is responsible for serializing and deserializing data to and from the installation directory
 *
 *
 * @param <T> - Generic parameter. To be used with the wrapper classes that have a corresponding json file
 * 				i.e Saves, Extensions and History
 */
public class DataHandler<T> {

	private Gson converter;			//this is responsible for serializing and deserializing data
	private File savedData;			//the file that contains the data
	private T cl;					//the instance of the class which stores the data 
	private Class<T> typeOfParameter;	//the class of the data
	
	/**
	 * Constructor
	 * 
	 * @param filename - the file to which data is to be serialized and deserialized to
	 * @param tp - the class of data to be serialized and deserialized i.e Saves, History, Extensions
	 */
	public DataHandler(File filename, Class<T> tp){
		
		this.converter = new Gson();
		this.savedData = filename;
		this.typeOfParameter = tp;
	}
	
	/**
	 * @return - A instance of T populated with the data that was deserialized from the file
	 */
	public T getData(){
		
		try {
			//reads data from json file and converts to instance of class T
			FileReader reader = new FileReader(this.savedData);		
			this.cl = this.converter.fromJson( reader, this.typeOfParameter );	
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return cl;
	}
	
	/**
	 * @param data - the instance of data to be serialized to the file
	 */
	public void saveData(T data){
		
		try {
			// converts instance of class T to json and writes to file
			FileWriter writer = new FileWriter(this.savedData);
			this.converter.toJson( data, writer );
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main( String args[]){
		
		DataManager t = DataManager.getDataManager();
		
		DataHandler<History> test = new DataHandler<History>(t.getHistoryFile(), History.class );  
		
		History data = test.getData();
		System.out.println(data.getItems().size() + " " + data.getItems().get(0).getDate() );
		
		HistoryItem o = new HistoryItem("20-13-09", "trueno", "bastardo", "7:34");
		
		List<HistoryItem> afd = data.getItems();
		afd.add(o);
		data.setItems(afd);
		test.saveData(data);
		
		DataHandler<Extensions> test2 = new DataHandler<Extensions>(t.getExtensionsFile(), Extensions.class );  
		Extensions e = test2.getData();
		System.out.println( e.getExtensions().size() + " " + e.getExtensions().get(1).getFileExt() );
		
		List<ExtensionItem> fd = e.getExtensions();
		fd.add(new ExtensionItem("fae", "feag") );
		e.setExtensions(fd);
		test2.saveData(e);
		
		DataHandler<Saves> test3 = new DataHandler<Saves>(t.getSaveFile(), Saves.class);
		
		SaveOption so1 = new SaveOption("time", "", "", "");
		SaveOption so2 = new SaveOption("name", "", "", "");
		SaveOption so3 = new SaveOption("size", "", "", "");
		
		List<SaveOption> ls = new ArrayList<SaveOption>();
		ls.add(so1);
		ls.add(so2);
		ls.add(so3);
		
		SaveItem si = new SaveItem("test", ls );
		List<SaveItem> opi = new ArrayList<SaveItem>();
		opi.add(si);
		Saves s = new Saves(opi);
		test3.saveData(s);
	}
	
}



