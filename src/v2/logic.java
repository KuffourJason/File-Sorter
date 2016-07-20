package v2;

import java.io.File;

/**
 * @author jason
 *
 */
public class logic {
	
	
	private static File downloads;
	private static File word;
	private static File pdfs;
	private static File powerpoints;
	private static File zips;
	private static File installers;
	private static File miscellaneaous;

	private static String downloadPath;
	
	
	/**
	 * This method finds chrome's default download folder location. It returns either 
	 * an empty string or a non empty string depending on whether the folder exists.
	 * 
	 * @return - empty string for non existant folder and non empty for existing folder
	 */
	public static String downloadPath(){
		
		String path = System.getProperty("user.home");
		downloadPath = path + "\\Downloads";
		
		downloads = new File( downloadPath);
		
		if( !(downloads.exists() && downloads.isDirectory()) ) {
			return "";
		}
		else{
			return downloadPath;
		}
	}
	
	
	
	/**
	 * This method creates/identifies the 6 main category folders and it also 
	 * lists all the files currently in the downloads folder
	 * 
	 * @param- The file path to the folder that is being sorted
	 * @return- returns the list of files currently in the download folders
	 */
	public static String[] listFiles( String downloadPath ){
		
		downloads = new File(downloadPath);
		
		word = new File(downloadPath + "/word");
		word.mkdir();
		
		pdfs = new File(downloadPath + "/pdfs");
		pdfs.mkdir();
		
		powerpoints = new File(downloadPath + "/powerpoints");
		powerpoints.mkdir();
		
		zips = new File(downloadPath + "/zips");
		zips.mkdir();
		
		installers = new File(downloadPath + "/installers");
		installers.mkdir();
		
		miscellaneaous = new File(downloadPath + "/miscellaneaous");
		miscellaneaous.mkdir();
		
		return downloads.list();
	}
	
}