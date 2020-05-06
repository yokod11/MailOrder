/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
// Import classes

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sheral-annthompson
 */

public class getDataServlet extends HttpServlet { /** getDataServlet class extends HttpServlet.java */

    Connection myConn;
    Statement Stmt;
    String newTrackNum2;
    String dburl = "jdbc:mysql://localhost:3306/accounts"; /** Assign Database URL to String variable */

    /**
     * Assign Database URL to String variable
     * @throws java.io.IOException
     */


    @Override

    /**
    * doGet @throws ServletException exception
    */

    public void doGet(HttpServletRequest request, HttpServletResponse response) /** Get HTTP response form HttpServletRequest.java and HttpServletResponse.java */
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); /** Create printer object */

        try {
    /** 
    *
    * Get @param newTrackNum from get-trackingNumber.jsp form. 
    */

            newTrackNum2 = request.getParameter("newTrackNum"); /** Assign form input (parameter) to string varaible */
        
            Class.forName("com.mysql.jdbc.Driver"); /** Register JDBC driver */

            /** Open a connection */
            
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "");
            try ( /** Execute SQL query */
                    Statement Stmt = myConn.createStatement()) { /** Pass database connection to prepared statment */

                String query = "select * from users where trackingNumber = '" + newTrackNum2 + "'"; /** SQL statment that adds form data to Database */
                ResultSet rs = Stmt.executeQuery(query);

                /** Extract data from result set when database reteuns results */

                boolean has_results = rs.next();

                    if (has_results) {
                       System.out.print("Has Data"); // Testing

                    } else { /** Prompt when SQL query returns non */
                        String docType
                                = "<HTML>\n"
                    + "<HEAD>  <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/stylesheet.css\"></HEAD>\n" /** Import HTML styling */
                    + "<ul><li><a class=\"active\" href=\"./index.jsp\">Home</a></li><li><a href=\"./get-trackingNumber.jsp\">Apply for Delivery</a></li><li><a href=\"./trackDelivery.jsp\">Track Delivery</a></li></ul>\n" /** HTML navagation bar */
                    + "</ul>";
                    /** HTML navigation bar */
                    }
                ResultSet rs2 = Stmt.executeQuery(query);
                while (rs2.next()) { /** Retrieve by column name */
                /** Assign Query Results to Strings */                     
                    String trackingNumber = rs2.getString("trackingNumber");
                    String description = rs2.getString("description");
                    String postcode = rs2.getString("postcode");
                    String details = " ORDER DETAILS";
                    String welcome = " GREAT NEWS YOUR PARCEL IS ON ITS WAY";
                    int arival = (int) (Math.random() * 49 + 1);  /** Set random delivery date */

                    /** HTML body */

                    String docType
                            = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

                    out.println(docType
                            + "<HTML>\n"
                            + "<HEAD>  <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/stylesheet.css\"></HEAD>\n"
                            + "<ul><li><a class=\"active\" href=\"./index.jsp\">Home</a></li><li><a href=\"./get-trackingNumber.jsp\">Apply for Delivery</a></li><li><a href=\"./trackDelivery.jsp\">Track Delivery</a></li></ul>\n"
                            + "</ul><br><br><h2>" + welcome + "</h2>"
                            + "<br><br><h3> Your parcel will arrive at " + postcode + " on " + arival + "/06/2020</h3>\n"
                            + "<p>\n"
                            + " <br><br><B>" + details + "</B><br> "
                            + "<br>"
                            + "  <table style=\"width:35%;border: none;\"><tr><td><b>Parcel description: </b>"
                            + description + "</td></tr>"
                            + " <tr><td><b>Tracking number: </b>"
                            + trackingNumber + "</td></tr>"
                            + " <tr><td><b>Destination: </b>"
                            + postcode + "</td></tr></table></BODY></HTML>");
                }
                /** HTML body END */
              rs.close(); // Close Query result     
            } catch (SQLException ex) {
            Logger.getLogger(getDataServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            myConn.close();  /** Close connection */

        } catch (SQLException se) {
            /** Handle errors for JDBC */
            se.printStackTrace();
        } catch (Exception e) {
            /** Handle errors for Class.forName */
            e.printStackTrace();
        } finally {
            /** Finally block used to close resources */
            try {
                if (Stmt != null) {
                    Stmt.close();
                }
            } catch (SQLException se2) {
            } /** Empty catch */
            try {
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } /** End finally try */
        } /** End try */
    }


}
