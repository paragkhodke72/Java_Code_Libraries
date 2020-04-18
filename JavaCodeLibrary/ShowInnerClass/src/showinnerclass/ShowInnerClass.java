/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showinnerclass;

/**
 *
 * @author gshee
 */
public class ShowInnerClass {
    
    private int data;

    // ShowInnerClass.java: Demonstrate using inner classes
    /** A method in the outer class */
    public void m() {
      // Do something
      InnerClass instance = new InnerClass();

    }

    // An inner class
    class InnerClass {
      /** A method in the inner class */
      public void mi() {
        // Directly reference data and method defined in its outer class
        data++;
        m();
      }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
