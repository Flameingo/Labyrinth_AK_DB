package models3D;

import basics.Point;
import params.*;

public class RundeTreppe3  extends Treppe //KACKFUNKTION
{
  public RundeTreppe3(float x, float y, float z, float alpha, float beta, float gamma,float bogen, float treppenlaenge)
  {
    super(x, y, z, alpha, beta, gamma);
    
    this.bogen = bogen;
    
    this.treppenlaenge = treppenlaenge;
    
    for (int q = 0; q < this.treppenlaenge+1; q++)
    {
      
      
      myShape.addParam(new Kreisabschnitt(1,1,90), new Point(0,0,stufenhoehe*q*0.8f), new float[]{q*36,0,0}); //Programmiert die einzelnen Scheiben um einen Mittelpunkt herum zu einer Treppe
    }
//    for (int p = 0; p < this.treppenlaenge; p++)
//    {
//      myShape.addParam(new Zylinder(0.1f,0.1f,0.4f), 
//          new Point(this.x+(float)Math.cos(p*bogen*(float)Math.PI/1800)*2f+1, this.z+(float)Math.sin(p*bogen*(float)Math.PI/1800)*2f+1.5f, this.y+stufenhoehe*p+0.05f));
//    
////      myShape.addParam(new Zylinder(0.1f,0.1f,0.4f), 
////          new Point(this.x+(float)Math.cos(p*bogen*(float)Math.PI/1800)*2.7f, this.z+(float)Math.sin(p*bogen*(float)Math.PI/1800)*2.7f, this.y+stufenhoehe*p+0.05f));
    
//    }  //Aktuell nicht genutzter Abschnitt, der ursprünglich Stützpfeiler zwischen die Stufen stellen sollte.
  }
}  

  
  
  

