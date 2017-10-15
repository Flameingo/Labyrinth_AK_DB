package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;

public class TuerWand extends WandBlock
{

  public TuerWand(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
    
    float qX = this.x - Spawner.wandFeld/2;
    
    for (int k = 0; k<wdhoehe; k++)
    {           
      
      if ( k % 2 == 0 )
      {
        if ( k < 22 )
          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(5*0.247f+qX,this.z,k*0.06f+this.y));      
        
       
          for (int i = 0; i<wdlaenge; i++)
          {
            if (!(( i > 4 && i < 8 ) && ( k < 22 )))
            {
              myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.26f+qX,this.z,k*0.06f+this.y));
            }
         }
      }
      else
        {
        
        if ( k < 22 )
          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(8*0.252f+qX,this.z,k*0.06f+this.y));
        
        myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+qX,this.z,k*0.06f+this.y));
        myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((wdlaenge-1)*0.26f+0.065f+qX,this.z,k*0.06f+this.y));
           
          for (int i = 0; i<wdlaenge-1;i++)
            {           
              if (!(( i > 4 && i < 8 ) && ( k < 22 ))) 
               {
                myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (i*0.26f+0.13f+qX,this.z,k*0.06f+this.y));
               }
            }
         }
      }
    
  } 
}
