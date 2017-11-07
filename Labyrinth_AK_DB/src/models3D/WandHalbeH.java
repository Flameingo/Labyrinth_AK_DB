package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;
import params.Shape;

public class WandHalbeH extends WandBlock
{
  public WandHalbeH(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
    
    float qX = -Spawner.wandFeld / 2.0F;
    
    for (int k = 0; k < wdhoehe / 2 + 1; k++)
    {

      if (k % 2 == 0)
      {

        for (int i = 0; i < wdlaenge; i++)
        {

          myShape.addParam(new Quader("Mitte", 0.25F, wdbreite, 0.05F), new Point(i * 0.26F + qX, 0.0F, k * 0.0575F));
        }
      }
      else
      {
        myShape.addParam(new Quader("Mitte", 0.125F, wdbreite, 0.05F), new Point(-0.065F + qX, 0.0F, k * 0.0575F));
        myShape.addParam(new Quader("Mitte", 0.125F, wdbreite, 0.05F), 
          new Point((wdlaenge - 1) * 0.26F + 0.065F + qX, 0.0F, k * 0.0575F));
        
        for (int i = 0; i < wdlaenge - 1; i++)
        {

          myShape.addParam(new Quader("Mitte", 0.25F, wdbreite, 0.05F), 
            new Point(i * 0.26F + 0.13F + qX, 0.0F, k * 0.0575F));
        }
      }
    }
  }
  














  public WandHalbeH(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
    super(x, y, z, w1, w2, w3, biege);
    

    float abstand = 1.7F;
    

    for (int k = 0; k < wdhoehe / 2 + 1; k++)
    {

      if (k % 2 == 0)
      {

        for (int i = 0; i < wdlaenge; i++)
        {
          double biegend1 = i * biege * Math.PI / 1800;
          double biegend11 = i * biege / 10.0F;
          
          myShape.addParam(new Quader("Mitte", 0.25F, wdbreite, 0.05F), 
            new Point((float)Math.cos(biegend1) * abstand, (float)Math.sin(biegend1) * abstand, k * 0.0575F), 
            new float[] { (float)biegend11 + 90.0F, 0.0F, 0.0F });
        }
      }
      else
      {
        myShape.addParam(new Quader("Mitte", 0.125F, wdbreite, 0.05F), new Point(1.7F, -0.06F, k * 0.0575F), new float[] { 90.0F, 0.0F, 0.0F });
        
        myShape.addParam(new Quader("Mitte", 0.125F, wdbreite, 0.05F), 
          new Point(-0.06F, 1.7F, k * 0.0575F), 
          new float[] { biege + 90.0F, 0.0F, 0.0F });
        
        for (int i = 0; i < wdlaenge - 1; i++)
        {
          double biegend2 = (i + 0.5F) * biege * Math.PI / 1800;
          double biegend22 = (i + 0.5F) * biege / 10.0F;
          
          myShape.addParam(new Quader("Mitte", 0.25F, wdbreite, 0.05F), 
            new Point((float)Math.cos(biegend2) * abstand, (float)Math.sin(biegend2) * abstand, 
            k * 0.0575F), 
            new float[] { (float)biegend22 + 90.0F, 0.0F, 0.0F });
        }
      }
    }
  }
}