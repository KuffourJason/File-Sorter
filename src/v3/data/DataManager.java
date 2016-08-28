package v3.data;

import java.io.File;
import java.io.IOException;

/**
 * @author jay
 *
 * This class handles access to the program's app folder on the machine
 */
/**
 * @author jay
 *
 */
public class DataManager {

	private File extensions;	//file that contains the extension-name pair
	private File history;		//file that contains the sorted folder history
	private File saves;			//file that contains user defined sort methods
	private File preferences;   //file that contains user preferences
	private static DataManager manager;		//singleton instance for this class
	
	/**
	 * Constructor. The constructor creates/points to the directory that contains the necessary files used
	 * by the program
	 */
	private DataManager(){
		//Creates/points to the program directory
		String dir = getProgramDataLocation() + "/FileSorter";
		File folder = new File(dir);
		folder.mkdir();
		
		//Creates the three main files in the directory
		this.extensions = new File(dir + "/Extensions.json");
		this.history    = new File(dir + "/History.json");
		this.saves      = new File(dir + "/Saves.json");
		this.preferences = new File(dir + "/Preferences.json");
		
		try {
			this.extensions.createNewFile();
			this.saves.createNewFile();
			this.history.createNewFile();
			this.preferences.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return - the singleton instance for this class
	 */
	public static DataManager getDataManager(){
		if( manager == null){
			manager = new DataManager();
		}
		return manager;
	}
	
	/**
	 * @return - the directory to which the program can store it's files and folders
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

		return path;
	}
	
	/**
	 * @return - the History file
	 */
	protected File getHistoryFile(){
		return this.history;
	}
	
	/**
	 * @return - the extension file
	 */
	protected File getExtensionsFile(){
		return this.extensions;
	}
	
	/**
	 * @return - the save file
	 */
	protected File getSaveFile(){
		return this.saves;
	}
	
	/**
	 * @return - the preferences file
	 */
	protected File getPreferencesFile(){
		return this.preferences;
	}
	
	
}
