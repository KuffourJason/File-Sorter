package v3.data;

import java.util.List;

/**
 * @author jay
 *
 *	This is a wrapper class used to store the user defined extensions folder as json
 */
public class Extensions {

	private List<ExtensionItem> extensions;		//the list of extensions and their corresponding folder name
	

	/**
	 * The constructor
	 * 
	 * @param list - the list of updated file extension - folder name pairs
	 */
	public Extensions(List<ExtensionItem> list){
		this.extensions = list;
	}
	
	/**
	 * @return - this list of file extensions and their corresponding folder name
	 */
	public List<ExtensionItem> getExtensions() {
		return extensions;
	}

	/**
	 * @param extensions - new list of file extensions and their corresponding folder names
	 */
	public void setExtensions(List<ExtensionItem> extensions) {
		this.extensions = extensions;
	}
}
