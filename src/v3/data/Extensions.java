package v3.data;

import java.util.List;

/**
 * @author jay
 *
 */
public class Extensions {

	private List<ExtensionItem> extensions;
	

	public Extensions(List<ExtensionItem> list){
		this.extensions = list;
	}
	
	/**
	 * @return
	 */
	public List<ExtensionItem> getExtensions() {
		return extensions;
	}

	/**
	 * @param extensions
	 */
	public void setExtensions(List<ExtensionItem> extensions) {
		this.extensions = extensions;
	}
}
