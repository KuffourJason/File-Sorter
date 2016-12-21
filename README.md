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
  The second version was implemented in Java and Java Swing. Started in the beginning of 2015 and ended in late 2016.
  
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
  This version was abandoned in late 2015 in favor of implementing version 3 with newly developed skills and framework

<a name="headers"/>
### Version 3.0

<a name="headers"/>
##### Features
<a name="headers"/>
#### Design
<a name="headers"/>
#### Status

<a name="headers"/>
## Future
