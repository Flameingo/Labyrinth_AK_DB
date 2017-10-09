package main;

abstract class Objekt
{
  // Variablen
  
  protected float x, y, z, alpha, beta, gamma;  // x,y,z for position, angles for rotation
  
  // Funktionen
  abstract void step(); // handles movement, behaviour and interaction
  
  abstract void collision();  // check with other objects for collision
  
  abstract void draw(); // outputs to the screen in the 3D space
  
  abstract void drawGUI();  // outputs to the (G)raphic (U)ser (I)nterface in 2D
  
  void destroy()
  {
    /// Objekt wird nicht mehr gebraucht und aus dem Programm entfernt.
    // TODO objekt aus array in Labyrinth l�schen.
  }
}
