/*
* This class creates a bicycle which is a type of vehicle.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

public class Destroyer extends Ships {
  // Initializing fields

  /**
   * Setting field values with a constructor. 
   */
  public Destroyer() {
    super();
    this.shipSize = 2;
    this.shipHealth = shipSize;
    this.shotSegments = 0;
    this.positionX1 = -1;
    this.positionY1 = -1;
    this.positionX2 = -1;
    this.positionY2 = -1;
  }

}
