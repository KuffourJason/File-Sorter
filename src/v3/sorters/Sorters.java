package v3.sorters;

import java.io.File;
import java.util.ArrayList;

/**
 * @author jay
 *
 */
public abstract class Sorters {

	private String dirPath;	        //folder path to sort
	private boolean delEmpDir;      //boolean to delete empty directories
	private File filesToBeSorted[]; //list of files to be sorted within directory

	
	/**
	 * @param directory - the path to the folder to be sorted
	 * @return - returns either true or false depending on whether the folder is a non-empty directory
	 */
	public boolean setDirPath(String directory){
		File path = new File(directory);
		
		//checks if path specified is a directory and is not empty
		if(path.isDirectory() && path.listFiles().length != 0 ){
			this.dirPath = directory;
			this.filesToBeSorted = path.listFiles();
			return true;
		}
		
		return false;
	}
	
	/**
	 * @param directory - returns a valid file path that has been specified, or empty string
	 * @return
	 */
	public String getDirPath(){
		return dirPath;
	}
	
	/**
	 * @return -  a boolean that returns whether a valid directory path has been specified
	 */
	public boolean isDirPathSet(){
		return !this.dirPath.isEmpty();
	}
	
	/**
	 * @param ans - a boolean to set whether empty directories should be deleted during sorting. Default is false
	 */
	public void setDelEmpDir(boolean ans){
		this.delEmpDir = ans;
	}
	
	/**
	 * @return - boolean that specifies whether empty folders should be deleted during the sorting process
	 */
	public boolean getDelEmpDir(){
		return this.delEmpDir;
	}
	
	/**
	 * @return - a list of files that are in the current valid directory to be sorted or null otherwise
	 */
	public File[] getFilesList(){
		return this.filesToBeSorted;
	}
	
	/**
	 * This is a an abstract method that must be implemented by the sub classes
	 */
	public abstract void sort();
	
	
	public static void main(String args[]){
		Sorters test = new SizeSort();
		test.setDelEmpDir(true);
		test.setDirPath("C:/Users/jay/Desktop/yu");
		test.sort();
	}
}
