package main;

import basics.*;

public abstract class Objekt
{
  // Variablen
  
  protected float alpha, beta, gamma; // x,y,z for position, angles for
                                      // rotation
  protected Point pos;
  
  // Funktionen
  public abstract void step(); // handles movement, behaviour and interaction
  
  public abstract void collision(); // check with other objects for collision
  
  public abstract void draw(); // outputs to the screen in the 3D space
  
  public abstract void drawGUI(); // outputs to the (G)raphic (U)ser (I)nterface
                                  // in 2D
  
  void destroy()
  {
    /// Objekt wird nicht mehr gebraucht und aus dem Programm entfernt.
    Labyrinth.deleteObject(this);
  }
}
