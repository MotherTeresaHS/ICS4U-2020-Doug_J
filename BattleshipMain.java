/*
* This Computer Plays battleship against a computer player
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2021-01-20
*/

// Import the Scanner class
import java.util.Scanner;

public class BattleshipMain {

  /**
   * Main function to run the game.
   */
  public static void main(String[] args) {
    
    //initializing bot attacking user map
    Map botToUserMap = new Map();
    
    // initializing user attacking bot map
    Map userToBotMap = new Map();
    
    // create scanner object (one for int one for str)
    Scanner strScan = new Scanner(System.in);
    Scanner intScan = new Scanner(System.in);
    
    
    // Generates the ship locations of each player on their respective maps.
    System.out.println(userToBotMap.generateMap());
    System.out.println(botToUserMap.generateMap());
    
    // Runs game inside of game loop that only stops when a win condition is found.
    while (true) {
      
      // Debugging code to print out the computers ship locations. These should be commented out.
      //System.out.println("botnavy");
      //System.out.println(userToBotMap.printNavyMap());
      
      //Begin user attack
      //////////////////////////////////////////////////////////////////////////
      
      // call attack map and print it
      System.out.println(userToBotMap.printAttackMap());
      
      //ask where you want to attack
      System.out.println("    -_-_-_-_-_-_-_-_-_-Enemy Waters-_-_-_-_-_-_-_-_- \n\n");
      
      boolean inputSensor = false;
      
      // Enter while true loop to ensure that a proper location is always given.
      while (inputSensor == false) {
        try {
          System.out.println("On which at which letter would you like to attack: ");
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
          System.out.println(userToBotMap.checkNavyMap(attackY, attackX, "Player"));
          
          // escape loop if everything goes normal and the inputs are proper
          inputSensor = true;
          
        // if inputs are improper, continue looping
        } catch (Exception e) {
          System.out.println("");
          System.out.println("Please enter a valid input\n");
        }
      }
      
      // sleep to provide user time to read outcome
      try {
        Thread.sleep(2000);
      
      } catch (InterruptedException e) {
        System.out.println("ERROR: Unable to complete stand");
      }
      
      // bot turn
      //////////////////////////////////////////////////////////////////////////
      
      // recieve attack coords in array form
      int [] attackArray = botToUserMap.botAttack();
      
      // Print outcome of attack
      System.out.println(botToUserMap.checkNavyMap(attackArray[0], attackArray[1], "Computer"));
      
      // Print the users fleet
      System.out.println(botToUserMap.printNavyMap());
      System.out.println("  -_-_-_-_-_-_-_-_-Friendly Waters-_-_-_-_-_-_-_- \n\n");
      
      // sleep to allow time for user to read outcome
      try {
        Thread.sleep(5000);
      
      } catch (InterruptedException e) {
        System.out.println("ERROR: Unable to complete stand");
      }
      
      //check if you won
      if (userToBotMap.winCondition() == true) {
        System.out.println(userToBotMap.printAttackMap());
        System.out.println("The Player has sunk all of the Computers ships! \nThe Player wins!");
        
        // break to escape game loop and end program
        break;
        
      // if the bot wins
      } else if (botToUserMap.winCondition() == true) {
        System.out.println("The Computer has sunk all of the Players ships! \nThe Computer wins!");
        
        // break to escape game loop and end program
        break;
        
        // otherwise continue playing
      } else {
        System.out.println("Next round");
      }
      
      // sleep to provide user time to read outcome
      try {
        Thread.sleep(2000);
      
      } catch (InterruptedException e) {
        System.out.println("ERROR: Unable to complete stand");
      }
    }
  }
}
