/*
* This class creates a truck which is a type of vehicle.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

public class Map {
  // Initializing fields
  
    // Initializing ships 
    Ships ships = new Ships();
    
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
        atMapString = atMapString + ("| " + this.attackMap[countOne][countTwo] + " |");
        if (countTwo == 9) {
          atMapString = atMapString + ("\n");
          
        }
      }
      atMapString = atMapString + "   -------------------------------------------------- \n";
    }
    return(atMapString);
  }

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
  
  public String checkNavyMap(int attackY, int attackX) {
    
    //check if the array at attackX,attackY location isnt water or already hit
    if (navyMap[attackY][attackX] == "-") {
      return("MISS");
    } else {
    return("HIT");
    }
  }
  
  
  public void missMark(int attackY, int attackX) {
    
    this.attackMap[attackY][attackX] = "O";
  }
  
  public void hitMark(int attackY, int attackX) {
    
    this.attackMap[attackY][attackX] = "X";
  }
}