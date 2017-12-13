package unused;

import basics.Point;
import models3D.WandBlock;
import params.Quader;

public class Test extends WandBlock
{
  
  public Test(float x, float y, float z, float alpha, float beta, float gamma)
  {
    super(x, y, z, alpha, beta, gamma);
   
    putz.addParam(new Quader("Mitte", 2.8f ,wdbreite*1/2,1.4f), new Point(-1.55f,0,0.75f)); //Zeichnet den Zement in einer anderen Farbe 
                                                                                            // als die Backsteine
    
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
  
  public Test(float x, float y, float z, float alpha, float beta, float gamma, float laenge, float hoehe)
  {
    super(x, y, z, alpha, beta, gamma);
    /** 
     Verschiebung um die x - Achse mit der Absicht, dass der Ursprung Mittelpunkt des Wandstuecks (abgesehen vom z-Wert) ist*/
    float vX = - laenge/2; 
    
    putz.addParam(new Quader("Mitte", laenge ,wdbreite*1/2, hoehe - 0.1f), new Point(-0.1f,0,hoehe/2)); //Zeichnet den Zement in einer anderen Farbe 
                                                                                            // als die Backsteine (daher putz und nicht myShape).
    
    
    for (int hoch = 0; hoch < hoehe*100/6; hoch++)
    {
     
      
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts < (laenge)*10/2.6 ; rechts++)          
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(rechts * 0.26f + vX, 0, hoch * 0.06f+boden));
                                                  //Backsteinreihe, die unterste und jede zweite
                                                  //Jeder Backstein wird so erschaffen, dass seine Koordinaten (Point) seinen Mittelpunkt bilden.
                    
        }
        
      } else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point(-0.065f + vX, 0, hoch * 0.06f+boden));                                 //Halbe Steinreihe am Wandrand
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point( (int)(laenge*10/2.6f)*0.26f+0.0625f+vX, 0, hoch * 0.06f+boden));  //Halbe Steinreihe am anderen Wandrand
        
        for (int rechts2 = 0; rechts2 < (laenge)*10/2.6 - 1; rechts2++)
        {
          
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point(rechts2 * 0.26f + 0.13f + vX, 0, hoch * 0.06f+boden));
                                        //Backsteinreihe, die unterste und jede zweite
                                        //Jeder Backstein wird so erschaffen, dass seine Koordinaten (Point) seinen Mittelpunkt bilden.
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
  public Test(float x, float y, float z, float alpha, float beta, float gamma, float biege, float laenge, float hoehe)
  {
    
    super(x, y, z, alpha, beta, gamma, biege);
    
    
    float abstand = 1.7f; // ursp. 1.7f
    
    
    for (int hoch = 0; hoch < wdhoehe; hoch++) //Die Schlaufe erschafft mit jeder Iteration eine Reihe der Wand, dabei gibt es
    {                                          //eine Fallunterscheidung, die dafuer sorgt, dass jede zweite Reihe um eine halbe 
    												//Backsteinlaenge versetzt ist.
    	float a =3f;
        float b = 1.5f;
    	
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts < wdlaenge; rechts++) //Jede Iteration erschafft einen langen Stein.
        {
          double biegend1 = (rechts * biege * Math.PI) / 1800;
          double biegend11 = (rechts * biege) / 10;
          
          
          if(biege != 45 || rechts %2 != 1)                //Einfache Fallunterscheidung, da nur zwischen 45 und 90 unterschieden werden muss.
                                                           //Tatsaechlich braucht die 45grad Wand nur halb so viele Steine wie die 90grad Wand
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend1) * a, (float) Math.sin(biegend1) *b, hoch * 0.06f+boden),
              new float[] { (float) biegend11+90, 0, 0 });   //Unterste Steinreihe und jede zweite darueber        
        }
      }
      else
      {
        myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.7f, -0.06f, hoch * 0.06f), new float []{90,0,0});
        double schieb = biege*Math.PI/180; //Kurze Randsteine fuer jede zweite Reihe
        if (biege == 45)
        {
          schieb = (biege-1.5)*Math.PI/180; //Kleine Korrektur, damit alle Randsteine fuer 45 Grad auch stimmen.
        }
        myShape.addParam(new Quader("Mitte", 0.125f*(1+2*(float)Math.cos(schieb)/3), wdbreite, 0.05f),
            new Point( -0.06f+1.70f*(float)Math.cos(schieb),0.08f*(float)Math.cos(biege*Math.PI/180)+1.7f*(float)Math.sin(schieb), hoch * 0.06f+boden),
            new float[] { biege+90, 0, 0 }); //Kurze Randsteine fuer jede zweite Reihe fuer die andere Seite
        
        for (int rechts = 0; rechts < wdlaenge - 1; rechts++) //Jede Iteration erschafft einen langen Stein.
        {
          double biegend2 = ((rechts+0.5f) * biege * Math.PI) / 1800;
          double biegend22 = ((rechts+0.5f) * biege) / 10;
          if(biege != 45 || rechts %2 != 1) //Einfache Fallunterscheidung, da nur zwischen 45 und 90 unterschieden werden muss.  
                                           //Tatsaechlich braucht die 45grad Wand nur halb so viele Steine wie die 90grad Wand
            
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), //Die zweite Steinreihe von unten und jede zweite.
              new Point((float) Math.cos(biegend2) * a , (float) Math.sin(biegend2) * b ,
                  hoch * 0.06f+boden),
              new float[] { (float) biegend22+90, 0, 0 });
        }
      }
    }   
  }    
}
