package unused;

import basics.Point;
import main.Spawner;
import models3D.WandBlock;
import params.Quader;

public class TuerWand extends WandBlock
{

  public TuerWand(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
    
 
    
    for (int k = 0; k<wdhoehe; k++)
    {           
      
      if ( k % 2 == 0 )
      {
        if ( k < 22 )
          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(5*0.247f+qX,0,k*0.06f + boden));      
        
       
          for (int i = 0; i<wdlaenge; i++)
          {
            if (!(( i > 4 && i < 8 ) && ( k < 22 )))
            {
              myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.26f+qX,0,k*0.06f + boden));
            }
         }
      }
      else
        {
        
        if ( k < 22 )
          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(8*0.252f+qX,0,k*0.06f + boden));
        
        myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+qX,0,k*0.06f + boden));
        myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((wdlaenge-1)*0.26f+0.065f+qX,0,k*0.06f + boden));
           
          for (int i = 0; i<wdlaenge-1;i++)
            {           
              if (!(( i > 4 && i < 8 ) && ( k < 22 ))) 
               {
                myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (i*0.26f+0.13f+qX,0,k*0.06f + boden));
               }
            }
         }
      }
  
  } 
  
  
  public TuerWand(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
    
    super(x, y, z, w1, w2, w3, biege);
    
    
    float abstand = 1.7f;
    
    
    for (int k = 0; k < wdhoehe; k++)
    {
      
      if (k % 2 == 0)  //Die unterste Reihe und jede zweite Reihe
      {
        if ( k < 22 )
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point(1.7f*(float)Math.cos(((4.73f) * biege*Math.PI) / 1800),1.7f*(float)Math.sin(((4.73f) * biege*Math.PI) / 1800),k*0.06f + boden),
            new float [] {130,0,0}); //Die halbe Steinreihe an der linken Seite der Tuer von außen gesehen
        
        for (int i = 0; i < wdlaenge; i++)
        {
          double biegend1 = (i * biege * Math.PI) / 1800;
          double biegend11 = (i * biege) / 10;
          
          
          if (!(( i > 4 && i < 8 ) && ( k < 22 )))              //Programmiert die Steine außerhalb des Tuerbereiches
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, k * 0.06f + boden),
              new float[] { (float) biegend11+90, 0, 0 });
          
        }
      } 
      
      else  //Die zweite Reihe von unten und jede zweite Reihe von dort aus gesehen
      {
        
        if ( k < 22 )
          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), 
              new Point(1.7f*(float)Math.cos(((7.75f) * biege * Math.PI) / 1800),1.7f*(float)Math.sin(((7.75f) * biege * Math.PI) / 1800),k*0.06f+boden ),
              new float []{38.75f+124,0,0});  //Die halbe Steinreihe an der rechten Seite der Tuer von außen gesehen
        
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point(1.7f, -0.06f, k * 0.06f+boden), 
            new float []{90,0,0}); //Die letzte halbe Steinreihe
        
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point( -0.06f,1.7f, k * 0.06f+boden),
            new float[] { biege+90, 0, 0 }); //Die erste halbe Steinreihe
        
        for (int i = 0; i < wdlaenge - 1; i++)
        {
          double biegend2 = ((i+0.5f) * biege * Math.PI) / 1800; 
          double biegend22 = ((i+0.5f) * biege) / 10;
          
          
          if (!(( i > 4 && i < 8 ) && ( k < 22 )))
            myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),        //Programmiert die Steine außerhalb des Tuerbereiches
                new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
                  k * 0.06f+boden),
                new float[] { (float) biegend22+90, 0, 0 });
        }
      }
    }
   
    
    
  }
  
    
}
