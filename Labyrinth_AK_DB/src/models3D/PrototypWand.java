package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;

public class PrototypWand extends WandBlock
{
  
  public PrototypWand(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
   
    
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
  
  /**
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
  public PrototypWand(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
    
    super(x, y, z, w1, w2, w3, biege);
    
    
    
    for (int k = 0; k < 34; k++)
    {
      
      if (k % 2 == 0)
      {
        
        for (int i = 0; i < wdlaenge; i++)
        {
          double biegend1 = (i * biege * Math.PI) / 3600;
          double biegend11 = (i * biege) / 10;
          
          myShape.addParam(new Quader("Mitte", 0.25f + (i * biege) / 30000, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend1) * i * 0.25f + qX, (float) Math.sin(biegend1) * i * 0.25f, k * 0.06f + boden),
              new float[] { (float) biegend11, 0, 0 });
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(-0.065f + qX, 0, k * 0.06f + boden));
        
        myShape.addParam(new Quader("Mitte", 0.125f + (biege * biege) / 90000, wdbreite, 0.05f),
            new Point((float) Math.cos((biege * Math.PI) / 360) * (2.57f - biege / 1200) + qX,
                (float) Math.sin((biege * Math.PI) / 360) * (2.68f - biege / 600), k * 0.06f + boden),
            new float[] { biege, 0, 0 });
        
        for (int i = 0; i < wdlaenge - 1; i++)
        {
          double biegend2 = ((i + 0.5f) * biege * Math.PI) / 3600;
          double biegend22 = ((i + 0.5f) * biege) / 10;
          
          myShape.addParam(new Quader("Mitte", 0.25f + (i * biege) / 30000, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend2) * i * 0.25f + 0.13f + qX, (float) Math.sin(biegend2) * i * 0.25f,
                  k * 0.06f + boden),
              new float[] { (float) biegend22, 0, 0 });
        }
      }
    }
   
  }
}
