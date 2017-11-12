package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;

public class BeschaedigteWand extends WandBlock
{
  public BeschaedigteWand(float x, float y, float z, float w1, float w2, float w3)
  {
  super(x,y,z,w1,w2,w3);
  

  
  for (int k = 0; k<wdhoehe; k++)
  {
    
    
    if ( k % 2 == 0)
    {
     
        for (int i = 0; i<wdlaenge; i++)
        {
          if (!(( i > 3 && i < 7 ) && ( k > 17 && k < 23)))
          {
            if(!(i == 3 && k == 8))
              myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.26f+qX,0,k*0.06f+boden));
          }
       }
    }
    else
      {
      myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+qX,0,k*0.06f+boden));
      myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((wdlaenge-1)*0.26f+0.065f+qX,0,k*0.06f+boden));
         
        for (int i = 0; i<wdlaenge-1;i++)
          {           
            if (!(( i > 3 && i < 7 ) && ( k > 17 && k < 23))) 
             {
              if (!( i == 9 && k == 13))
                myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (i*0.26f+0.13f+qX,0,k*0.06f+boden));
             }
          }
       }
    }
  

  
  }
}
