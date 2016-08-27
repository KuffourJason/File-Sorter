package v3.data;

import java.util.List;

//History   : [DATE, FOLDER, sort method, time ]

/**
 * @author jay
 *
 * This is a wrapper class for the history of folders sorted
 */
public class History {

	private List<HistoryItem> historyItems; //The list of when, where and how folders were sorted 
	

	/**
	 * Constructor
	 * 
	 * @param list - the history of folders sorted
	 */
	public History( List<HistoryItem> list){
		this.historyItems = list;
	}
	
	/**
	 * @return - the history of folders sorted
	 */
	public List<HistoryItem> getItems() {
		return historyItems;
	}

	/**
	 * @param items - the updated history of folders sorted
	 */
	public void setItems(List<HistoryItem> items) {
		this.historyItems = items;
	}

	

	
	
}
