/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.util.Random; /** Import Random class */

/**
 *
 * @author sheral-annthompson
 */

public interface TrackingServiceInterface { /** Create Interface */
  Random random = new Random(); /** Create new random number object */
  String charSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; /** Assign lower and upper alphabet to charSet variable */
  int charSetLength = charSet.length(); /** Set charSet length to 16 */
   
  public void generateTrackingNumber(); /** Create empty abstract generateTrackingNumber method */
    	   
}
