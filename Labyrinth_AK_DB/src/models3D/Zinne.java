package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;

public class Zinne extends WandBlock
{
  
  
  
  public Zinne(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
    
    float qX = -Spawner.wandFeld / 2;
    
    for (int oben = 0; oben < 10; oben++)
    {
      
      if (oben % 2 == 0)
      {
        
        for (int rechtsA = 0; rechtsA < wdlaenge; rechtsA++)
        {
          if(oben<6||rechtsA == 0||rechtsA == 3 || rechtsA == 5 || rechtsA == 8 || rechtsA == 10)  //Erschafft alle langen Steine jeder zweiten Reihe
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(rechtsA * 0.26f + qX, 0, oben * 0.06f));
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(-0.065f + qX, 0, oben * 0.06f)); //Erschafft die kurzen Stein am rechten und linken Rand des St¸cks
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point((wdlaenge - 1) * 0.26f + 0.065f + qX, 0, oben * 0.06f));
        
        for (int rechtsB = 0; rechtsB < wdlaenge - 1; rechtsB++)
        {
          if(oben < 6 || rechtsB == 0 || rechtsB == 2 || rechtsB == 5 || rechtsB == 7 || rechtsB == 10)
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),                               //Erschafft alle langen Steine der jeweils anderen Reihe
              new Point(rechtsB * 0.26f + 0.13f + qX, 0, oben * 0.06f));
        }
      }
      
      
      for (int i = 0; i < wdlaenge*2; i++)
      {
      
      
      if(oben % 2 == 0 && oben > 5)
        {
        if( i == 2|| i == 5 || i == 12 || i == 15)
          {
          
       
          
          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(i * 0.13f + qX-0.065f, 0, oben * 0.06f)); //Erschafft die kurzen Steine jeder zweiten Reihe
          }
        
       
        }
      else
      {
        if( i == 0|| i == 7 || i == 10 || i == 17 || i == 20)
        {
          
          
          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(i * 0.13f + qX-0.065f, 0, oben * 0.06f)); //Erschafft die kurzen Steine der jeweils anderen Reihe
        }
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
   *          Biegung des Objekts in Bogenmaﬂ, positive Werte biegen nach links
   */
  public Zinne(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
    
    super(x, y, z, w1, w2, w3, biege);
    
    
    float abstand = 1.7f;
    
    
    for (int oben = 0; oben <10; oben++)
    {
      
      if (oben % 2 == 0)
      {
        
        for (int rechtsA = 0; rechtsA < wdlaenge; rechtsA++)
        {
          double biegend1 = (rechtsA * biege * Math.PI) / 1800;
          double biegend11 = (rechtsA * biege) / 10;
          
          if(oben<6||rechtsA == 0||rechtsA == 3 || rechtsA == 5 || rechtsA == 8 || rechtsA == 10)
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),                                         //Erschafft die langen Steine jeder zweiten Reihe
              new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, oben * 0.06f),
              new float[] { (float) biegend11+90, 0, 0 });
          
        }
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.7f, -0.06f, oben * 0.06f), new float []{90,0,0});        //Erschafft die kurzen Steine der ersten Reihe
        
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), //Erschafft die kurzen Steine der letzten Reihe
            new Point( -0.06f,1.7f, oben * 0.06f),
            new float[] { biege+90, 0, 0 });
        
        for (int rechtsB = 0; rechtsB < wdlaenge - 1; rechtsB++)
        {
          double biegend2 = ((rechtsB+0.5f) * biege * Math.PI) / 1800;
          double biegend22 = ((rechtsB+0.5f) * biege) / 10;
          
          if(oben < 6 || rechtsB == 0 || rechtsB == 2 || rechtsB == 5 || rechtsB == 7 || rechtsB == 10)        //Erschafft die langen Stein der jeweils anderen Reihe
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
                  oben * 0.06f),
              new float[] { (float) biegend22+90, 0, 0 });
        }
      }
      
      for (int i = 0; i < wdlaenge*2; i++)
        {
        double biegend3 = ((i * biege - 45) * Math.PI) / 3600;
        double biegend33 = (i * biege - 45) / 20;
        
        if(oben % 2 == 0 && oben > 5)
          {
          if( i == 2|| i == 5 || i == 12 || i == 15)
            {
            
         
                                                                                //Erschafft die kurzen Steine in jeder zweiten Reihe
            myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),                
                new Point((float) Math.cos(biegend3) * abstand, (float) Math.sin(biegend3) *abstand, oben * 0.06f), new float []{(float) (biegend33 + 90),0,0});
            }
          
         
          }
        else
        {
          if( i == 0|| i == 7 || i == 10 || i == 17 || i == 20)
          {
            
                                                                                //Erschafft die kurzen Steine in der jeweils anderen Reihe
            myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), 
                new Point((float) Math.cos(biegend3) * abstand, (float) Math.sin(biegend3) *abstand, oben * 0.06f), new float []{(float) (biegend33 + 90),0,0});
          }
        }
        
        }
      
    }
   
  }
    
}
