package v3.data.wrappers;

/**
 * @author jay
 *
 *	Helper class for the SaveItem class. This is a wrapper class for a specific sort option
 */
public class SaveOption {

	private String sortType;
	private String param1;
	private String param2;
	private String param3;
	
	/**
	 * The constructor
	 * 
	 * @param sort - the name of the sorter 
	 * @param p1 - the first possible argument to the sorter
	 * @param p2 - the second possible argument
	 * @param p3 - the third possible argument
	 */
	public SaveOption(String sort, String p1, String p2, String p3){
		this.sortType = sort;
		this.param1 = p1;
		this.param2 = p2;
		this.param3 = p3;
	}
	
	/**
	 * @return - the sorter to use
	 */
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * @param sortType - the sorter to save
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	/**
	 * @return - the first argument for the sorter
	 */
	public String getParam1() {
		return param1;
	}
	
	/**
	 * @param param1 - the first argument for the sorter
	 */
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	
	/**
	 * @return - the second argument for the sorter
	 */
	public String getParam2() {
		return param2;
	}
	
	/**
	 * @param param2 - the second argument for the sorter
	 */
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	
	/**
	 * @return - the third argument for the sorter
	 */
	public String getParam3() {
		return param3;
	}
	
	/**
	 * @param param3 - the third argument for the sorter
	 */
	public void setParam3(String param3) {
		this.param3 = param3;
	}

}
