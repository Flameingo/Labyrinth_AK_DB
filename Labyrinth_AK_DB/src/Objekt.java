import static org.lwjgl.opengl.GL11.*;


abstract class Objekt
{
  // Variablen
  
  protected float x, y, z, alpha, beta, gamma;
  
  // Funktionen
  abstract void step();
  
  abstract void draw();
  
  abstract void drawGUI();
  
  void destroy()
  {
    /// Objekt wird nicht mehr gebraucht und aus dem Programm entfernt.
    // TODO objekt aus array in Labyrinth l�schen.
  }
}
