package v3.data;

import java.util.List;

/**
 * @author jay
 *
 */
public class History {

	private String date;
	private List<HistoryItem> items;
	
	/**
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public List<HistoryItem> getItems() {
		return items;
	}

	/**
	 * @param items
	 */
	public void setItems(List<HistoryItem> items) {
		this.items = items;
	}


	/**
	 * @author jay
	 *
	 */
	public class HistoryItem{
		
		private String folderName;
		private String sortMethod;
		private String time;
		
		/**
		 * @return
		 */
		public String getFolderName() {
			return folderName;
		}
		
		/**
		 * @param folderName
		 */
		public void setFolderName(String folderName) {
			this.folderName = folderName;
		}
		
		/**
		 * @return
		 */
		public String getSortMethod() {
			return sortMethod;
		}
		
		/**
		 * @param sortMethod
		 */
		public void setSortMethod(String sortMethod) {
			this.sortMethod = sortMethod;
		}
		
		/**
		 * @return
		 */
		public String getTime() {
			return time;
		}
		
		/**
		 * @param time
		 */
		public void setTime(String time) {
			this.time = time;
		}
	}
	
}
