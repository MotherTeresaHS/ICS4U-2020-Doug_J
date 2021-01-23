/*
* This program receives and outputs information about a car when prompted
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

// Import the Scanner class
import java.util.Scanner;

public class BattleshipMain {

  public static void main(String[] args) {
    
    //initializing Map
    Map userMap = new Map();
    
    // initializing bots map
    Map userToBotMap = new Map();
    
    // create scanner object
    Scanner strScan = new Scanner(System.in);
    Scanner intScan = new Scanner(System.in);
    
    System.out.println(userToBotMap.generateMap());
    
    while (true) {
      
      // call attack map and print it
      System.out.println(userToBotMap.printAttackMap());
      
      //ask where you want to attack
      System.out.println("    -_-_-_-_-_-_-_-_-_-Enemy Waters-_-_-_-_-_-_-_-_- \n\n"
                          + "On which at which letter would you like to attack: ");
      String lowerletterAtX = strScan.nextLine();
      String letterAtX = lowerletterAtX.toUpperCase();
      
      //ask where you want to attack
      System.out.println("On which numeral would you like to attack: ");
      int attackY = intScan.nextInt();
      
      System.out.println("You attacked: " + letterAtX + attackY);
      
      // changing attack y so that its within the bounds of the array
      attackY += -1;
      
      // call parse function to determine the array coordinates of the attack
      int attackX = userToBotMap.parseLetter(letterAtX);
      
      // call userToBotMap method with parsed attack coords to check if there is a hit
      System.out.println(userToBotMap.checkNavyMap(attackY, attackX));
      
      //check if you won
      if (userToBotMap.winCondition() == true) {
        System.out.println("The player has sunk all of the Computers ships! \nThe Player wins!");
        break;
      } else {
        System.out.println("Next round");
      }
      
      try {
        Thread.sleep(1000);
        
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
