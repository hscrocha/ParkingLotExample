<%@ page import="edu.loyola.cs.se.parkinglotexample.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Prof. H. Rocha
  Date: 8/4/23
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="components/header.jsp"/>
</head>
<body>
    <jsp:include page="components/title.jsp" />
    <jsp:include page="components/mainmenu.jsp" />
<% User logged = (User) session.getAttribute("User");
   String lightImage = "yellow_light.png";
   if(logged!=null) lightImage = "green_light.png";
%>
    <%-- Here you put the content for this page --%>
    <br/>
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-7">
                <h2 class="text-primary">
                    <img src="images/<%= lightImage %>" style="max-height:50px;" class="img-fluid" />
                    Welcome to CS482 Parking Lot <span class="bi bi-truck-front-fill"></span>
                </h2>
                <% if(logged==null ){ %>

                <p> We take pride on offering our parking services
                    through this webapp to make your parking more convenient.
                    All parking features are fully automated in this webapp,
                or make our regular services more quick and easy just for you.</p>
                <hr/>
                <h3 class="text-primary"> Why use this App? </h3>
                <p> Here is a quick list of reasons why our webapp for parking services are great </p>
                <ul>
                    <li><span class="bi bi-clock-fill"></span> <strong>Save Time:</strong> Our smart technology allows you to find and reserve a parking spot in real-time. No more driving in circles!</li>
                    <li><span class="bi bi-coin"></span> <strong>Save Money:</strong> You will only pay for the time your car was actually in the lot. No more paying for unused hours!</li>
                    <li><span class="bi bi-activity"></span> <strong>Save Patience:</strong> You can do everything in the app except for parking your car (our technology is not there yet). No more lines to pay your parking or to ask someone for help!</li>
                    <li><span class="bi bi-film"></span> <strong>Save Ferris:</strong> Oops, that was from a movie... still a good save.</li>
                </ul>
                <hr/>
                <h3 class="text-primary"> Where do I start? </h3>
                <p> Please <a href="register.jsp">register</a> for free in our webapp, then you can access our main features.
                A quickstart guide will be the first thing you see once you signed up.</p>
                <p> Already registered? Then just <a href="login.jsp">log-in</a> and let's get your parking started.</p>

                <% } else { %>
                <p> Thank you for sign-in for our parking services;
                    whether you are a new or existing customer, we value you
                    using our webapp for your parking needs.</p>
                <p>
                    We take pride on offering great services
                    through this webapp to make your parking more convenient.</p>
                <hr/>
                <h3c class="text-primary"> Quickstart Guide </h3c>
                <ul>
                    <li><b>1. </b> Login, congratz you completed this already!</li>
                    <li><b>2. </b> Click on <a href="#">My Vehicles</a> on top to add/update your
                        vehicle information. This will help us provide the best
                        possible parking spot that can confortable fit your vehicle.
                        You can have multiple vehicles saved for quick check-in and reservations.
                    </li>
                    <li><b>3. </b> Click on <a href="#">Parking</a> on top to select your parking spot.
                    You will be able to check which spots are available and reserve it in advance.
                    </li>
                    <li><b>4. </b>Drive and Park. Unfortunately, this step our webapp cannot automate for you.
                        But the app can guide you to your reserved spot, so that you do not need to drive around
                        looking for an empty one.
                    </li>
                    <li><b>5. </b>Checkout whenever you want to leave, just select your active parking on
                        the <a href="#">Parking menu</a> and select checkout. You can pay using the webapp or generate a QR code
                     to pay at our Kiosks. Easy and convenient.</li>
                    <li><b>6. </b>Drive out of the lot and have a nice day!</li>
                </ul>

                <% } %>

            </div>
            <div class="col-8 col-md-5">
                <img src="images/parkinglot.jpg" class="img-fluid" />
                <br/><br/><br/>
                <img src="images/parkinglot2.jpg" class="img-fluid" />
            </div>
        </div>
    </div>

    <%-- =================================== --%>
    <jsp:include page="components/footer.jsp" />
    <script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
    </script>
</body>
</html>
