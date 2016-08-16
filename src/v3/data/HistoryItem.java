package v3.data;

public class HistoryItem {
	
	public String folderName;
	public String sortMethod;
	public String time;
	public String date;

	public HistoryItem(String folderName, String sortMethod, String time, String date) {
		this.folderName = folderName;
		this.sortMethod = sortMethod;
		this.time = time;
		this.date = date;
	}
	
	
	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getSortMethod() {
		return sortMethod;
	}

	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}