package v3.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import v3.data.wrappers.ExtensionItem;
import v3.data.wrappers.Extensions;
import v3.data.wrappers.History;
import v3.data.wrappers.HistoryItem;
import v3.data.wrappers.Preferences;
import v3.data.wrappers.SaveItem;
import v3.data.wrappers.SaveOption;
import v3.data.wrappers.Saves;

/**
 * @author jay
 *
 */
public class DataFacade {	
	private DataHandler<History> historyHandler;
	private DataHandler<Saves> savesHandler;
	private DataHandler<Extensions> extsHandler;
	private DataHandler<Preferences> prefHandler;
	
	private Saves saves;
	private History history;
	private Extensions exts;
	private Preferences prefs;
	
	/**
	 * 
	 */
	public DataFacade(){
		DataManager manager = DataManager.getDataManager();
		this.historyHandler = new DataHandler<History>(manager.getHistoryFile(), History.class);
		this.savesHandler   = new DataHandler<Saves>(manager.getSaveFile(), Saves.class);
		this.extsHandler    = new DataHandler<Extensions>(manager.getExtensionsFile(), Extensions.class);
		this.prefHandler    = new DataHandler<Preferences>(manager.getPreferencesFile(), Preferences.class);

	}
	
	/**
	 * 
	 */
	public void loadData(){
		this.history = this.historyHandler.getData();
		this.saves   = this.savesHandler.getData();
		this.exts    = this.extsHandler.getData();
		this.prefs   = this.prefHandler.getData();
	}
	
	/**
	 * 
	 */
	public void saveData(){
		this.extsHandler.saveData(this.exts);
		this.savesHandler.saveData(this.saves);
		this.historyHandler.saveData(this.history);
		this.prefHandler.saveData(this.prefs);
	}	
	
	/**
	 * @return
	 */
	public HashMap<String, String> getExtensions(){
		
		HashMap<String, String> ret = new HashMap<String, String>();
		
		for(ExtensionItem i: this.exts.getExtensions()){
			ret.put(i.getFileExt(), i.getReName());
		}
		
		return ret;
	}
	
	/**
	 * @param newExts
	 */
	public void setExtensions( HashMap<String,String> newExts){
		
		List<ExtensionItem> newList = new ArrayList<ExtensionItem>();
		
		for(String k: newExts.keySet()){
			newList.add(new ExtensionItem(k, newExts.get(k)) );
		}
		
		this.exts.setExtensions(newList);
	}
	
	/**
	 * @return
	 */
	public List<HistoryItem> getHistory(){
		return this.history.getItems();
	}
	
	/**
	 * @param history
	 */
	public void setHistory( List<HistoryItem> history){
		this.history.setItems(history);
	}
	
	public HashMap<String, List<SaveOption>> getSaved(){
		
		HashMap<String, List<SaveOption>> ret = new HashMap<String, List<SaveOption>>();
		
		for(SaveItem i: this.saves.getSaveItem()){
			ret.put(i.getName(), i.getSortOptions() );
		}
		
		return ret;
	}
	
	/**
	 * @param saved
	 */
	public void setSaved( HashMap<String, List<SaveOption>> saved){
		
		List<SaveItem> newList = new ArrayList<SaveItem>();
		
		for( String name: saved.keySet() ){
			newList.add( new SaveItem(name, saved.get(name)) );
		}
		
		this.saves.setSaveItem(newList);
	}
	
	/**
	 * @return
	 */
	public HashMap<String, String> getPreferences(){
		
		HashMap<String, String> ret = new HashMap<String, String>();
		
		ret.put("saveHistory", this.prefs.getSaveHistory());
		ret.put("deleteEmpty", this.prefs.getDeleteEmptyFolder() );
		ret.put("sortSub", this.prefs.getSortSubFolder() );
		
		return ret;
	}
	
	/**
	 * @param prefer
	 */
	public void setPreferences(HashMap<String, String> prefer){
		
		this.prefs.setDeleteEmptyFolder(prefer.get("deleteEmpty"));
		this.prefs.setSaveHistory("saveHistory");
		this.prefs.setSortSubFolder("sortSub");
	}
	
	public static void main(String args[] ){
		
		DataFacade test = new DataFacade();
		test.loadData();
		
		HashMap<String, List<SaveOption>> hold = test.getSaved();
		
		for( String t: hold.keySet()){
			for(SaveOption o: hold.get(t) ){
				System.out.println("The name is " + t + " and the sorting option is " + o.getSortType() );
			}
		}
		
		List<SaveOption> ne = new ArrayList<SaveOption>();
		ne.add(new SaveOption("ext", "", "", "") );
		ne.add(new SaveOption("name", "", "", "") );
		ne.add(new SaveOption("recursive", "", "", "") );
		
		hold.put("quicksort", ne);
		
		test.setSaved(hold);
		test.saveData();
	}
}
