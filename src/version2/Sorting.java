package version2;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author jason
 *
 */
public class Sorting {
	
	/**
	 * This method sorts the files into their respective file formats. This method should always 
	 * go first when being called
	 * 
	 * @param names - The array of file names
	 * @param counter - The number of elements in the array
	 */
	public static void sortFirst( String[] names ,int counter, String downloadPath ){
		
		/**
		 * LI: Files 0 to i in the names array have been placed into one of their 5 categories.
		 */
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
	 * This method sorts the remaining files into the 2 other categories. This method is executed after Sort first
	 * 
	 * @param counter - 
	 * @param names - The array of files left in the Download folder after the method sortFirst is done executing
	 * @param downloadPath - The string that contains the directory to the folder that is being sorted
	 */
	public static void sortLast(int counter, String[] names, String downloadPath){
		
		
		File folders = new File(downloadPath + "/folders");
		folders.mkdir();
		
		/**
		 * LI: Files 0 - i in the names array have been placed into either the miscellaneaos or folder folders. 
		 */
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
	
	
	
	
	/**
	 * This method sorts the files according to the months they were added or last modified
	 * 
	 * @param downloadPath - This contains the directory of the folder that contains the folder to be
	 * 						 sorted by the months
	 * @param folderToSort - This is the folder to be sorted according to the date
	 */
	public static void subSortByMonth( String downloadPath, File folderToSort ){
		
		String[] hold = folderToSort.list();
		int out = hold.length;
		
		for( int w = 0; w < out; w++){
			
			File c = new File( downloadPath + "/" + hold[w]);
			
			String[] cur = c.list();
			
			int x = cur.length;
			
			File jfma = new File( downloadPath + "/" +hold[w]  + "/Jan-Feb-March-Apr");
			jfma.mkdir();
			
			File mjja = new File( downloadPath + "/" +hold[w]  + "/May-June-Jul-Aug");
			mjja.mkdir();
			
			File sond = new File( downloadPath + "/" +hold[w]  + "/Sept-Oct-Nov-Dec");
			sond.mkdir();

			/**
			 * LI: The files have been placed in the folders of the month they were created
			 */
			for( int y = 0; y < x; y++){
				
				File now = new File(downloadPath + "/" +hold[w] + "/" + cur[y]);
			
				
				if( cur[y].compareTo("Jan-Feb-March-Apr" ) == 0 || cur[y].compareTo("May-June-Jul-Aug" ) == 0 || cur[y].compareTo("Sept-Oct-Nov-Dec" ) == 0){
					continue;
				}
				
				Date date = new Date( now.lastModified() );
				SimpleDateFormat format = new SimpleDateFormat("MM");		
				
				String mod = format.format(date); //Converts the file modified date    
				
				int filemod =  Integer.parseInt(mod);
				
				
				if( filemod < 5 && filemod > 0  ){
					now.renameTo( new File(downloadPath + "/" +hold[w] + "/" + "Jan-Feb-March-Apr/" + cur[y]) );
					now.delete();
				}
				else if( filemod < 9 && filemod > 4  ){
					now.renameTo( new File(downloadPath + "/" +hold[w] + "/" + "May-June-Jul-Aug/" + cur[y]) );
					now.delete();
				}
				else if( filemod < 13  && filemod > 8 ){
					now.renameTo( new File(downloadPath + "/" +hold[w] + "/" + "Sept-Oct-Nov-Dec/" + cur[y]) );
					now.delete();
				}
				
				
			}
			
		}
	}
	
	
	public static void sortByYear( String downloadPath ){
	}
	
}	
