package v3.sorters;

import java.io.File;

public class UnSort extends Sorters {

	
	
	@Override
	public void sort() {
		
		File fileList[] = this.getFilesList();
		
		for( File i: fileList){
			this.unsort(i);
		}
	}
	
	private void unsort(File j){
		
		if( j.isDirectory()){
			
			for(File x: j.listFiles()){
				this.unsort(x);
			}
			
		}
		else{
			j.renameTo( new File(this.getDirPath() + "/" +j.getName() ) );
		}
	}

}
