package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import params.Kegel;
import params.Kugel;
import params.Material;
import params.Quader;
import params.Shape;
import params.Zylinder;

public class Eckstein extends Objekt
{
  
  protected Shape myShape = new Shape();
  protected Shape putz    = new Shape();
  protected Shape kuppel = new Shape();
  
  public Eckstein(float x, float y, float alpha, float beta, float gamma, int hoehe) //Stehen immer auf der Ebene z = 0
  {
    
    putz.addParam(new Quader("Mitte", 0.2f, 0.2f, hoehe * 0.19f), new Point(0, 0, 0.1f * hoehe)); //Zeichnet einen Quader in die Mitte des Objektes, um den Zwischenraum 
    																							  
    putz.addParam(new Quader("Mitte", 0.075f, 0.075f, 0.19f), new Point(0, 0, (hoehe - 0.5f) * 0.2f)); //zwischen den Backsteinen auszufuellen.
    
    
                                               //Die Kuppel, die die Spitze des Ecksteins ziert
     
    float radius = 0.1f;
    pushZusatzAufloesung(3);											 //Bei 2 oder hoeher steht die FPS - Anzeige ingame konstant auf 0. UEBERPRUEFEN
    	kuppel.addParam(new Kugel(radius), new Point(0,0,(hoehe)*0.2f + radius - 0.05f));
    	kuppel.addParam(new Kegel(radius/2,radius/2, 0.2f), new Point(0,0,hoehe*0.2f + 3*radius/2 - 0.05f));
    	pushZusatzAufloesung(1);
    		kuppel.addParam(new Kugel(0.02f), new Point(0,0,hoehe*0.2f + 3*radius/2 - 0.05f + 0.19f));
    	popZusatzAufloesung();
    	for(int q = 0; q < 4; q++)
    	{
    		kuppel.addParam(new Zylinder(0.03f,0.03f,0.01f), 
    				new Point(0.09f*(float)Math.cos(q*Math.PI/2),0.09f*(float)Math.sin(q*Math.PI/2),hoehe*0.2f + radius*3/4), 
    				new float[]{0,90*(float)Math.cos(q*Math.PI/2),90*(float)Math.sin(q*Math.PI/2)}); 	
    	}
    popZusatzAufloesung();
    
    
    for (int hoch = 0; hoch < hoehe; hoch++) //Schleife fuer jede Ebene nebeneinanderliegender Steine. Laeuft von unten nach oben.
    {
      if (hoch % 2 == 0) //Betrifft nur jede zweite Reihe, "else" bedient die jeweils andere.
      {
        for (int q = 0; q < 4; q++) //Erschafft ein Quadrat aus vier Steinen nebenander (je um 90 Grad zum Vorgaenger gedreht)
        {
          myShape.addParam(new Quader("Mitte", 0.15f, 0.075f, 0.19f),                                  //Groesse je Stein
              new Point((float) (0.09f * Math.cos(q * Math.PI / 2 + Math.PI / 3)),                     //Position
                  (float) (0.09f * Math.sin(q * Math.PI / 2 + Math.PI / 3)), hoch * 0.2f + 0.10f),
              new float[] { q * 90, 0, 0 });															//Drehung
        }
      }
      
      else
      {
        for (int q = 0; q < 4; q++)	//Wie oben fuer die jeweils andere Reihe
        {
          myShape.addParam(new Quader("Mitte", 0.15f, 0.075f, 0.19f),                                   //Groesse je Stein
              new Point((float) (0.09f * -Math.cos(q * Math.PI / 2 + Math.PI / 3)),					    //Position
                  (float) (0.09f * Math.sin(q * Math.PI / 2 + Math.PI / 3)), hoch * 0.2f + 0.10f),
              new float[] { q * 90, 0, 0 });           													//Drehung
        }
      }
    }
    
    // Positioniert das Objekt an der gewuenschten Stelle mit x und y als Mittelpunkt und z = 0; Alle Params werden um diesen Ursprung mit den uebergebenen Winkeln 
    // alpha, beta, gamma gedreht.
    
    myShape.translate(new Point(x, y, pos.z)); // Verantwortlich  fuer die Verschiebung
                                               // der Backsteine an den gewuenschten Uebergabeort    x,y,z.
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung der Backsteine.
                                                        
    
    putz.translate(new Point(x, y, pos.z)); // Verantwortlich fuer die Verschiebung des Putz.
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des Putz.
    
    kuppel.translate(new Point(x, y, pos.z)); // Verantwortlich fuer die Verschiebung der Kuppel oben drauf.
    kuppel.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung der Kuppel.
  }
  /** Positioniert mit linker, oberer Ecke des gewaehlten Feldes als Mittelpunkt den Eckstein auf Hoehe z = 0.
   * 				Das entspricht der Ecke in Richtung negativer x - Achse und positiver y - Achse.
   * @param lev Die Feldindize
   * @param hoehe Anzahl der uebereinanderliegenden Steine. Jeder Stein ist um 0.2f Hoeher als der Unterstein.
   */
  public Eckstein(Level lev, int hoehe)
  {
    this(lev.x1, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  /** Positioniert mit linker, oberer Ecke des gewaehlten Feldes als Mittelpunkt den Eckstein auf Hoehe z = 0. Hoehe des Ecksteins sei zu Uebergeben.
   * 				Das entspricht der Ecke in Richtung negativer x - Achse und positiver y - Achse. Es liegen 11 Steine uebereinander, das entspricht 2.195f Hoehe.
   * @param lev Die Feldindize
   */
  public Eckstein(Level lev)
  {
    this(lev.x1, lev.y2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public Eckstein(float x, float y)
  {
    this(x, y, 0, 0, 0, 11);
  }
  
  public Eckstein(float x, float y, int hoehe)
  {
    this(x, y, 0, 0, 0, hoehe);
  }
  
  @Override
  public void step()
  {
  }
  
  @Override
  public void collision()
  {
  }
  
  @Override
  public void draw()
  {
	Material.COPPER.use();
    putz.draw();
    Material.BACKSTEIN.use();
    myShape.draw();
    Material.BRONZE.use();
    kuppel.draw();
  }
  
  @Override
  public void drawGUI()
  {
  }
  
}
