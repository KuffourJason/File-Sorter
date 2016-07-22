package v3.data;

import java.io.File;

public class Saves {

	 public static void main(String[] args) {
	        String path = null;
	        String osName = System.getProperty("os.name").toLowerCase();
	        if (osName.indexOf("windows")>-1) {
	            path = System.getenv("APPDATA");
	        } else if (osName.indexOf("mac")>-1) {
	            // get the env. variable for Mac..
	            path = System.getenv("?");
	            // etc. for Linux, Unix, Solaris..
	        } else { //anything else
	            path = System.getProperty("user.home");
	        }
	        File rootOfPath = new File(path);
	        // create a sub-directory based on package name of main class..
	        // perhaps prefixed with with java/appdata
	        System.out.println(rootOfPath);
	    }
}
