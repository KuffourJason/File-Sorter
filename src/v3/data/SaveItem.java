package v3.data;

import java.util.List;

/**
 * @author jay
 *
 *	Helper class for the Saves class. This class acts a wrapper class for storing the sorting options used
 *  in this preference
 */
public class SaveItem {

	private String name; 				//name of the saved sorting preference
	private List<SaveOption> sortOptions;	//the list of sorting types saved in this item
	
	/**
	 * The constructor
	 * 
	 * @param name
	 * @param options
	 */
	public SaveItem(String name, List<SaveOption> options){
		this.name = name;
		this.sortOptions = options;
	}
	
	/**
	 * @return - the name of the user defined sorting preference
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name - the new name of the preference
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return - the sorting options used in this preference
	 */
	public List<SaveOption> getSortOptions() {
		return sortOptions;
	}
	
	/**
	 * @param sortOptions - the new sorting options to be associated with this preference
	 */
	public void setSortOptions(List<SaveOption> sortOptions) {
		this.sortOptions = sortOptions;
	}
}
