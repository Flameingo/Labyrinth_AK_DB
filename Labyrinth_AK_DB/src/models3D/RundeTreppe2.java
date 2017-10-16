package models3D;

import basics.Point;
import params.Quader;
import params.Zylinder;

public class RundeTreppe2 extends Treppe
{
  public RundeTreppe2(float x, float y, float z, float w1, float w2, float w3, float bogen, float treppenlaenge)
  {
    super(x,y,z,w1,w2,w3);
    this.bogen = bogen;
    
    this.treppenlaenge = treppenlaenge;
    
    for (int q = 0; q < this.treppenlaenge+1; q++)
    {
      myShape.addParam(new Quader ("Mitte",stufenlaenge*4,stufenbreite,stufenhoehe2),
          new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q), 
          new float []{(float) (bogen*q/10+90),0,0});
    }
    for (int p = 0; p < this.treppenlaenge; p++)
    {
      myShape.addParam(new Zylinder(0.1f,0.1f,0.4f), 
          new Point(this.x+(float)Math.cos(p*bogen*(float)Math.PI/1800)*1.5f, this.z+(float)Math.sin(p*bogen*(float)Math.PI/1800)*1.5f, this.y+stufenhoehe*p+0.05f));
    
      myShape.addParam(new Zylinder(0.1f,0.1f,0.4f), 
          new Point(this.x+(float)Math.cos(p*bogen*(float)Math.PI/1800)*2.7f, this.z+(float)Math.sin(p*bogen*(float)Math.PI/1800)*2.7f, this.y+stufenhoehe*p+0.05f));
    
    }
  }
}