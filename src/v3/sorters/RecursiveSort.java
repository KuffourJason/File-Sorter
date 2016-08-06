package v3.sorters;

/**
 * @author jay
 *
 */
public class RecursiveSort extends Sorters{

	private Sorters sortSub[];
	
	public RecursiveSort(Sorters subDir[]){
		this.sortSub = subDir.clone();
	}
	
	/* (non-Javadoc)
	 * @see v3.sorters.Sorters#sort()
	 */
	@Override
	public void sort() {
		
		for( Sorters sub: sortSub){
			sub.sortDirectory();
		}
	}

}
