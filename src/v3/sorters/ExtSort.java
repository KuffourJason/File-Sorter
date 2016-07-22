package v3.sorters;

import java.io.File;
import java.util.HashMap;

public class ExtSort extends Sorters {
	
	private HashMap<String,String> extName; //file extensions are the key, and the values are the assigned names
	
	/**
	 * 
	 */
	public ExtSort(){
		this.extName = new HashMap<String, String>();
	}
	
	/**
	 * @param names - the new map containing the file exts and their assigned names
	 */
	public void setNames( HashMap<String,String> names){
		this.extName = names;
		
		for( String na: this.extName.keySet()){
			System.out.println(na + " " + this.extName.get(na));
		}
	}
	
	/**
	 * @return - a hashmap of strings containing all the detected file extensions as the key and the 
	 * assigned name as it's value. For newly detected ext, empty string is assigned
	 */
	public HashMap<String, String> extensions(){
		
		File dir[] = this.getFilesList();	//gets the list of files in the directory
		
		//loops through all files in the directory
		for( File f: dir){
			
			//first checks if the file is a folder 
			//and skips it if it is
			if( f.isDirectory() ){
				continue;
			}
			else{
				
				int end = f.getName().length();							//gets the length of the file name
				int start = f.getName().trim().lastIndexOf(".", end) + 1;   //gets the starting index of the index
				
				//if the file has no extension then it skips it
				if( start == 0 ){
					continue;
				}
				else{
					String ext = f.getName().substring(start, end );  //gets the extension of the file
					
					//if file ext does not already have an assigned name
					if( !this.extName.containsKey(ext)){
						this.extName.put(ext, "");						  
					}
				}
			}
		}
		
		return this.extName;
	}
	
	public void sort() {
		File dir[] = this.getFilesList();	//gets the list of files in the directory
		
		//loops through all files in the directory
		for( File f: dir){
			
			//first checks if the file is a folder 
			//and skips it if it is
			if( f.isDirectory() ){
				continue;
			}
			else{
				
				int end = f.getName().length();							//gets the length of the file name
				int start = f.getName().trim().lastIndexOf(".", end) + 1;   //gets the starting index of the index
				
				//if the file has no extension then it skips it
				if( start == 0){
					continue;
				}
				else{
					String ext = f.getName().substring(start, end );  //gets the extension of the file
					String savepath = "null";
								
					String folderName = (this.extName.get(ext).isEmpty()) ? ext : this.extName.get(ext);		//gets the assigned name for the extension. If none, it uses the ext name
					savepath = this.getDirPath() + "/" + folderName;
					
					File newDir = new File(savepath);										
					newDir.mkdir();										//creates dir for that extension
					f.renameTo(new File(savepath + "/" + f.getName() ) ); //moves file to that directory
				}
				
			}
		}
	}
	

}
