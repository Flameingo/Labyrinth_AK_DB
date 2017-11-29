package main;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import basics.*;

public abstract class Objekt
{
  // Variablen
  // pos for position, angles for rotation
  /**
   * 1/2 * wandFeld entspricht der Laenge einer Backsteinwand.
   */
  public final float wandFeld = 5.70f;
  public final float boden = 0.016f;
  /**
   * alpha ist z - Achse (senkrechte Achse)
   * beta ist y - Achse
   * gamma ist x - Achse
   */
  protected float alpha = 0, beta = 0, gamma = 0;
  
  /**
   * x und y bilden die waagrechte Ebene. z bestimmt die Hoehe.
   */
  protected float x,y,z;
  
  protected Point pos   = new Point(0, 0, 0);
  
  // Funktionen
  public abstract void step(); // handles movement, behaviour and interaction
  
  public abstract void collision(); // check with other objects for collision
  
  public void translate_rotate()
  {
    glTranslatef(pos.x, pos.y, pos.z);
    glRotatef(gamma, 1, 0, 0);
    glRotatef(beta, 0, 1, 0);
    glRotatef(alpha, 0, 0, 1);
  }
  
  public abstract void draw(); // outputs to the screen in the 3D space
  
  public abstract void drawGUI(); // outputs to the (G)raphic (U)ser (I)nterface
                                  // in 2D
  
  public void destroy()
  {
    /// Objekt wird nicht mehr gebraucht und aus dem Programm entfernt.
    Labyrinth.deleteObject(this);
  }
  
}
