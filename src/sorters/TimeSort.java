package sorters;

import java.io.File;
import java.util.Calendar;

/**
 * @author jay
 * This class contains all the time related sorting methods
 */
public class TimeSort extends Sorters{
	
	private String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private String sortType;
	
	
	/**
	 * @param sortType - this can either be 'year', 'month' or 'time'. If a invalid sortType is specified it
	 * defaults to year
	 */
	public TimeSort(String sortType){
		if(sortType != "year" && sortType != "month" && sortType != "time" ){
			this.sortType = "year";
		}
		else{
			this.sortType = sortType;
		}
	}
	 
	/**
	 * This method sorts the files by the year they were modified
	 */
	private void sortByYear() {
		File dir[] = this.getFilesList();	//gets the list of files in the directory
		
		//goes through each file and places them in the folder corresponding to the year 
		//they were modified
		for( File f: dir ){
			Calendar time = Calendar.getInstance(); 
			time.setTimeInMillis(f.lastModified());
			int year = time.get(Calendar.YEAR);    //calculates year modified data using the seconds which is in long
			
			String savepath = this.getDirPath() + "/" + year;
			File newDir = new File(savepath);
			newDir.mkdir();										//creates dir for that year
			
			f.renameTo(new File(savepath + "/" + f.getName() ) ); //moves file to that directory
		}
	}
	
	/**
	 * This method sorts the files based on the month in which they were modified
	 */
	private void sortByMonth(){
		File dir[] = this.getFilesList();	//gets list of folders in the dir
		
		//goes through each file and places them in the folder corresponding to the month
		//they were modified
		for(File f: dir){
			Calendar time = Calendar.getInstance();
			time.setTimeInMillis(f.lastModified());
			int ti = time.get(Calendar.MONTH);  //gets the hour the folder was modified based on seconds in long
			
			String savePath = this.getDirPath() + "/" + months[ti];
			File newDir = new File( savePath );
			newDir.mkdir();											//makes no dir for that month, if it doesn't exist already
			f.renameTo(new File(savePath + "/" + f.getName() ) );	//moves file to that dir
		}
	}
	
	/**
	 * this method sorts the files based on the time of day they were modified
	 */
	private void sortByTime() {
		
		File dir[] = this.getFilesList();	//gets list of folders in the dir
		
		//creates string paths to the folder of the time of day
		String morn = this.getDirPath() + "/" + "morning(6am - 12pm)";
		String afte = this.getDirPath() + "/" + "afternoon(12pm - 6pm)";
		String even = this.getDirPath() + "/" + "evening(6pm - 12am)";
		String nigh = this.getDirPath() + "/" + "night(12am - 6am)";
		
		//goes through each file and places them in the folder corresponding to the time 
		//they were modified
		for( File f: dir ){
			Calendar time = Calendar.getInstance();
			time.setTimeInMillis(f.lastModified());
			int ti = time.get(Calendar.HOUR_OF_DAY);  //gets the hour the folder was modified based on seconds in long
			
			File newDir; //the dir for each time of day
			
			if(ti >= 6 && ti < 12 ){  //morning
				newDir = new File(morn );
				newDir.mkdir();									  //makes new dir for time of day	
				f.renameTo(new File(morn + "/" + f.getName() ) ); //moves file to new location
			}
			else if(ti >= 12 && ti < 18){ //afternoon
				newDir = new File(afte);
				newDir.mkdir();									 //makes new dir for time of day
				f.renameTo(new File(afte + "/" + f.getName() ) ); //moves file to new location
			}
			else if( ti >= 18 && ti < 24){
				newDir = new File(even);
				newDir.mkdir();									 //makes new dir for time of day
				f.renameTo(new File(even + "/" + f.getName() ) ); //moves file to new location
			}
			else{ //night
				newDir = new File(nigh);
				newDir.mkdir();									 //makes new dir for time of day
				f.renameTo(new File(nigh + "/" + f.getName() ) ); //moves file to new location
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see sorters.Sorters#sort()
	 */
	public void sort(){
		if(sortType == "year"){
			this.sortByYear();
		}
		else if(sortType == "month"){
			this.sortByMonth();
		}
		else{
			this.sortByTime();
		}
	}
}
