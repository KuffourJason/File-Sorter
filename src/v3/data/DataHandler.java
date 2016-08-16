package v3.data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import com.google.gson.*;


public class DataHandler<T> {

	private Gson converter;
	private File savedData;
	private T cl;
	private Class<T> typeOfParameter;
	
	public DataHandler(File filename, Class<T> tp){
		
		this.converter = new Gson();
		this.savedData = filename;
		this.typeOfParameter = tp;
	}
	
	public T getData(){
		
		try {
			FileReader reader = new FileReader(this.savedData);
			this.cl = this.converter.fromJson( reader, this.typeOfParameter );
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return cl;
	}
	
	public void saveData(T data){
		
		try {
			
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
		
	}
	
}



