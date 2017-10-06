
abstract class Objekt
{
  // Variablen
  
  private float x, y, z, alpha, beta, gamma;
  
  // Funktionen
  abstract void step();
  
  abstract void draw();
  
  abstract void drawGUI();
  
  void destroy()
  {
    /// Objekt wird nicht mehr gebraucht und aus dem Programm entfernt.
    // TODO objekt aus array in Labyrinth löschen.
  }
}
