package models3D;

import basics.Point;
import params.Quader;
import params.Unregelm;
import params.Zylinder;

public class RundeTreppe3  extends Treppe
{
  public RundeTreppe3(float x, float y, float z, float alpha, float beta, float gamma,float bogen, float treppenlaenge)
  {
    super(x, y, z, alpha, beta, gamma);
    
    this.bogen = bogen;
    
    this.treppenlaenge = treppenlaenge;
    
    for (int q = 0; q < this.treppenlaenge+1; q++)
    {
      Point p1 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q);
      Point p2 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q+0.5f);
      Point p3 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1, this.y+stufenhoehe*q);
      Point p4 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1, this.y+stufenhoehe*q+0.5f);
      Point p5 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1.5f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2-0.25f, this.y+stufenhoehe*q);
      Point p6 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1.5f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2-0.25f, this.y+stufenhoehe*q+0.5f);
      Point p7 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1.5f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1.25f, this.y+stufenhoehe*q);
      Point p8 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1.5f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1.25f, this.y+stufenhoehe*q+0.5f);
      
//      Point p1 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q);
//      Point p2 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q+0.5f);
//      Point p3 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q);
//      Point p4 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2, this.y+stufenhoehe*q+0.5f);
//      Point p5 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2-0.25f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1.5f, this.y+stufenhoehe*q);
//      Point p6 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2-0.25f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1.5f, this.y+stufenhoehe*q+0.5f);
//      Point p7 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1.25f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1.5f, this.y+stufenhoehe*q);
//      Point p8 = new Point(this.x+(float)Math.cos(q*bogen*(float)Math.PI/1800)*2+1.25f, this.z+(float)Math.sin(q*bogen*(float)Math.PI/1800)*2+1.5f, this.y+stufenhoehe*q+0.5f);
      
      myShape.addParam(new Unregelm (p1, p2, p3, p4, p5, p6, p7, p8),
          new float []{(float) (bogen*q/10+90),0,0});
    }
    for (int p = 0; p < this.treppenlaenge; p++)
    {
      myShape.addParam(new Zylinder(0.1f,0.1f,0.4f), 
          new Point(this.x+(float)Math.cos(p*bogen*(float)Math.PI/1800)*2f+1, this.z+(float)Math.sin(p*bogen*(float)Math.PI/1800)*2f+1.5f, this.y+stufenhoehe*p+0.05f));
    
//      myShape.addParam(new Zylinder(0.1f,0.1f,0.4f), 
//          new Point(this.x+(float)Math.cos(p*bogen*(float)Math.PI/1800)*2.7f, this.z+(float)Math.sin(p*bogen*(float)Math.PI/1800)*2.7f, this.y+stufenhoehe*p+0.05f));
    
    }
  }
  

  
  
  
}
