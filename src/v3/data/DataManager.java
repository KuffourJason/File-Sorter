package v3.data;

import java.io.File;
import java.io.IOException;

/**
 * @author jay
 *
 */
public class DataManager {

	private File extensions;
	private File history;
	private File saves;
	private static DataManager manager;
	
	
	/**
	 * 
	 */
	private DataManager(){
		String dir = getProgramDataLocation() + "/FileSorter";
		File folder = new File(dir);
		folder.mkdir();
		
		this.extensions = new File(dir + "/Extensions.json");
		this.history    = new File(dir + "/History.json");
		this.saves      = new File(dir + "/Saves.json");
		
		try {
			this.extensions.createNewFile();
			this.saves.createNewFile();
			this.history.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 */
	public static DataManager getDataManager(){
		if( manager == null){
			manager = new DataManager();
		}
		return manager;
	}
	
	/**
	 * @return
	 */
	private String getProgramDataLocation(){
	
		String path = null;
	    String osName = System.getProperty("os.name").toLowerCase();
	     
	    if (osName.indexOf("windows")>-1) {
	    	path = System.getenv("APPDATA");
	    } else if (osName.indexOf("mac")>-1) {
	        path = System.getenv("?"); // get the env. variable for Mac..
	    } else { //anything else
	        path = System.getProperty("user.home");
	    }

	    System.out.println(path);
		return path;
	}
	
	
	
	public static void main(String args[]){
		DataManager test =  DataManager.getDataManager();
	}
}
