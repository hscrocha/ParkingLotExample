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




