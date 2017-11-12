package models3D;

import static org.lwjgl.opengl.GL11.*;
import basics.Point;
import main.Objekt;
import main.Spawner;
import params.Quader;
import params.Shape;

public class Tuer extends Objekt
{
  protected float   x, y, z;
  float             winkel;
  protected boolean oeffner;
  protected Shape   myShape = new Shape();
  
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
  public Tuer(float x, float y, float z, float w1, float w2, float w3, boolean offen)
  {
    this.x = x;
    this.y = y;
    this.z = z;
    
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    
    this.oeffner = offen;
    
    float qX = - wandFeld/2;
    myShape.addParam(new Quader("Ecke", 0.65f, 0.05f, 1.30f), new Point(0, -0.05f, -0.02f));
   
    myShape.translate(new Point(1.3f + qX + this.x, this.y, this.z));
  }
  
  public void step()
  {
    
    if (oeffner == true && winkel < 100)
    {
      winkel = winkel + 3f;
    } else if (oeffner == false && winkel > 0)
    {
      winkel = winkel - 3f;
    }
    if (winkel >= 100)
    {
      oeffner = false;
    }
    if (winkel <= 0)
    {
      oeffner = true;
    }
    
    myShape.rotate(new float[] { winkel + alpha, beta, gamma });
  }
  
  public void collision()
  {
    
  }
  
  public void draw()
  {
    
    myShape.draw();
  }
  
  public void drawGUI()
  {
    
  }
  
}
