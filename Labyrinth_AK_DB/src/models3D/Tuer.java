package models3D;

import static org.lwjgl.opengl.GL11.*;
import basics.Point;
import main.Funktionen;
import main.Objekt;
import main.Spawner;
import params.Material;
import params.Quader;
import params.Shape;

public class Tuer extends Funktionen
{
  protected float   x, y, z;
  private float             winkel = 0f;
  protected boolean schalt;
  protected boolean offen;
  protected Shape   myShape = new Shape();
  protected boolean stop;
  protected String name;
  /**
   * Tuer ist an die Klasse TuerWand angepasst, übergeben werden die gleiche x,y
   * und z-Koordinate wie für das entsprechende Objekt der Klasse TuerWand, für
   * die Winkel gilt dasselbe.
   * 
   * @param Hier
   *          wird -1 bzw 1 für das direkte Öffnen in die eine, bzw andere
   *          richtung übergeben. Die dritte Moeglichkeit 0 bewirkt dass die
   *          Tuer vorerst geschlossen bleibt.
   */
  public Tuer(String name, float x, float y, float z, float w1, float w2, float w3)
  {
    this.x = x;
    this.y = y;
    this.z = z;
    this.name = name;
    
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    
    this.offen = false; 
    this.schalt = false;
    this.stop = false;
    
    myShape.addParam(new Quader("Ecke", 0.73f, 0.05f, 1.82f), new Point(0, -0.05f, -0.02f));
    myShape.rotate(new float[] {alpha, beta, gamma });
    myShape.translate(new Point(this.x, this.y, this.z));
  }
  public boolean getStatus()
  {
	  return this.offen;
  }
//  public void aufschliessen(String name)
//  {
//	  if(!this.offen)
//	  {
//		  this.stop = false;
//		  this.offen = true;
//	  }
//  }
//  public void zuschliessen(String name)
//  {
//	  if(this.offen)
//	  {
//		  this.stop = false;
//		  this.offen = false;
//	  }
//  }
//  public void benutzen(String name)                                                 // Wie benutzt man denn so eine Tuer ?
//  {
//	  this.stop = false;
//	  
//	  if(this.offen)
//		  this.offen = false;
//	  if(!this.offen)
//		  this.offen = true;
//  }
  
  
  public void step()
  {
	if(offen == schalt)
	  this.offen = Funktionen.ueberpruefung(this.name);
//	  float unwichtig = 0;
//	  if (stop != true)
//	    {
//	      unwichtig = winkel;
//	    
//	    }
	  	myShape.rotate(new float[] { winkel + alpha, beta, gamma });
	if(offen != schalt)  	                                                                  // Eine Bewegung der Tuer wird durch eine 
	{	 																  // der obenstehenden Funktionen ausgeloest.
	    if (!schalt)												  //Dabei wird lediglich "stop" auf false gestellt.
	    {																  //Dann oeffnet, bzw schliesst sich die Tuer.
	      winkel = winkel - 1.5f;						  
	      if (winkel <= -90)											  //Nach Beendigung dieses Vorgangs wird dann 
	      {																  //durch den Boolean "schalt" die Richtung
	        												  //fuer die naechste Aktion der Tuer
	        schalt = true;												  //geaendert.
	      }
	    }
	    if (schalt)
	    {
	      winkel = winkel + 1.5f;
	      if (winkel >= 0)
	      {
	        
	        schalt = false;
	      }
	    }
	 }
  }
  
  public void collision()
  {
    
  }
  
  public void draw()
  {
    Material.CHROME.use();
    myShape.draw();
  }
  
  public void drawGUI()
  {
    
  }
  
}
