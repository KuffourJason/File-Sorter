package v3.data.wrappers;

/**
 * @author jay
 *
 *	This is a helper class for History class. It is a wrapper class to store the history of folders actually sorted 
 */
public class HistoryItem {
	
	private String folderName; //the folder that was sorted
	private String sortMethod; //the method used to sort the folder
	private String time; 	   //the time the folder was sorted
	private String date; 	   //the date the folder was sorted

	/**
	 * The constructor
	 * 
	 * @param folderName - the folder that was sorted
	 * @param sortMethod - the method used to sort it
	 * @param time	- the time at which it was sorted
	 * @param date - the date it was sorted
	 */
	public HistoryItem(String folderName, String sortMethod, String time, String date) {
		this.folderName = folderName;
		this.sortMethod = sortMethod;
		this.time = time;
		this.date = date;
	}
	
	/**
	 * @return - name of folder sorted
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * @param folderName - name of folder sorted
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	/**
	 * @return - the sort method used to sort it
	 */
	public String getSortMethod() {
		return sortMethod;
	}

	/**
	 * @param sortMethod - the sort method used to sort it
	 */
	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}

	/**
	 * @return - the time the folder was sorted
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time - the time the folder was sorted
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return -  the date the folder was sorted
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date - the date the folder was sorted
	 */
	public void setDate(String date) {
		this.date = date;
	}


}