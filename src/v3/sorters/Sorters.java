package v3.sorters;

import java.io.File;

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
	
	/**
	 * This is the main method that is called when a folder is to be sorted. It
	 * sorts and handles final cleanup
	 */
	public void sortDirectory(){
		this.sort();
		this.finalCleanUp();
	}
	
	/**
	 * This method handles deleting any empty directories in the main directory after
	 * sorting is complete
	 */
	protected void finalCleanUp(){
		
		//if user specified whether empty directories should be deleted
		if( this.delEmpDir){
			File dir = new File(this.getDirPath());
			File sList[] = dir.listFiles();			//gets the new list of files and folders in the directory
			
			//loops through all files and checks if it is a dir and empty
			for( File l: sList){
				if( l.isDirectory() && l.list().length==0){
					l.delete();
				}
			}
		}
	}
	
	public static void main(String args[]){
		Sorters test = new ExtSort();
		test.setDirPath("C:/Users/jay/Desktop/yu");
		test.setDelEmpDir(true);
		((ExtSort) test).extensions();
		String ne[] = {"database", "initialization", "executable", "", "", "", "", "", "", ""};
		((ExtSort)test).setNames(ne);
		test.sortDirectory();
	}
}
