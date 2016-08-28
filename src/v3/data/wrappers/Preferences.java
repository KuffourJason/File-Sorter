package v3.data.wrappers;

public class Preferences {

	private String saveHistory;
	private String sortSubFolder;
	private String deleteEmptyFolder;
	
	public Preferences(String save, String sort, String delete){
		
	}
	
	public String getSaveHistory() {
		return saveHistory;
	}
	
	public void setSaveHistory(String saveHistory) {
		this.saveHistory = saveHistory;
	}
	
	public String getSortSubFolder() {
		return sortSubFolder;
	}
	
	public void setSortSubFolder(String sortSubFolder) {
		this.sortSubFolder = sortSubFolder;
	}
	
	public String getDeleteEmptyFolder() {
		return deleteEmptyFolder;
	}
	
	public void setDeleteEmptyFolder(String deleteEmptyFolder) {
		this.deleteEmptyFolder = deleteEmptyFolder;
	}
	
}
