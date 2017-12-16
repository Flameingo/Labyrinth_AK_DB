package models3D;

import basics.Point;
import basics.Text;
import main.Funktionen;
import main.Labyrinth;

import params.Kugel;
import params.Material;
import params.Quader;
import params.Shape;
import params.Zylinder;

import static org.lwjgl.glfw.GLFW.*;

import javax.sound.sampled.*;
import java.io.*;

public class Schalter extends Funktionen // Schalter koennen ingame mit "G" bedient werden, sollte sich der Spieler in deren unmittelbarer Naehe befinden.
{										 // Der String "befehl", in der Oberklasse definiert, speichert eine eindeutige Zahlen/Buchstabenkombination ein, in der
	                                     // innerhalb von "Funktionen" mit "plusschalten" und "minusschalten" Aktionen zugeordnet werden koennen, die bei Interaktion ausgefuehrt werden.
  
  boolean         schalt;
  protected Shape block  = new Shape();	//block. - Aufrufe beziehen sich auf alle Params, die zum Schalter gehoeren ausser dem Hebel.
  protected Shape hebel  = new Shape(); //Bezieht sich auf den Hebel, der als einziges Objekt der Klasse beweglich ist.
  boolean         stop; 				//Immer wenn "stop" auf false gestellt wird, folgt eine Bewegung des Schalters. Ist diese getan aendert sich der "status" und stop wird auf false geaendert.
  public boolean  status; 				//Bestimmt die Richtung der Bewegung, sollte "stop" auf false gestellt werden. Nach Beendung einer Hebelbewegung wird status umgestellt und die Richtung
                                        //fuer die naechse Bewegung geaendert.
  

  private float   winkel = 0f; 			//Bewegt den Hebel mit einem Rotationsbefehl zwischen 0 und - 70 Grad. Dies geschieht durch die Aenderung dieses Wertes durch die Bewegungsfunktionen in "step".
  /**
   * 
   * @param befehl Eine eindeutige Zahlen-/Buchstabenfolge, die innerhalb der Methoden "plusschalten"/"minusschalten" in "Funktionen" einer Aktion zu geordent werden kann,
   * die ausgefuehrt wird, wenn der Spieler ingame mit dem Schalter, der von diesem Konstruktor erzeugt wird interagiert. 
   * @param x Mittelpunkt
   * @param y Mittelpunkt
   * @param z Unterseite, steht fuer z = 0 also auf dem Boden.
   * @param alpha Drehung z - Achse.
   * @param beta Drehung y - Achse.
   * @param gamma x - Achse
   */
  public Schalter(String befehl,float x, float y, float z, float alpha, float beta, float gamma)
  {
    this.befehl = befehl;
    pos.x = x;
    pos.y = y;
    pos.z = z;
    stop = true;
    schalt = false;
    status = false;
    float slHoehe = 0.1f;
    
    pushZusatzAufloesung(5);
    	block.addParam(new Quader("Mitte", 0.2f, 0.2f, slHoehe), new Point(0, 0, slHoehe / 2)); // Der
                                                                                            	// Block
    																							// auf
    																							// dem
                                                                                            	// der
                                                                                            	// Schalter
                                                                                            	// angebracht
                                                                                            	// ist.
    	hebel.addParam(new Zylinder(0.03f, 0.03f, 0.4f), new Point(0, 0, slHoehe), new float[] { 0, 35, 0 });   //Der Hebel in Ausgangsposition.
    	block.addParam(new Kugel(0.1f), new Point(0, 0, slHoehe - 0.05f)); 										//Kugel an der Schnittstelle zwischen Block und Hebbel
    
    popZusatzAufloesung();
    
    block.translate(new Point(x, y, z)); //Verschiebt den statischen Teil des Objektes an den gewuenschten Koordinatenpunkt x,y,z
    hebel.translate(new Point(x, y, z)); //Selbiges fuer den Hebel.
    
  }
  /** Ueberpruft ob der Schalter umgelegt wird oder zurueck in Ursprungslage versetzt wird (bei Interaktion mit dem Schalter wechselt sich dies ab).
   * 
   */
  public void schalten()
  {
    if (stop == true)
    {
      stop = false;
      if (status == false)
      {
        status = true;
        Funktionen.plusschalten(this.befehl);
        return;
      }
      status = false;
      Funktionen.minusschalten(this.befehl);
      
    }
  }
  
  public void setSchalter(boolean modus) // nochmal ueberarbeiten
  {
    if (schalt == false && schalt != modus)
    {
      
      stop = false;
      return;
    }
    
    if (schalt != modus)
    {
      
      stop = false;
    }
    
  }
  
  @Override
  public void step()
  {
    
    for (int key : Labyrinth.keys)
    {
      Point p; 
      switch (key)
      {
      case GLFW_KEY_G:
        
    	p = Point.add(Labyrinth.player.pos, -pos.x, -pos.y, -pos.z);
        if (p.length("xy") < 1) schalten();      //Betaetigt der Spieler die Taste "G", fragt jeder Schalter ab, ob er selbst sich in direkter Naehe
      }											 // des Spielers befindet. Ist dies der Fall fuehrt entsprechender Schalter "Schalter.schalten()" aus.
      
    }
    
    if (stop != true)
    {
      hebel.rotate(new float[] { 0, winkel, 0 });
      hebel.translate(new Point(winkel * -0.1f / 70 + pos.x, pos.y, pos.z));
    }
    if (schalt == true)
    {
      if (stop != true) winkel = winkel - 1.5f;
      if (winkel <= -70)
      {
        stop = true;
        schalt = false;
      }
    }
    if (schalt == false)
    {
      if (stop != true) winkel = winkel + 1.5f;
      if (winkel >= 0)
      {
        stop = true;
        schalt = true;
      }
    }
    
  }
  
  @Override
  public void collision()
  {
  }
  
  @Override
  public void draw()
  {
    Material.SILVER.use();
    block.draw();
    Material.BLACK_RUBBER.use();
    hebel.draw();
    
  }
  
  @Override
  public void drawGUI()
  {
  }
  
}
