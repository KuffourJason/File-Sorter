package v3.data;

import java.util.List;

/**
 * @author jay
 *
 */
public class History {

	private List<HistoryItem> historyItems;
	

	public History( List<HistoryItem> list){
		this.historyItems = list;
	}
	
	/**
	 * @return
	 */
	public List<HistoryItem> getItems() {
		return historyItems;
	}

	/**
	 * @param items
	 */
	public void setItems(List<HistoryItem> items) {
		this.historyItems = items;
	}

	

	
	
}
