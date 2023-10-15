# ParkingLotExample

Example for a Parking Lot Web App coded in Java Web, using JPA (Hibernate) and integrated with SQL. This example is used for the Software Engineering taught by Prof. H. Rocha at Loyola University Maryland.

## Installing / Configuring Java Web

Make sure you have IntelliJ Ultimate Edition. It must be the **Ultimate** Edition, the community/free version do not have proper tools nor the support for Java Web. As students you can request a [free license](https://www.jetbrains.com/community/education/#students).

Next please follow the IntelliJ Tutorial for your [First JavaEE Application](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-ee-application.html). If you can compile and run the tutorial, then you know your system is properly configured for Java Web.

The next step is optional, but it will improve your productivity. Follow this tutorial on how to create a [Servlet Template](https://www.jetbrains.com/help/idea/creating-and-configuring-web-application-elements.html). 

## Database

I am using a MySQL database installed locally. I am using [MySQL Community Server](https://dev.mysql.com/downloads/mysql/) which is free for personal and educational uses. You may also want to download [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) to help you write queries and inspect the Database.

Be sure to change the content on the [persistence.xml](src/main/resources/META-INF/persistence.xml) with your Database (URL, User, Password). Also please pay attention that there are two Databases in that configuration file, one for Production and another for Test.

If you want to use another database instead of MySQL, you need to add the appropriate Java Driver (or JDBC Connector) to the [pom.xml](pom.xml) and click on the maven icon for it to download this driver and build it into the project. 

## Code Coverage

ItelliJ uses its own framework for coverage. Unfortunately, such framework lacks Branch Coverage. Therefore, I added [Jacoco](https://www.jacoco.org/jacoco/) as the main coverage framework. 

You may need to configure your IntelliJ to use Jacoco instead of its own, on this [StackOverflow Answer](https://stackoverflow.com/questions/43500774/jacoco-with-intellij) it is detailed how to do so (please dont go for the first answer, but the one about "Community 2022.1 & Community 2022.2" bellow, also upvote this answer if possible).

After running your test *with Coverage*, go to the IntelliJ menu "Run -> Generate Coverage Report" to create an HTML report with your coverage. There is an example of such report created by Jacoco in this repository on ```CoverageReport``` folder. If your report does not match the example here (and does not have information on Branches), then you are __not__ using Jacoco but the internal IntelliJ. Go back to the above Stackoverflow link and try again (more carefully this time). 




