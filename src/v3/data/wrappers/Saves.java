package v3.data.wrappers;

import java.util.List;

/**
 * @author jay
 *
 * This is a wrapper class for the json data used to save the users
 * sorting preferences
 */
public class Saves {

		private List<SaveItem> saveItem; //list of user saved sorting preferences
		
		//Save      : NAME, [ list of sorting options]
		
		public Saves(List<SaveItem> saveItem){
			this.saveItem = saveItem;
		}
		
		/**
		 * @return - the list of user saved sorting prefereences
		 */
		public List<SaveItem> getSaveItem() {
			return saveItem;
		}

		/**
		 * @param saveItem - the updated list of user saved sorting preferences
		 */
		public void setSaveItem(List<SaveItem> saveItem) {
			this.saveItem = saveItem;
		}
}
