# Spring console application

Problem Statement - Taking 2 file paths (JSON & CSV) as command line arguments and read the data of both the files and display the data in output.
<img width="95%" src="https://github.com/lakshygupta/Java_Spring-JSON-CSV-File-Reader/blob/main/Output.png" />
(Sample format of JSON and CSV file attached in repo)

### How to run
1. Import the java-assignment project in STS / Eclipse.

2. Run as maven build 
	Run Configurations
		- Goals : clean install
		- check : skip tests

3. A Jar file will be generated for the project in path : java-assignment\target

4. open cmd and write following command
	java -jar D:\Builds\java.assignment-0.0.1-SNAPSHOT.jar C:\Users\Dell\Desktop\Book1.csv C:\Users\Dell\Desktop\myjson.json
                     
Note : ensure to give complete paths for jar, json and csv files
