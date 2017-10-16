package models3D;

import basics.Point;
import params.Quader;

public class RundeTreppe extends Treppe
{
  
  /**
   * 
   * @param x
   * @param y
   * @param z
   * @param w1
   * @param w2
   * @param w3
   * @param bogen
   * @param treppenlaenge
   */
  public RundeTreppe(float x, float y, float z, float w1, float w2, float w3, float bogen, float treppenlaenge)
  {
    super(x,y,z,w1,w2,w3);
    this.bogen = bogen;
    
    this.treppenlaenge = treppenlaenge;
    
    for (int q = 0; q < this.treppenlaenge+1; q++)
    {
      myShape.addParam(new Quader ("Mitte",stufenlaenge*4,stufenbreite,stufenhoehe),new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q), new float []{(float) (bogen*q/10+90),0,0});
    
    }
  }
}
