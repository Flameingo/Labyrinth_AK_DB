package models3D;

import basics.Point;
import params.Quader;

public class Wand extends WandBlock
{
  
  public Wand(float x, float y, float z, float alpha, float beta, float gamma)
  {
    super(x, y, z, alpha, beta, gamma);
   
    
    for (int k = 0; k < wdhoehe; k++)
    {
      
      if (k % 2 == 0)
      {
        
        for (int i = 0; i < wdlaenge; i++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i * 0.26f + qX, 0, k * 0.06f+boden));
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(-0.065f + qX, 0, k * 0.06f+boden));
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point((wdlaenge - 1) * 0.26f + 0.065f + qX, 0, k * 0.06f+boden));
        
        for (int i = 0; i < wdlaenge - 1; i++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point(i * 0.26f + 0.13f + qX, 0, k * 0.06f + boden));
        }
      }
    }
  }
  
  public Wand(float x, float y, float z, float alpha, float beta, float gamma, float laenge, float hoehe)
  {
    super(x, y, z, alpha, beta, gamma);
    /** 
     Verschiebung um die x - Achse mit der Absicht, dass der Ursprung Mittelpunkt des Wandstuecks (abgesehen vom z-Wert) ist*/
    float vX = - laenge/2; 
    
    for (int hoch = 0; hoch < (int) hoehe*100/6; hoch++)
    {
      
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts <(int) (laenge)*10/2.6 ; rechts++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(rechts * 0.26f + vX, 0, hoch * 0.06f+boden));
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(-0.065f + vX, 0, hoch * 0.06f+boden));
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point( (int)(laenge*10/2.6f)*0.26f+0.0625f+vX, 0, hoch * 0.06f+boden));
        
        for (int i = 0; i < (laenge)*10/2.6 - 1; i++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point(i * 0.26f + 0.13f + vX, 0, hoch * 0.06f+boden));
        }
      }
    }
  }
  
  /** Aktuell nur fuer die Werte 45 (45 Grad Biegung) und 90 (90 Grad Biegung) fuer 'biege' geeignet.
   * 
   * @param x
   * @param y
   * @param z
   * @param w1
   *          Drehung um die z-Achse
   * @param w2
   *          Drehung um die y-Achse
   * @param w3
   *          Drehung um die x-Achse
   * @param biege
   *          Biegung des Objekts in Bogenmaß, positive Werte biegen nach links
   */
  public Wand(float x, float y, float z, float alpha, float beta, float gamma, float biege)
  {
    
    super(x, y, z, alpha, beta, gamma, biege);
    
    
    float abstand = 2.5f; // ursp. 1.7f
    
    
    for (int hoch = 0; hoch < wdhoehe; hoch++)
    {
      
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts < wdlaenge; rechts++)
        {
          double biegend1 = (rechts * biege * Math.PI) / 1800;
          double biegend11 = (rechts * biege) / 10;
          
          if(biege != 45 || rechts %2 != 1)
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, hoch * 0.06f+boden),
              new float[] { (float) biegend11+90, 0, 0 });          
        }
      }
      else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.7f, -0.06f, hoch * 0.06f), new float []{90,0,0});
        double schieb = biege*Math.PI/180;
        if (biege == 45)
        {
          schieb = (biege-1.5)*Math.PI/180;
        }
        myShape.addParam(new Quader("Mitte", 0.125f*(1+2*(float)Math.cos(schieb)/3), wdbreite, 0.05f),
            new Point( -0.06f+1.70f*(float)Math.cos(schieb),0.08f*(float)Math.cos(biege*Math.PI/180)+1.7f*(float)Math.sin(schieb), hoch * 0.06f+boden),
            new float[] { biege+90, 0, 0 });
        
        for (int rechts = 0; rechts < wdlaenge - 1; rechts++)
        {
          double biegend2 = ((rechts+0.5f) * biege * Math.PI) / 1800;
          double biegend22 = ((rechts+0.5f) * biege) / 10;
          if(biege != 45 || rechts %2 != 1)
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
                  hoch * 0.06f+boden),
              new float[] { (float) biegend22+90, 0, 0 });
        }
      }
    }   
  }    
}
