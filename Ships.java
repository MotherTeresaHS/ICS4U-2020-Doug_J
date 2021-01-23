/*
* This class creates a bicycle which is a type of vehicle.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

public class Ships {
// Initializing fields

  int shipSize;
  int shipHealth;
  int shotSegments;
  int positionX1;
  int positionY1;
  int positionX2;
  int positionY2;
  int positionX3;
  int positionY3;
  int positionX4;
  int positionY4;
  int positionX5;
  int positionY5;

  /**
   * Setting field values with a constructor. 
   */
  public Ships() {
  }
  
  public String setHit (int attackY, int attackX, String shipType) {
    shipHealth += -1;
    shotSegments += 1;
    String shootMessage = "You hit a " + shipType + ". It has " + shipHealth + " health remaining.";

    if (shotSegments == shipSize && shipHealth == 0) {
      shootMessage = shootMessage + "\n\nYou sunk the " + shipType + "!";
    }

    return (shootMessage);
  }
  
  public String assignPosition(int yVal1, int xVal1, int yVal2, int xVal2, int yVal3, int xVal3, int yVal4, int xVal4, int yVal5, int xVal5) {

    positionX1 = xVal1;
    positionY1 = yVal1;
    positionX2 = xVal2;
    positionY2 = yVal2;
    positionX3 = xVal3;
    positionY3 = yVal3;
    positionX4 = xVal4;
    positionY4 = yVal4;
    positionX5 = xVal5;
    positionY5 = yVal5;

    return "success";
  }
  
  public int healthcheck() {
    return (shipHealth);
  }
}
