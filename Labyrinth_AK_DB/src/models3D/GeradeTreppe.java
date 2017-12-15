package models3D;

import basics.Point;
import params.Quader;

public class GeradeTreppe extends Treppe
{
  
  /**
   * 
   * @param x
   * @param y
   * @param z
   * @param w1
   * @param w2
   * @param w3
   */
  public GeradeTreppe(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
    
    for (int q = 0; q < 10; q++)
    {
      myShape.addParam(new Quader("Mitte", stufenlaenge * 2, stufenbreite, stufenhoehe),
          new Point(pos.x + stufenlaenge * q, pos.z, pos.y + stufenhoehe * q));
      
    }
  }
}
