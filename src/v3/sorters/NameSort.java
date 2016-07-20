package v3.sorters;

import java.io.File;

/**
 * @author jay
 * 
 * This class contains all the naming sorting method. It sorts files into folders depending on what they start with
 */
public class NameSort extends Sorters{
	
	public void sort(){
		
		File dir[] = this.getFilesList();	//gets the list of files in the directory
		
		//loops through all files in the directory
		for( File f: dir){
			
			char first = f.getName().trim().charAt(0);
			String savepath = "null";
			
			if( (65 <= first && first <= 90) || (97 <= first && first <= 122)){ //actual letters
				savepath = this.getDirPath() + "/" + String.valueOf(first).toUpperCase();
			}
			else if( 48 <= first && first <= 57 ){ //numbers
				savepath = this.getDirPath() + "/" + "0-9";
			}
			else{//other symbols
				savepath = this.getDirPath() + "/" + "Other";
			}
			
			File newDir = new File(savepath);					
			newDir.mkdir();										//creates dir for that year
			f.renameTo(new File(savepath + "/" + f.getName() ) ); //moves file to that directory
		}
		
	}
}
