package models3D;

import basics.Point;
import params.Quader;

public class Wand extends WandBlock
{
                             //Wichtigste Klasse fuer den Bau des Labyrinths, da sie das Standartwandstueck produziert.
						     //Drehung und Verschiebung des Objektes findet in der Oberklasse "WandBlock" statt.
							 //Die Klassen aus Path, die mit dieser Klasse arbeiten, bedienen sich zumeist des Konstruktors, fuer den Laenge und 
							 //Hoehe vom Programmierer uebergeben werden muessen, der Zweite von oben in dieser Klasse.

  
  /** Zeichnet eine Wand mit vorgegebenen Laengenmassen und Hoehenmassen.
   *  Lage des Mittelpunktes bzgl x - und y - Koordinate und Drehungen koennen bestimmt werden.
   *  Die meisten Klassen aus "path" greifen auf diesen Konstruktor zu.
   * @param x Mittelpunkt
   * @param y Mittelpunkt
   * @param z Tiefster Punkt
   * @param alpha Drehung z - Achse
   * @param beta ... y - Achse
   * @param gamma ... x - Achse
   * @param laenge Laengenwert genau anzugeben, nicht die Steinanzahl. Wird abgerundet, wenn der naechste volle Stein nicht erreicht ist.
   * @param hoehe Hoehenwert ebenfalls in f anzugeben.
   */
  public Wand(float x, float y, float z, float alpha, float beta, float gamma, float laenge, float hoehe) 
  {
    super(x, y, z, alpha, beta, gamma);
    /** 
     Verschiebung um die x - Achse mit der Absicht, dass der Ursprung Mittelpunkt des Wandstuecks (abgesehen vom z-Wert(Hoehe)) ist*/
    float vX = - laenge/2; 
    
    putz.addParam(new Quader("Mitte", laenge ,wdbreite*1/2, hoehe - 0.1f), new Point(-0.1f,0,hoehe/2)); //Zeichnet den Zement in einer anderen Farbe 
                                                                                            // als die Backsteine (daher putz und nicht myShape).
    
    
    for (int hoch = 0; hoch < hoehe*100/6; hoch++)
    {
     
      
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts < (laenge)*10/2.6 ; rechts++)          
        {
          if(rechts != 0 && rechts != (int)(laenge*10/2.6))
        	  myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(rechts * 0.26f + vX, 0, hoch * 0.06f+boden));
                                                  //Backsteinreihe, die unterste und jede zweite
                                                  //Jeder Backstein wird so erschaffen, dass seine Koordinaten (Point) seinen Mittelpunkt bilden.
          else
          {
        	  stein.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(rechts * 0.26f + vX, 0, hoch * 0.06f+boden)); //Der Aufruf stein sorgt dafuer, dass
          }																														  //Randsteine nicht nur die Zufallsfunktion
          																														  //farblich bestimmt werden, die "myShape.draw()"
        }																														  //betrifft.
        
      } else
      {
        stein.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point(-0.065f + vX, 0, hoch * 0.06f+boden));                                 //Halbe Steinreihe am Wandrand.
        stein.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f),
            new Point( (int)(laenge*10/2.6f)*0.26f+0.0625f+vX, 0, hoch * 0.06f+boden));  //Halbe Steinreihe am anderen Wandrand.
        
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
  
  /** Aktuell nur fuer die Werte 45 (45 Grad Biegung) und 90 (90 Grad Biegung) fuer 'biege' geeignet. Benutzt in den "LabEck"-Klassen aus "path".
   * 
   * @param x Mittelpunkt
   * @param y Mittelpunkt
   * @param z Tiefster Punkt
   * @param w1
   *          Drehung um die z-Achse
   * @param w2
   *          Drehung um die y-Achse
   * @param w3
   *          Drehung um die x-Achse
   * @param biege
   *          Biegung des Objekts in Bogenmass, positive Werte biegen nach links
   */
  public Wand(String Egal, float x, float y, float z, float alpha, float beta, float gamma, float biege)	//Der einzige Sinn des Strings besteht darin
  {																										    //dass es dem Programmierer schwerer faellt, die
	  																										//Konstruktoren fuer die gebogene Wand und fuer die 
	super(x, y, z, alpha, beta, gamma, biege);															   	    //gerade Wand zu verwechseln, da diese aehnliche Eintraege
	  																										//verlangen.
    
    float abstand = 1.7f; // ursp. 1.7f
    
    
    for (int hoch = 0; hoch < wdhoehe; hoch++) //Die Schlaufe erschafft mit jeder Iteration eine Reihe der Wand, dabei gibt es
    {                                          //eine Fallunterscheidung, die dafuer sorgt, dass jede zweite Reihe um eine halbe 
                                               //Backsteinlaenge versetzt ist.
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts < wdlaenge; rechts++) //Jede Iteration erschafft einen langen Stein.
        {
          double biegend1 = (rechts * biege * Math.PI) / 1800;
          double biegend11 = (rechts * biege) / 10;
          
          if(biege != 45 || rechts %2 != 1)                //Einfache Fallunterscheidung, da nur zwischen 45 und 90 unterschieden werden muss.
                                                           //Tatsaechlich braucht die 45grad Wand nur halb so viele Steine wie die 90grad Wand
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
              new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, hoch * 0.06f+boden),
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
              new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
                  hoch * 0.06f+boden),
              new float[] { (float) biegend22+90, 0, 0 });
        }
      }
    }   
  }    

  public Wand(String Egal, float x, float y, float z, float alpha, float beta, float gamma, float biege, float hoehe) //Der einzige Sinn des Strings besteht darin
  {																													  //dass es dem Programmierer schwerer faellt, die
	  																												  //Konstruktoren fuer die gebogene Wand und fuer die 
    super(x, y, z, alpha, beta, gamma, biege);																		  //gerade Wand zu verwechseln, da diese aehnliche Eintraege
    																												  //verlangen.
    
    float abstand = 1.7f; // ursp. 1.7f - Abstand jedes Steins zum Kreismittelpunkt.
    
    
    for (int hoch = 0; hoch < hoehe*100/6; hoch++) //Die Schlaufe erschafft mit jeder Iteration eine Reihe der Wand, dabei gibt es
    {                                          //eine Fallunterscheidung, die dafuer sorgt, dass jede zweite Reihe um eine halbe 
                                               //Backsteinlaenge versetzt ist.
      if (hoch % 2 == 0)
      {
        
        for (int rechts = 0; rechts < wdlaenge; rechts++) //Jede Iteration erschafft einen langen Stein.
        {
          double biegend1 = (rechts * biege * Math.PI) / 1800;
          double biegend11 = (rechts * biege) / 10;
          
          if(biege != 45 || rechts %2 != 1)                //Einfache Fallunterscheidung, da nur zwischen 45 und 90 unterschieden werden muss.
          {                                                 //Tatsaechlich braucht die 45grad Wand nur halb so viele Steine wie die 90grad Wand
        	 if(rechts != 0 && rechts != wdlaenge - 1)
        	  myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
        			  new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, hoch * 0.06f+boden),
        			  new float[] { (float) biegend11+90, 0, 0 });   //Unterste Steinreihe und jede zweite darueber  
        	 else
        	 {
        		 stein.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f),
           			  new Point((float) Math.cos(biegend1) * abstand, (float) Math.sin(biegend1) *abstand, hoch * 0.06f+boden),
           			  new float[] { (float) biegend11+90, 0, 0 });   //Unterste Steinreihe und jede zweite darueber  
        	 }
          }
        }
      }
      else
      {
        stein.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.7f, -0.06f, hoch * 0.06f+boden), new float []{90,0,0});
        double schieb = biege*Math.PI/180; //Kurze Randsteine fuer jede zweite Reihe
        if (biege == 45)
        {
          schieb = (biege-1.5)*Math.PI/180; //Kleine Korrektur, damit alle Randsteine fuer 45 Grad auch stimmen.
        }
        stein.addParam(new Quader("Mitte", 0.125f*(1+2*(float)Math.cos(schieb)/3), wdbreite, 0.05f),
            new Point( -0.06f+1.70f*(float)Math.cos(schieb),0.08f*(float)Math.cos(biege*Math.PI/180)+1.7f*(float)Math.sin(schieb), hoch * 0.06f+boden),
            new float[] { biege+90, 0, 0 }); //Kurze Randsteine fuer jede zweite Reihe fuer die andere Seite
        
        for (int rechts = 0; rechts < wdlaenge - 1; rechts++) //Jede Iteration erschafft einen langen Stein.
        {
          double biegend2 = ((rechts+0.5f) * biege * Math.PI) / 1800;
          double biegend22 = ((rechts+0.5f) * biege) / 10;
          if(biege != 45 || rechts %2 != 1) //Einfache Fallunterscheidung, da nur zwischen 45 und 90 unterschieden werden muss.  
                                           //Tatsaechlich braucht die 45grad Wand nur halb so viele Steine wie die 90grad Wand
          if (rechts != 0 && rechts != wdlaenge - 2)  
        	  myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), //Die zweite Steinreihe von unten und jede zweite.
        			  new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
        					  hoch * 0.06f+boden),
        			  new float[] { (float) biegend22+90, 0, 0 });
          
          else
          {
        	   stein.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), //Die zweite Steinreihe von unten und jede zweite.
        	              new Point((float) Math.cos(biegend2) * abstand , (float) Math.sin(biegend2) * abstand ,
        	                  hoch * 0.06f+boden),
        	              new float[] { (float) biegend22+90, 0, 0 });
          }
        }
      }
    }   
  }    

  public Wand(float x, float y, float z, float alpha, float beta, float gamma, float biege) //Erstellt eine gebogene Wand mit obenstehendem Konstruktur.
  {                                                                                         //Macht auch exakt das Selbe wie ein Aufruf von dem just drueber stehenden
	  this("Egal",x,y,z,alpha, beta, gamma, biege);											//Konstruktor.
  }
  


  /** Zeichnet ein Wandstueck mit der Laenge 5.2f und der Hoehe 1.5f
   * 
   * @param x
   * @param y
   * @param z
   * @param alpha Drehung um die z - Achse.
   * @param beta Drehung um die y - Achse.
   * @param gamma Drehung um die x - Achse.
   */
  public Wand(float x, float y, float z, float alpha, float beta, float gamma)
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
  
}
