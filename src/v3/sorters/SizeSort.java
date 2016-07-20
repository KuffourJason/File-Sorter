package v3.sorters;

import java.io.File;

/**
 * @author jay
 *
 * This class contains all the methods related to sorting by file size
 */
public class SizeSort extends Sorters {

	/**
	 * @param f - that file that is currently being considered for sorting
	 * @return - a boolean indicating whether file f's size is within the byte range
	 */
	private boolean isB(File f){
		return f.length()/1000 < 1;
	}
	
	/**
	 * @param f - that file that is currently being considered for sorting
	 * @return - a boolean indicating whether file f's size is within the kilobyte range
	 */
	private boolean isKB(File f){
		return f.length()/1000 >= 1;
	}
	
	/**
	 * @param f - that file that is currently being considered for sorting
	 * @return - a boolean indicating whether file f's size is within the megabyte range
	 */
	private boolean isMB(File f){
		return f.length()/1000000 >= 1;
	}
	
	/**
	 * @param f - that file that is currently being considered for sorting
	 * @return - a boolean indicating whether file f's size is within the gigabyte range
	 */
	private boolean isGB(File f){
		return f.length()/1000000000 >= 1;
	}
	
	public void sort() {
		File dir[] = this.getFilesList();	//gets the list of files in the directory
		
		//loops through all files in the directory
		for( File f: dir){
			
			String savepath = null;
			
			if( isGB(f) ){	//file size greater than MB
				savepath = this.getDirPath() + "/" + "GigaBytes";
			}
			else if( isMB(f) ){ //file size greater than KB
				savepath = this.getDirPath() + "/" + "MegaBytes";
			}
			else if( isKB(f) ){ //file size greater than B
				savepath = this.getDirPath() + "/" + "KiloBytes";
			}
			else if( isB(f)  ){ //file size is in the byte range
				savepath = this.getDirPath() + "/" + "Bytes";
			}
			else{ //file size greater than GB
				savepath = this.getDirPath() + "/" + "TeraBytes";
			}
			
			File newDir = new File(savepath);					
			newDir.mkdir();										//creates dir for that year
			f.renameTo(new File(savepath + "/" + f.getName() ) ); //moves file to that directory
		}
		
	}
}
