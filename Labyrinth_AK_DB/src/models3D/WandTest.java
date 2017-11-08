package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;

public class WandTest extends WandBlock
{
  
  
  
  public WandTest(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
    
    float qX = -Spawner.wandFeld / 2;
    
    for (int k = 0; k < wdhoehe; k++)
    {
      
      if (k % 2 == 0)
      {
        
        for (int i = 0; i < wdlaenge; i++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i * 0.26f + qX, 0, k * 0.06f));
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(-0.065f + qX, 0, k * 0.06f));
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point((wdlaenge - 1) * 0.26f + 0.065f + qX, 0, k * 0.06f));
        
        for (int i = 0; i < wdlaenge - 1; i++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point(i * 0.26f + 0.13f + qX, 0, k * 0.06f));
        }
      }
    }
  }
  
  /** Aktuell nur fuer 90 grad (biege = 90) geeignet, fuer unregelmaessige Gradzahlen empfiehlt sich PrototypWand
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
    
    
    for (int k = 0; k < wdhoehe; k++)
    {
      
      if (k % 2 == 0)
      {
        
        for (int i = 0; i < wdlaenge; i++)
        {
          double biegend1 = (i * biege * Math.PI) / 1800;
          double biegend11 = (i * biege) / 10;
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, k * 0.06f),
              new float[] { (float) biegend11+90, 0, 0 });
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.7f, -0.06f, k * 0.06f), new float []{90,0,0});
        
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point( -0.06f,1.7f, k * 0.06f),
            new float[] { biege+90, 0, 0 });
        
        for (int i = 0; i < wdlaenge - 1; i++)
        {
          double biegend2 = ((i+0.5f) * biege * Math.PI) / 1800;
          double biegend22 = ((i+0.5f) * biege) / 10;
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
                  k * 0.06f),
              new float[] { (float) biegend22+90, 0, 0 });
        }
      }
    }
   
  }
    
}
