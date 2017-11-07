package main;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import basics.*;

public abstract class Objekt
{
  // Variablen
  // pos for position, angles for rotation
  protected float alpha = 0, beta = 0, gamma = 0;
  
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
