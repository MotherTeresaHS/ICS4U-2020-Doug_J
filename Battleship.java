/*
* This class creates a bicycle which is a type of vehicle.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

public class Battleship extends Ships {
  // Initializing fields

  /**
   * Setting field values with a constructor. 
   */
  public Battleship() {
    super();
    this.shipSize = 4;
    this.shipHealth = shipSize;
    this.shotSegments = 0;
    this.positionX1 = -1;
    this.positionY1 = -1;
    this.positionX2 = -1;
    this.positionY2 = -1;
    this.positionX3 = -1;
    this.positionY3 = -1;
    this.positionX4 = -1;
    this.positionY4 = -1;
  }

}
