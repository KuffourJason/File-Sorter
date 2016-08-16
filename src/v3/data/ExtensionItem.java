package v3.data;

public class ExtensionItem {
	private String fileExt;
	private String reName;

	public ExtensionItem(String fileExt, String reName) {
		this.fileExt = fileExt;
		this.reName = reName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getReName() {
		return reName;
	}

	public void setReName(String reName) {
		this.reName = reName;
	}
}