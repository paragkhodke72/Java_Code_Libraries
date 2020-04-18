/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcirclewithexception;

/**
 *
 * @author gshee
 */
public class TestCircleWithException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CircleWithException c1 = new CircleWithException(5);
            CircleWithException c2 = new CircleWithException(-5);
            CircleWithException c3 = new CircleWithException(0);
          }
          catch (IllegalArgumentException ex) {
            System.out.println(ex);
          }

          System.out.println("Number of objects created: " +
            CircleWithException.getNumberOfObjects());
    }    
}
