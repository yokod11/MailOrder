/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**  Import classes
*/

import driver.TrackingServiceInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sheral-annthompson
 */


public class trackingNumberServlet extends HttpServlet implements TrackingServiceInterface { /** Class extends HttpServlet.java*/

/**  Class extends TrackingServiceInterface interface to access Abstract generateTrackingNumber Method
*/

    Connection myConn;
    Statement myStmt;
    String trackingNumber = "";
    String  email, description, postcode;
    String dburl = "jdbc:mysql://localhost:3306/accounts"; /** Assign Database URL to String variable */

/**   generateTrackingNumber method uses a for loop to generate random String Int combination, charSet varibles inherited from TrackingServiceInterface interface
*/
        
    @WebMethod
    @Override
    public void generateTrackingNumber() {
        for (int i = 0; i < 16; i++) {
            trackingNumber += charSet.charAt(random.nextInt(charSetLength));
        }  
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override

    /**
    * doPost @throws ServletException exception
    */

    public void doPost(HttpServletRequest request, HttpServletResponse response) /** Get HTTP response form HttpServletRequest.java and HttpServletResponse.java */
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) { /**  Create printer object */

            email = request.getParameter("email"); /**  Assign form inputs (parameters) to string varaibles */
            description = request.getParameter("description");
            postcode = request.getParameter("postcode");
            generateTrackingNumber(); 

            try {
                Class.forName("com.mysql.jdbc.Driver");
            /** Open a connection */
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", ""); 
                myStmt = myConn.createStatement(); /** Pass database connection to prepared statment */
                String query = "insert into users (trackingNumber, userEmail, description, postCode) VALUES ('" + trackingNumber + "','" + email + "','" + description + "', '" + postcode + "');";
                myStmt.execute(query); /** SQL statment that adds form data to Database */

//                System.out.print("Data Inserted"); // Testing

            } catch (Exception e) {

                e.printStackTrace(); 
            }

            /** HTML output */

            /** 
            *
            * Request @param email, @param postcode, @param description from get-trackingNumber.jsp form. 
            */
            /** 
            *
            * Request inherted @param trackingNumber from generateTrackingNumber method. 
            */

            String title = "Here is Your recipt";
            String docType
                    = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                    + "Transitional//EN\">\n";
            out.println(docType
                    + "<HTML>\n"
                    + "<HEAD>  <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/stylesheet.css\"></HEAD>\n" /** Import HTML styling */
                    + "<ul><li><a class=\"active\" href=\"./index.jsp\">Home</a></li><li><a href=\"./get-trackingNumber.jsp\">Apply for Delivery</a></li><li><a href=\"./trackDelivery.jsp\">Track Delivery</a></li></ul>\n" /** HTML navagation bar */
                    + "</ul>"
                    + "<br><br><h3>" + title + "</h3>\n"
                    + "<p>\n"
                    + "  <br><br><p><B>Email address</B>: "
                    + request.getParameter("email") + "</p><br><br>" + "\n"
                    + "  <p><B>Delivered to post code</B>: "
                    + request.getParameter("postcode") + "</p><br><br>"
                    + "  <p><B>Enter description of parcel</B>: "
                    + request.getParameter("description") + "</p><br><br>"
                    + "  <p><B>Please make note of the following tracking number</B>: "
                    + trackingNumber + "</p></BODY></HTML>");
        }

        /** HTML output END */
    }
    
   
}
