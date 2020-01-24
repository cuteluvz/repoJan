Tool that parses a weather report given in a .csv format and displays it on the UI.

weatherReport.html displays a table of Station Name, Date and Mean Temperature.
                   Clicking on the mean temperature will take to a different page that lists out the details of that reading.
                   
Technologies/Frameworks used:
*Java/Java 8
*Spring Boot
*Spring MVC
*Thymeleaf
*Maven
*SLF4j Logging
*Apache Commons CSV

*Running the application locally*
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.arc.sbtest.SBtemplateApplication class from your IDE.

1. Download the zip or clone the Git repository.
2. Unzip the zip file (if you downloaded one)
3. Open Command Prompt and Change directory (cd) to folder containing pom.xml
4. Open Eclipse
5. File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
6. Select the project
7. Choose the Spring Boot Application file (search for @SpringBootApplication)
8. Right Click on the file and Run as Java Application
9. Alternatively you can use the Spring Boot Maven plugin like so:
mvn spring-boot:run

URLs:
http://localhost:8080/	Landing Page that displays the weather report
