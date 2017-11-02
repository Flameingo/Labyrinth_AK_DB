package models3D;

import basics.Point;
import params.*;

public class RundeTreppe3  extends Treppe 
{
  public RundeTreppe3(float x, float y, float z, float alpha, float beta, float gamma,float bogen, float treppenlaenge)
  {
    super(x, y, z, alpha, beta, gamma);
    
    this.bogen = bogen;
    
    this.treppenlaenge = treppenlaenge;
    
    for (int stufe = 0; stufe < this.treppenlaenge; stufe++)
    {
      for(int lang = 0; lang<4; lang++)
        {
        for(int breit = 0; breit<10; breit++)
          {
          for(int hoch = 0; hoch <5; hoch++)
          {
          myShape.addParam(new Quader("Mitte",0.1f,0.15f,0.0397f), 
                  new Point(
                      (0.6f+breit*0.105f)*(float)Math.cos(Math.PI*stufe*bogen/3600)+0.153f*lang*(float)-Math.sin(Math.PI*stufe*bogen/3600),
                      (0.6f+breit*0.105f)*(float)Math.sin(Math.PI*stufe*bogen/3600)+0.153f*lang*(float)Math.cos(Math.PI*stufe*bogen/3600),
                      stufe*0.2f+0.04f*hoch
                      ),
                  new float[]{stufe*18,0,0});
            }
          }
        }
      }
   
    myShape.addParam(new Zylinder(0.545f,0.545f,5.9f), new Point(0,0,0));
  }
}  

  
  
  

