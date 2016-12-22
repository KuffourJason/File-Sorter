# File-Sorter

  A desktop application, developed in Java, to sort the files in a directory according its name.

* [Background](#headers)  
* [Versioning](#headers) <br/>
  * [Version 1.0](#headers) <br/>
    * [Features](#headers) <br/>
    * [Design](#headers) <br/>
    * [Status](#headers) <br/>
  * [Version 2.0](#headers) <br/>
    * [Features](#headers) <br/>
    * [Design](#headers) <br/>
    * [Status](#headers) <br/>
  * [Version 3.0](#headers) <br/>
    * [Features](#headers) <br/>
    * [Design](#headers) <br/>
    * [Status](#headers) <br/>
* [Future](#headers) <br/>

<a name="headers"/>
## Background

  This project began, in the summer of 2014, as a simple Java program meant to sort google chrome's download folder according to a file's extension type. It was meant as a way to apply and enhance my Java skills I learnt so far in university ( 2nd year ). As time progressed and my programming knowledge expanded, I decided to build upon this program and develop it into a desktop application as a way to apply my new skills. 

<a name="headers"/>
## Versioning

 There are currently 3 versions of the File Sorter program that have been developed or in the current development. Each successive version, reflects the usage of a new framework as well as the implementation of new features and enhancements. 

<a name="headers"/>
### Version 1.0
  The initial version of the File Sorter program was implemented in Java and used the Java Swing framework to notify the user of an error or completion. It involves no user interaction and is executed by simply running the jar.
  
<a name="headers"/>
#### Features
* Only sorted chrome's download folder
* Sorted files with the extensions ppt, pdf, docx, msi, and zip into folders with those specific names. 
* Placed all other files into another folder called miscellaneous
* Notified the user of completion and any errors through a pop up widget designed in Java swing

<a name="headers"/>
#### Design
* Consisted of two Java classes. 
* One class (GUI.java) implemented the completion and error widget
* The other class (logic.java) contained the sorting method as well as the main method

<a name="headers"/>
#### Status
  This version was completed in 2014.

<a name="headers"/>
### Version 2.0
  The second version was implemented in Java and Java Swing. It was started in the beginning of 2015 and ended in late 2015.
  
<a name="headers"/>
#### Features
* Implemented all the features of version 1
* Added feature to sort files within the main 6 folders, according to either the month it was created or by year
* A new interactive User interface to specify which folder the user wanted to be sorted as well as them specifying whether they wanted to sort files by creation date

<a name="headers"/>
#### Design
* Implemented using the MVC design pattern
* Model (Sorting.java),  View (GUI2.java) and Controller (logic.java)

<a name="headers"/>
#### Status
  This version was abandoned in late 2015 in favor of implementing version 3 with newly developed skills and frameworks

<a name="headers"/>
### Version 3.0
  The third version began in December 2015 and is still ongoing. It is implemented using Java and the user inferface is implemented using QtJambi, the Java implementation of the Qt framework. The QtJambi framework  is the main reason why version 2.o was abandoned because it a better UI building tool  than swing.
  
<a name="headers"/>
##### Features
* New and improved fully interactive user interface
* Allows the user to select which folder they want to be sorted, as well as save their selection for future use
* Files can now be sorted by their extension (any extension type), name, size, and creation date
* Folders, to which all files of the same extension are sorted to, can be given specific names or left as the extension type
* Allows the user to define their own sorting criteria by using the base sorting options
* Users can now 'unsort' a given directory
* The application now saves the users history, preferences and sorting options to the computer
* Users can also specify how sub directories can be sorted

<a name="headers"/>
#### Design
* The overall application is designed using the MVC design pattern
* The model consists of the data and sorters packages
  * Classes in the data package are responsible for loading and saving data to and from the system. It was designed using the Facade      pattern 
   * Classes in the sorters package contain the basic sorting methods that can be used. It was designed using both the template design patter and the composite pattern
 *  The View consists of the UI package and contains all the code related to the user interface. The classes in this package are code using the QtJambi framework
 * The controller has yet to be implemented

<a name="headers"/>
#### Status
  The development of this version is still ongoing. Expected completion is in February 2016

<a name="headers"/>
## Future
