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
	 * This method finds chrome's default download folder location
	 */
	private static void downloadPath(){
		
		String path = System.getProperty("user.home");
		downloadPath = path + "\\Downloads";
		
		downloads = new File( downloadPath);
		
		GUI.error();
		
		if( !(downloads.exists() && downloads.isDirectory()) ) {
			GUI.error();
		}
	}
	
	
	
	/**
	 * This method creates/identifies the 6 main category folders and it also 
	 * lists all the files currently in the downloads folder
	 * 
	 * @return- returns the list of files currently in the download folders
	 */
	private static String[] listFiles(){
		
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
	
	
	/**
	 * This method sorts the files into their respective file formats first
	 * 
	 * @param names - The array of file names
	 * @param counter - The number of elements in the array
	 */
	private static void sortFirst( String[] names ,int counter ){
		
		for( int j = 0; j < counter; j++){
			
			String type = names[j].charAt(names[j].length() - 3) + "" +names[j].charAt(names[j].length() - 2) + names[j].charAt(names[j].length() - 1) ;
			File file = new File(downloadPath + "/" + names[j]);
			
			
			if( type.equals("ppt") || type.equals("ptx") ){
				
				file.renameTo(new File( downloadPath + "/powerpoints/" + names[j] ) );
				file.delete();
			}
			else if( type.equals("pdf") ){
				
				file.renameTo(new File( downloadPath + "/pdfs/" + names[j] ) );
				file.delete();
			}
			else if(type.equals("ocx") || type.equals("doc") ){
				
				file.renameTo(new File( downloadPath + "/word/" + names[j] ) );
				file.delete();
			}
			else if(type.equals("msi")){
				
				file.renameTo(new File( downloadPath + "/installers/" + names[j] ) );
				file.delete();
			}
			else if(type.equals("zip")){
				
				file.renameTo(new File( downloadPath + "/zips/" + names[j] ) );
				file.delete();
			}
		}
		
	}
	
	
	/**
	 * This method sorts the remaining files in the download folder into miscellaneous and folders
	 * 
	 * @param counter - The position in the array to start from in the array names
	 * @param names - array string of file names
	 */
	private static void sortLast(int counter, String[] names){
		
		File folders = new File(downloadPath + "/folders");
		folders.mkdir();
		
		for( int i = 0; i < counter; i++){
		
			File dir = new File(downloadPath + "/" + names[i]);
			
			if( names[i].equals("folders") || names[i].equals("zips") || names[i].equals("pdfs") || names[i].equals("word") ||
					names[i].equals("powerpoints") || names[i].equals("installers") || names[i].equals("miscellaneaous") ){
				
				continue;
			}
			
			if(dir.isDirectory() ){
				
				dir.renameTo(new File( downloadPath + "/folders/" + names[i] ) );
				dir.delete();
			}
			else{
				
				dir.renameTo(new File( downloadPath + "/miscellaneaous/" + names[i] ) );
				dir.delete();
			}
		}
	}
	
	
	
	public static void main(String[] args){
		
		logic.downloadPath();
				
		String[] names = logic.listFiles();
		int counter = names.length;
		
		sortFirst( names, counter);
		
		downloads = new File(downloadPath);
		names = downloads.list();
		counter = names.length;
		
		sortLast( counter, names);
		
		GUI.done();
	}
	
}