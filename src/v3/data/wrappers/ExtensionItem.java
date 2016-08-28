package v3.data.wrappers;

/**
 * @author jay
 *
 *	Helper class for the Extensions class. This class defines a file extension and it's corresponding folder name
 */
public class ExtensionItem {
	
	private String fileExt; //the file extension
	private String reName;  //the folder to which the file extension belongs to

	/**
	 * The constructor.
	 * 
	 * @param fileExt - the new file extension detected
	 * @param reName - the folder name corresponding to fileExt
	 */
	public ExtensionItem(String fileExt, String reName) {
		this.fileExt = fileExt;
		this.reName = reName;
	}

	/**
	 * @return - the file extension
	 */
	public String getFileExt() {
		return fileExt;
	}

	/**
	 * @param fileExt - the new file extension
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	/**
	 * @return - the folder name for the file extension
	 */
	public String getReName() {
		return reName;
	}

	/**
	 * @param reName - the corresponding folder name
	 */
	public void setReName(String reName) {
		this.reName = reName;
	}
}