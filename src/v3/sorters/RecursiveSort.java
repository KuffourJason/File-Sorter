package v3.sorters;

public class RecursiveSort extends Sorters{

	private Sorters sortSub[];
	
	public RecursiveSort(Sorters subDir[]){
		this.sortSub = subDir.clone();
	}
	
	@Override
	public void sort() {
		
		for( Sorters sub: sortSub){
			sub.sortDirectory();
		}
	}

}
