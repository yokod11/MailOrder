<%-- 
    Document   : trackDelivery
    Created on : 27-Apr-2020, 13:23:26
    Author     : sheral-annthompson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Track Delivery</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="./css/stylesheet.css">
</head>
<body>

<ul>
    <li><a class="active" href="./index.jsp">Home</a></li>
    <li><a href="./get-trackingNumber.jsp">Apply for Delivery</a></li>
    <li><a href="./trackDelivery.jsp">Track Delivery</a></li>
</ul>
<!-- JSP Body
---->
<section>
    <article>
        <div class="column">
        	<!-- Get form parameters from getDataServlet.java ---->

            <form method="get" action ="getDataServlet">

            <label for="newTrackNum">Enter Tracking Number </label>
            <br><br>
            <input type="text" name="newTrackNum" id ="newTrackNum" required/>
             <br>
             <br>
            <button type="submit" name="submit" value="Apply">Submit</button>
            </form>
        </div>
        </article>
  </section>
  <!-- JSP Body END
---->
</body>
<html>