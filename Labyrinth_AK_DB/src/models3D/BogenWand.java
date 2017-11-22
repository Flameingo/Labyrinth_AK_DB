package models3D;

import basics.Point;
import params.Quader;

public class BogenWand extends WandBlock
{
  
  public BogenWand(float x, float y, float z, float alpha, float beta, float gamma, float biege)
  {
    
    super(x, y, z, alpha, beta, gamma, biege);
    
    
    float abstand = 1.7f; // ursp. 1.7f
    
    
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

  

