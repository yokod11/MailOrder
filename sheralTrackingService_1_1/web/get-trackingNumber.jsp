<%-- 
    Document   : get-trackingNumber
    Created on : 27-Apr-2020, 14:04:35
    Author     : sheral-annthompson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delivery Company</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="./css/stylesheet.css"><!-- Include stylesheet.css ---->
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
                    <form method="post" action ="trackingNumberServlet">

                        <label for="email">Enter Email Address </label>
                        <br><br>

                        <input type="text" name="email" id ="email" placeholder="" required/>
                        <br><br>
                        <label for="description">Select parcel description</label>
                        <br><br>
                        <select name="description" id="description">
                            
                            <optgroup label="Technology">
                                <option value="batteries">contains batteries</option>
                                <option value="liquid">contains liquid</option>
                            </optgroup>
                            <optgroup label="Food">
                                <option value="meat">contains meat</option>
                                <option value="fish">contains fish</option>
                            </optgroup>
                             <optgroup label="other">
                                <option value="chemicals">contains chemicals</option>
                                <option value="fragile">fragile</option>
                            </optgroup>
                        </select>
                        <br><br>
<!--
                        <label for="description">Enter description of parcel</label>
                        <br><br>

                        <input type="text" name="description" id ="description" placeholder="" required/>
                        <br><br>-->

                        <label for="postcode">Enter post code for delivery</label>
                        <br><br>

                        <input type="text" name="postcode" id ="postcode" placeholder="" required/>
                        <br><br>

                        <br>
                        <br>
                        <button type="submit" name="submit" value="Apply">Submit</button>
                    </form>
            </article>
        </section>
        <!-- JSP Body END
        ---->
    </body>
</html>
