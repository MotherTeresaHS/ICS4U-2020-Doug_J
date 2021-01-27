/*
* This class creates a map object and its methods.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

public class Map {
  // Initializing fields
  
    // Initializing ships
    Ships ships = new Ships();
    
    Carrier carrier = new Carrier();
    
    Battleship battleship = new Battleship();
    
    Cruiser cruiser = new Cruiser();
    
    Sub sub = new Sub();
    
    Destroyer destroyer = new Destroyer();
    
    // initializing attack map
    String[][] attackMap = new String [10][10];
    
    // initializing navy map
    String[][] navyMap = new String [10][10];

  
  /**
   * Setting field values with a constructor.
   */
  public Map() {

    // setting up values of the maps
    for (int row = 0; row < 10; row ++) {
      for (int col = 0; col < 10; col ++) {
        attackMap[row][col] = "-";
        navyMap[row][col] = "-";
      }
    }
  }
  
  
  /**
   * lengthy process to generate the locations of the ships, as well as make
   * sure that they do not overlap or go out of bounds of the map.
   */
  public String generateMap() {
    
    // set variables needed to transmit information about the fleet location
    boolean placementCheck = false;
    int pointX1 = -1;
    int pointY1 = -1;
    int pointX2 = -1;
    int pointY2 = -1;
    int pointX3 = -1;
    int pointY3 = -1;
    int pointX4 = -1;
    int pointY4 = -1;
    int pointX5 = -1;
    int pointY5 = -1;
    
    // enter while loop to place carrier (biggest ship first)
    while (placementCheck == false) {

      int randomY = (int)(Math.random() * (9 - 0 + 1) + 0);
      int randomX = (int)(Math.random() * (9 - 0 + 1) + 0);
      int directionCheck = (int)(Math.random() * (4 - 1 + 1) + 1);
      
       try {
        navyMap[randomY][randomX] = "carrier";
        pointX1 = randomX;
        pointY1 = randomY;
        // debug print statement to show location of ship (should be commented)
        //System.out.println("Carrier" + (pointX1 + 1) + ", " + (pointY1 + 1));
        
        // try left if 1
        if (directionCheck == 1 && navyMap[randomY][randomX + 1].equals("-") && navyMap[randomY][randomX + 2].equals("-") && navyMap[randomY][randomX + 3].equals("-") && navyMap[randomY][randomX + 4].equals("-")) {
          navyMap[randomY][randomX + 1] = "carrier";
          pointX2 = randomX + 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX + 2] = "carrier";
          pointX3 = randomX + 2;
          pointY3 = randomY;
          
          navyMap[randomY][randomX + 3] = "carrier";
          pointX4 = randomX + 3;
          pointY4 = randomY;
          
          navyMap[randomY][randomX + 4] = "carrier";
          pointX5 = randomX + 4;
          pointY5 = randomY;
          
          carrier.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, pointX5, pointY5);
          
        // else try right
        } else if (directionCheck == 2 && navyMap[randomY][randomX - 1].equals("-") && navyMap[randomY][randomX - 2].equals("-") && navyMap[randomY][randomX - 3].equals("-") && navyMap[randomY][randomX - 4].equals("-")) {
          navyMap[randomY][randomX - 1] = "carrier";
          pointX2 = randomX - 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX - 2] = "carrier";
          pointX3 = randomX - 2;
          pointY3 = randomY;
          
          navyMap[randomY][randomX - 3] = "carrier";
          pointX4 = randomX - 3;
          pointY4 = randomY;
          
          navyMap[randomY][randomX - 4] = "carrier";
          pointX5 = randomX - 4;
          pointY5 = randomY;
          
          carrier.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, pointX5, pointY5);
        
        // else try up
        } else if (directionCheck == 3 && navyMap[randomY + 1][randomX].equals("-") && navyMap[randomY + 2][randomX].equals("-") && navyMap[randomY + 3][randomX].equals("-") && navyMap[randomY + 4][randomX].equals("-")) {
          navyMap[randomY + 1][randomX] = "carrier";
          pointX2 = randomX;
          pointY2 = randomY + 1;
          
          navyMap[randomY + 2][randomX] = "carrier";
          pointX3 = randomX;
          pointY3 = randomY + 2;
          
          navyMap[randomY + 3][randomX] = "carrier";
          pointX4 = randomX;
          pointY4 = randomY + 3;
          
          navyMap[randomY + 4][randomX] = "carrier";
          pointX5 = randomX;
          pointY5 = randomY + 4;
          
          carrier.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, pointX5, pointY5);
        
        // else try down
        } else if (directionCheck == 4 && navyMap[randomY - 1][randomX].equals("-") && navyMap[randomY - 2][randomX].equals("-") && navyMap[randomY - 3][randomX].equals("-") && navyMap[randomY - 4][randomX].equals("-")) {
          navyMap[randomY - 1][randomX] = "carrier";
          pointX2 = randomX;
          pointY2 = randomY - 1;
          
          navyMap[randomY - 2][randomX] = "carrier";
          pointX3 = randomX;
          pointY3 = randomY - 2;
          
          navyMap[randomY - 3][randomX] = "carrier";
          pointX4 = randomX;
          pointY4 = randomY - 3;
          
          navyMap[randomY - 4][randomX] = "carrier";
          pointX5 = randomX;
          pointY5 = randomY - 4;
          
          carrier.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, pointX5, pointY5);
        
        // reset the location back to a blank space if nothing works
        } else {
          navyMap[randomY][randomX] = "-";
        }
      
      placementCheck = true;
      
      // catch if the carrier is placed out of boubds
      } catch(ArrayIndexOutOfBoundsException exception) {
        navyMap[randomY][randomX] = "-";
        continue;
      }
    }
  
    placementCheck = false;
    
    // enter while loop to place Battleship (4 size ship)
    while (placementCheck == false) {
      
      int randomY = (int)(Math.random() * (9 - 0 + 1) + 0);
      int randomX = (int)(Math.random() * (9 - 0 + 1) + 0);
      int directionCheck = (int)(Math.random() * (4 - 1 + 1) + 1);
      
      try {
        if (navyMap[randomY][randomX].equals("-")) {
          navyMap[randomY][randomX] = "battleship";
          pointX1 = randomX;
          pointY1 = randomY;
          // debug print statement to show location of ship (should be commented)
          // System.out.println("Battleship" + (pointX1 + 1) + ", " + (pointY1 + 1));
        } else {
          // debug print statement to initial location placing error (should be commented)
          // System.out.println("battleship landing collision");
          continue;
        }
        
        // try left if 1
        if (directionCheck == 1 && navyMap[randomY][randomX + 1].equals("-") && navyMap[randomY][randomX + 2].equals("-") && navyMap[randomY][randomX + 3].equals("-")) {
          navyMap[randomY][randomX + 1] = "battleship";
          pointX2 = randomX + 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX + 2] = "battleship";
          pointX3 = randomX + 2;
          pointY3 = randomY;
          
          navyMap[randomY][randomX + 3] = "battleship";
          pointX4 = randomX + 3;
          pointY4 = randomY;
        
          battleship.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, -1, -1);
          placementCheck = true;
          
        // else try right
        } else if (directionCheck == 2 && navyMap[randomY][randomX - 1].equals("-") && navyMap[randomY][randomX - 2].equals("-") && navyMap[randomY][randomX - 3].equals("-")) {
          navyMap[randomY][randomX - 1] = "battleship";
          pointX2 = randomX - 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX - 2] = "battleship";
          pointX3 = randomX - 2;
          pointY3 = randomY;
          
          navyMap[randomY][randomX - 3] = "battleship";
          pointX4 = randomX - 3;
          pointY4 = randomY;
          
          battleship.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, -1, -1);
          placementCheck = true;
        
        // else try up
        } else if (directionCheck == 3 && navyMap[randomY + 1][randomX].equals("-") && navyMap[randomY + 2][randomX].equals("-") && navyMap[randomY + 3][randomX].equals("-")) {
          navyMap[randomY + 1][randomX] = "battleship";
          pointX2 = randomX;
          pointY2 = randomY + 1;
          
          navyMap[randomY + 2][randomX] = "battleship";
          pointX3 = randomX;
          pointY3 = randomY + 2;
          
          navyMap[randomY + 3][randomX] = "battleship";
          pointX4 = randomX;
          pointY4 = randomY + 3;
          
          battleship.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, -1, -1);
          placementCheck = true;
        
        // else try down
        } else if (directionCheck == 4 && navyMap[randomY - 1][randomX].equals("-") && navyMap[randomY - 2][randomX].equals("-") && navyMap[randomY - 3][randomX].equals("-")) {
          navyMap[randomY - 1][randomX] = "battleship";
          pointX2 = randomX;
          pointY2 = randomY - 1;
          
          navyMap[randomY - 2][randomX] = "battleship";
          pointX3 = randomX;
          pointY3 = randomY - 2;
          
          navyMap[randomY - 3][randomX] = "battleship";
          pointX4 = randomX;
          pointY4 = randomY - 3;
          
          battleship.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, -1, -1);
          placementCheck = true;
          
        } else {
          navyMap[randomY][randomX] = "-";
          // debug print statement to show if collision happens (should be commented)
          // System.out.println("battleship collision");
        }
        
      // catch if the battleship is placed out of bounds
      } catch(ArrayIndexOutOfBoundsException exception) {
        navyMap[randomY][randomX] = "-";
        continue;
      }
    }
    
    placementCheck = false;
    
    // enter while loop to place Cruiser (3 size ship)
    while (placementCheck == false) {

      int randomY = (int)(Math.random() * (9 - 0 + 1) + 0);
      int randomX = (int)(Math.random() * (9 - 0 + 1) + 0);
      int directionCheck = (int)(Math.random() * (4 - 1 + 1) + 1);
        
      try {
        if (navyMap[randomY][randomX].equals("-")) {
          navyMap[randomY][randomX] = "cruiser";
          pointX1 = randomX;
          pointY1 = randomY;
          // debug print statement to show location of ship (should be commented)
          // System.out.println("Cruiser" + (pointX1 + 1) + ", " + (pointY1 + 1));
        } else {
          // System.out.println("Cruiser landing Collision");
          continue;
        }
        
        // try left if 1
        if (directionCheck == 1 && navyMap[randomY][randomX + 1].equals("-") && navyMap[randomY][randomX + 2].equals("-")) {
          navyMap[randomY][randomX + 1] = "cruiser";
          pointX2 = randomX + 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX + 2] = "cruiser";
          pointX3 = randomX + 2;
          pointY3 = randomY;
        
          cruiser.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
          
        // else try right
        } else if (directionCheck == 2 && navyMap[randomY][randomX - 1].equals("-") && navyMap[randomY][randomX - 2].equals("-")) {
          navyMap[randomY][randomX - 1] = "cruiser";
          pointX2 = randomX - 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX - 2] = "cruiser";
          pointX3 = randomX - 2;
          pointY3 = randomY;
          
          cruiser.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
        
        // else try up
        } else if (directionCheck == 3 && navyMap[randomY + 1][randomX].equals("-") && navyMap[randomY + 2][randomX].equals("-")) {
          navyMap[randomY + 1][randomX] = "cruiser";
          pointX2 = randomX;
          pointY2 = randomY + 1;
          
          navyMap[randomY + 2][randomX] = "cruiser";
          pointX3 = randomX;
          pointY3 = randomY + 2;
          
          cruiser.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
        
        // else try down
        } else if (directionCheck == 4 && navyMap[randomY - 1][randomX].equals("-") && navyMap[randomY - 2][randomX].equals("-")) {
          navyMap[randomY - 1][randomX] = "cruiser";
          pointX2 = randomX;
          pointY2 = randomY - 1;
          
          navyMap[randomY - 2][randomX] = "cruiser";
          pointX3 = randomX;
          pointY3 = randomY - 2;
          
          cruiser.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
          
        } else {
          navyMap[randomY][randomX] = "-";
          // debug print statement to show if collision happens (should be commented)
          // System.out.println("cruiser collision");
        }
      
      // catch if the cruiser is placed out of bounds
      } catch(ArrayIndexOutOfBoundsException exception) {
        navyMap[randomY][randomX] = "-";
        continue;
      }
    }
    
    
    placementCheck = false;
    
    // enter while loop to place Sub (3 size ship)
    while (placementCheck == false) {

      int randomY = (int)(Math.random() * (9 - 0 + 1) + 0);
      int randomX = (int)(Math.random() * (9 - 0 + 1) + 0);
      int directionCheck = (int)(Math.random() * (4 - 1 + 1) + 1);

      try {        
        if (navyMap[randomY][randomX].equals("-")) {
          navyMap[randomY][randomX] = "sub";
          pointX1 = randomX;
          pointY1 = randomY;
          // debug print statement to show location of ship (should be commented)
          // System.out.println("Submarine" + (pointX1 + 1) + ", " + (pointY1 + 1));
        } else {
          // System.out.println("Submarine landing Collision");
          continue;
        }
        
        // try left if 1
        if (directionCheck == 1 && navyMap[randomY][randomX + 1].equals("-") && navyMap[randomY][randomX + 2].equals("-")) {
          navyMap[randomY][randomX + 1] = "sub";
          pointX2 = randomX + 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX + 2] = "sub";
          pointX3 = randomX + 2;
          pointY3 = randomY;
        
          sub.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
          
        // else try right
        } else if (directionCheck == 2 && navyMap[randomY][randomX - 1].equals("-") && navyMap[randomY][randomX - 2].equals("-")) {
          navyMap[randomY][randomX - 1] = "sub";
          pointX2 = randomX - 1;
          pointY2 = randomY;
          
          navyMap[randomY][randomX - 2] = "sub";
          pointX3 = randomX - 2;
          pointY3 = randomY;
          
          sub.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
        
        // else try up
        } else if (directionCheck == 3 && navyMap[randomY + 1][randomX].equals("-") && navyMap[randomY + 2][randomX].equals("-")) {
          navyMap[randomY + 1][randomX] = "sub";
          pointX2 = randomX;
          pointY2 = randomY + 1;
          
          navyMap[randomY + 2][randomX] = "sub";
          pointX3 = randomX;
          pointY3 = randomY + 2;
          
          sub.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
        
        // else try down
        } else if (directionCheck == 4 && navyMap[randomY - 1][randomX].equals("-") && navyMap[randomY - 2][randomX].equals("-")) {
          navyMap[randomY - 1][randomX] = "sub";
          pointX2 = randomX;
          pointY2 = randomY - 1;
          
          navyMap[randomY - 2][randomX] = "sub";
          pointX3 = randomX;
          pointY3 = randomY - 2;
          
          sub.assignPosition(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, -1, -1, -1, -1);
          placementCheck = true;
          
        } else {
          navyMap[randomY][randomX] = "-";
          // debug print statement to show if collision happens (should be commented)
          // System.out.println("sub collision");
        }
      
      // catch if the sub is placed out of bounds
      } catch(ArrayIndexOutOfBoundsException exception) {
        navyMap[randomY][randomX] = "-";
        continue;
      }
    }
    
    
    placementCheck = false;
    
    // enter while loop to place Destroyer (2 size ship)
    while (placementCheck == false) {

      int randomY = (int)(Math.random() * (9 - 0 + 1) + 0);
      int randomX = (int)(Math.random() * (9 - 0 + 1) + 0);
      int directionCheck = (int)(Math.random() * (4 - 1 + 1) + 1);

      try {        
        if (navyMap[randomY][randomX].equals("-")) {
          navyMap[randomY][randomX] = "destroyer";
          pointX1 = randomX;
          pointY1 = randomY;
          // debug print statement to show location of ship (should be commented)
          // System.out.println("Destroyer" + (pointX1 + 1) + ", " + (pointY1 + 1));
        } else {
          // System.out.println("Destroyer landing Collision");
          continue;
        }
        
        // try left if 1
        if (directionCheck == 1 && navyMap[randomY][randomX + 1].equals("-") && navyMap[randomY][randomX + 2].equals("-")) {
          navyMap[randomY][randomX + 1] = "destroyer";
          pointX2 = randomX + 1;
          pointY2 = randomY;
        
          destroyer.assignPosition(pointX1, pointY1, pointX2, pointY2, -1, -1, -1, -1, -1, -1);
          placementCheck = true;
          
        // else try right
        } else if (directionCheck == 2 && navyMap[randomY][randomX - 1].equals("-") && navyMap[randomY][randomX - 2].equals("-")) {
          navyMap[randomY][randomX - 1] = "destroyer";
          pointX2 = randomX - 1;
          pointY2 = randomY;
          
          destroyer.assignPosition(pointX1, pointY1, pointX2, pointY2, -1, -1, -1, -1, -1, -1);
          placementCheck = true;
        
        // else try up
        } else if (directionCheck == 3 && navyMap[randomY + 1][randomX].equals("-") && navyMap[randomY + 2][randomX].equals("-")) {
          navyMap[randomY + 1][randomX] = "destroyer";
          pointX2 = randomX;
          pointY2 = randomY + 1;
          
          destroyer.assignPosition(pointX1, pointY1, pointX2, pointY2, -1, -1, -1, -1, -1, -1);
          placementCheck = true;
        
        // else try down
        } else if (directionCheck == 4 && navyMap[randomY - 1][randomX].equals("-") && navyMap[randomY - 2][randomX].equals("-")) {
          navyMap[randomY - 1][randomX] = "destroyer";
          pointX2 = randomX;
          pointY2 = randomY - 1;
          
          destroyer.assignPosition(pointX1, pointY1, pointX2, pointY2, -1, -1, -1, -1, -1, -1);
          placementCheck = true;

        } else {
          navyMap[randomY][randomX] = "-";
          // debug print statement to show if collision happens (should be commented)
          // System.out.println("destroyer collision");
        }
      
      // catch if the destroyer is placed out of bounds
      } catch(ArrayIndexOutOfBoundsException exception) {
        navyMap[randomY][randomX] = "-";
        continue;
      }
    }
    
    return("complete");
  }
  
  /**
   * prints out attack board
   */
  public String printAttackMap() {
    String atMapString = "     A    B    C    D    E    F    G    H    I    J \n   -------------------------------------------------- \n";
    
    // Enter a nested for loop to print out the map in proper format
    for(int countOne = 0; countOne < 10; countOne++) {
      
      if (countOne != 9) {
        atMapString = atMapString + (countOne + 1) + "  ";
      } else {
        atMapString = atMapString + (countOne + 1) + " ";
      }
      
      for(int countTwo = 0; countTwo < 10; countTwo++) {
        atMapString = atMapString + ("| " + attackMap[countOne][countTwo] + " |");
        if (countTwo == 9) {
          atMapString = atMapString + ("\n");
          
        }
      }
      atMapString = atMapString + "   -------------------------------------------------- \n";
    }
    return(atMapString);
  }
  
  
  /**
   * prints out player board
   */
  public String printNavyMap() {
    String atMapString = "     A    B    C    D    E    F    G    H    I    J \n   -------------------------------------------------- \n";
    
    // Enter a nested for loop to print out the map in proper format
    for(int countOne = 0; countOne < 10; countOne++) {
      
      if (countOne != 9) {
        atMapString = atMapString + (countOne + 1) + "  ";
      } else {
        atMapString = atMapString + (countOne + 1) + " ";
      }
      
      for(int countTwo = 0; countTwo < 10; countTwo++) {
        
        if (navyMap[countOne][countTwo].equals("carrier")) {
          atMapString = atMapString + ("| " + "\033[0;96m" + "█" + "\u001B[0m" + " |");
          
        } else if (navyMap[countOne][countTwo].equals("battleship")) {
          atMapString = atMapString + ("| " + "\033[0;95m" + "█" + "\u001B[0m" + " |");
          
        } else if (navyMap[countOne][countTwo].equals("cruiser")) {
          atMapString = atMapString + ("| " + "\033[0;94m" + "█" + "\u001B[0m" + " |");
        
        } else if (navyMap[countOne][countTwo].equals("sub")) {
          atMapString = atMapString + ("| " + "\033[0;93m" + "█" + "\u001B[0m" + " |");
          
        } else if (navyMap[countOne][countTwo].equals("destroyer")) {
          atMapString = atMapString + ("| " + "\033[0;92m" + "█" + "\u001B[0m" + " |");
        
        } else {
          atMapString = atMapString + ("| " + navyMap[countOne][countTwo] + " |");
        }
        
        if (countTwo == 9) {
          atMapString = atMapString + ("\n");
          
        }
      }
      atMapString = atMapString + "   -------------------------------------------------- \n";
    }
    return(atMapString);
  }
  
  /**
   * Calculates the bots attacks (to be improved)
   */
  public int [] botAttack() {
    int randomY = (int)(Math.random() * (9 - 0 + 1) + 0);
    int randomX = (int)(Math.random() * (9 - 0 + 1) + 0);
    
    int [] botAttack = new int[2];
    botAttack [0] = randomY;
    botAttack [1] = randomX;
    
    String atString = "";
    
    switch (randomX) {
      case 0:
        atString = "A";
        break;
      case 1:
        atString = "B";
        break;
      case 2:
        atString = "C";
        break;
      case 3:
        atString = "D";
        break;
      case 4:
        atString = "E";
        break;
      case 5:
        atString = "F";
        break;
      case 6:
        atString = "G";
        break;
      case 7:
        atString = "H";
        break;
      case 8:
        atString = "I";
        break;
      case 9:
        atString = "J";
        break;
    }
    
    System.out.println("\nComputer attacked at " + atString + ", " + (randomY + 1));
    
    return(botAttack);
    
  }

  /**
   * parses letter inputs into numbers
   */
  public int parseLetter(String letterAtX) {
    int numeralAtX = -1;
    switch (letterAtX) {
      case "A":
        numeralAtX = 0;
        return(numeralAtX);
      case "B":
        numeralAtX = 1;
        return(numeralAtX);
      case "C":
        numeralAtX = 2;
        return(numeralAtX);
      case "D":
        numeralAtX = 3;
        return(numeralAtX);
      case "E":
        numeralAtX = 4;
        return(numeralAtX);
      case "F":
        numeralAtX = 5;
        return(numeralAtX);
      case "G":
        numeralAtX = 6;
        return(numeralAtX);
      case "H":
        numeralAtX = 7;
        return(numeralAtX);
      case "I":
        numeralAtX = 8;
        return(numeralAtX);
      case "J":
        numeralAtX = 9;
        return(numeralAtX);
    }
    return (numeralAtX);
  }
  
  /**
   * Checks if there is a hit or miss
   */
  public String checkNavyMap(int attackY, int attackX, String userVal) {
    
    //check if the array at attackX,attackY location isnt water or already hit
    if (navyMap[attackY][attackX] == "-") {
      missMark(attackY, attackX);
      return("MISS");
      
    } else if (navyMap[attackY][attackX] == "X") {
      return((userVal + " hit an already destroyed segment."));
      
    } else {
      if (navyMap[attackY][attackX] == "carrier") {
        String shootMessage = carrier.setHit(attackY, attackX, "Carrier", userVal);
        hitMark(attackY, attackX);
        return (shootMessage);
      }
      
      if (navyMap[attackY][attackX] == "battleship") {
        String shootMessage = battleship.setHit(attackY, attackX, "Battleship", userVal);
        hitMark(attackY, attackX);
        return (shootMessage);
      }
      
      if (navyMap[attackY][attackX] == "cruiser") {
        String shootMessage = cruiser.setHit(attackY, attackX, "Cruiser", userVal);
        hitMark(attackY, attackX);
        return (shootMessage);
      }
      
      if (navyMap[attackY][attackX] == "sub") {
        String shootMessage = sub.setHit(attackY, attackX, "Submarine", userVal);
        hitMark(attackY, attackX);
        return (shootMessage);
      }
      
      if (navyMap[attackY][attackX] == "destroyer") {
        String shootMessage = destroyer.setHit(attackY, attackX, "Destroyer", userVal);
        hitMark(attackY, attackX);
        return (shootMessage);
      }
    }
    return ("problem");
  }
  
  public boolean winCondition() {
    boolean victoryCheck = true; 
    
    if (carrier.healthcheck() == 0 && battleship.healthcheck() == 0 && cruiser.healthcheck() == 0 && sub.healthcheck() == 0 && destroyer.healthcheck() == 0) {
      return (victoryCheck);
    } else {
      victoryCheck = false;
      return (victoryCheck);
    }
  }
  
  /**
   * marks misses on player attack map
   */
  public void missMark(int attackY, int attackX) {
    
    attackMap[attackY][attackX] = "O";
  }
  
  /**
   * marks hits on player attack map
   */
  public void hitMark(int attackY, int attackX) {
    
    attackMap[attackY][attackX] = "X";
    navyMap[attackY][attackX] = "X";
  }
}