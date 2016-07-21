package v3.sorters;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ExtSort extends Sorters {
	
	private ArrayList<String> extNames;
	private ArrayList<String> extens;
	
	public ExtSort(){
		this.extNames = new ArrayList<String>();
		this.extens   = new ArrayList<String>();
	}
	
	public void setNames( String[] names){
		this.extNames.addAll(Arrays.asList(names) );
		
		for( String na: this.extNames){
			System.out.println(na);
		}
	}
	
	public ArrayList<String> extensions(){
		
		File dir[] = this.getFilesList();	//gets the list of files in the directory
		ArrayList<String> exts = new ArrayList<String>();
		
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

					if(!exts.contains(ext)){
						exts.add(ext);
					}
				}
			}
		}
		this.extens = exts;
		return exts;
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
					
					
					//////////////// Add real naming stuff here Below
					String savepath = "null";
					
					int extNameIndex = this.extens.indexOf(ext);
			
					String folderName = ( this.extNames.get(extNameIndex).isEmpty() ) ? ext.toLowerCase() : this.extNames.get(extNameIndex);
					savepath = this.getDirPath() + "/" + folderName;
					
					File newDir = new File(savepath);										
					newDir.mkdir();										//creates dir for that extension
					f.renameTo(new File(savepath + "/" + f.getName() ) ); //moves file to that directory
				}
				
			}
		}
	}
	

}
