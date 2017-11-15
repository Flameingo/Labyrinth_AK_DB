package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;

public class WandTest extends WandBlock
{
  
  
  
  public WandTest(float x, float y, float z, float w1, float w2, float w3, float laenge, float hoehe)
  {
    super(x, y, z, w1, w2, w3);
    float vX = laenge/2;
    //float haha = hoehe*100/2.6f - (int) hoehe*100/2.6f;
    for (int hoch = 0; hoch < hoehe*100/6; hoch++)
    {
      
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts < (laenge)*10/2.6 ; rechts++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(rechts * 0.26f + vX, 0, hoch * 0.06f));
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(-0.065f + vX, 0, hoch * 0.06f));
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point((float) ( laenge + 0.04f*(laenge-5)+ vX), 0, hoch * 0.06f));
        
        for (int i = 0; i < (laenge)*10/2.6 - 1; i++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point(i * 0.26f + 0.13f + vX, 0, hoch * 0.06f));
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
  public WandTest(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
    
    super(x, y, z, w1, w2, w3, biege);
    
    
    float abstand = 1.7f;
    
    
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
              new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, hoch * 0.06f),
              new float[] { (float) biegend11+90, 0, 0 });
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.7f, -0.06f, hoch * 0.06f), new float []{90,0,0});
        double schieb = biege*Math.PI/180;
        if (biege == 45)
        {
          schieb = (biege-1.5)*Math.PI/180;
        }
        myShape.addParam(new Quader("Mitte", 0.125f*(1+2*(float)Math.cos(schieb)/3), wdbreite, 0.05f),
            new Point( -0.06f+1.70f*(float)Math.cos(schieb),0.08f*(float)Math.cos(biege*Math.PI/180)+1.7f*(float)Math.sin(schieb), hoch * 0.06f),
            new float[] { biege+90, 0, 0 });
        
        for (int rechts = 0; rechts < wdlaenge - 1; rechts++)
        {
          double biegend2 = ((rechts+0.5f) * biege * Math.PI) / 1800;
          double biegend22 = ((rechts+0.5f) * biege) / 10;
          if(biege != 45 || rechts %2 != 1)
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
                  hoch * 0.06f),
              new float[] { (float) biegend22+90, 0, 0 });
        }
      }
    }
   
  }
    
}
