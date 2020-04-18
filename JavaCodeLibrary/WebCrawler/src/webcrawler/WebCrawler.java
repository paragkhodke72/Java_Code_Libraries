/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;

import java.util.Scanner;
import java.util.ArrayList;

public class WebCrawler {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a URL: ");
    String url = input.nextLine(); 
    crawler(url); // Traverse the Web from the a starting url
  }

  public static void crawler(String startingURL) {
    ArrayList<String> listOfPendingURLs = new ArrayList<>();
    ArrayList<String> listOfTraversedURLs = new ArrayList<>();
    
    listOfPendingURLs.add(startingURL);
    while (!listOfPendingURLs.isEmpty() && 
        listOfTraversedURLs.size() <= 100) {
      String urlString = listOfPendingURLs.remove(0);
      listOfTraversedURLs.add(urlString);
      System.out.println("Crawl " + urlString);

      for (String s: getSubURLs(urlString)) {
        if (!listOfTraversedURLs.contains(s) && 
        		!listOfPendingURLs.contains(s))
          listOfPendingURLs.add(s);
      }
    }
  }
  
  public static ArrayList<String> getSubURLs(String urlString) {
    ArrayList<String> list = new ArrayList<>();
    
    try {
      java.net.URL url = new java.net.URL(urlString); 
      Scanner input = new Scanner(url.openStream());
      int current = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        current = line.indexOf("http:", current);
        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) { // Ensure that a correct URL is found
            list.add(line.substring(current, endIndex)); 
            current = line.indexOf("http:", endIndex);
          }
          else 
            current = -1;
        }
      } 
    }
    catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    
    return list;
  }
}
