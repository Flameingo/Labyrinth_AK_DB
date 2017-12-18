package path;

import basics.Level;
import basics.Text;
import main.Kompass;
import main.Objekt;
import models3D.Schalter;

public class SchalterFeld extends Objekt
{
  
  float                    x;
  float                    y;
  protected Schalter[] schaldr = new Schalter[1];
  
  /** Erstellt ein Objekt des Klasse "Schalter" aus "models3D" in einem aufgespannten Quadrat. Dieser Konstruktor ist speziell dafuer da, um vom darunterstehenden Konstruktor aufgerufen
   * werden zu koennen
   * @param befehl Eine eindeutige Zahlen-/Buchstabenfolge, die innerhalb der Methoden "plusschalten"/"minusschalten" in "Funktionen" einer Aktion zu geordent werden kann,
   * die ausgefuehrt wird, wenn der Spieler ingame mit dem Schalter, der von diesem Konstruktor erzeugt wird interagiert. 
   * @param x 
   * @param y x und y definieren den Punkt in Richtung der negativen Achsen.
   * @param x2 
   * @param y2 x2 und y2 definieren den Punkt in Richtung der positiven Achsen. 
   */
  public SchalterFeld(String befehl, float x, float y, float x2, float y2)
  {
	
    this.x = (x2 + x)/2;
    this.y = (y2+y)/2;
    schaldr[0] = new Schalter(befehl,(x2 + x) / 2, (y2 + y) / 2, 0, 0, 0, 0);
  }
  /** Ruft den oberen Konstruktor auf und kann den Schalter in der Mitte eines gewuenschten Feldes der Rasterung platzieren.
   * 
   * @param befehl Eine eindeutige Zahlen-/Buchstabenfolge, die innerhalb der Methoden "plusschalten"/"minusschalten" in "Funktionen" einer Aktion zu geordent werden kann,
   * die ausgefuehrt wird, wenn der Spieler ingame mit dem Schalter, der von diesem Konstruktor erzeugt wird interagiert.
   * @param lev Das gewuenschte Feld
   */
  public SchalterFeld(String befehl, Level lev)
  {
    this(befehl,lev.x1,lev.y1, lev.x2, lev.y2);
    this.a = lev.x2;
	this.b = lev.y1;
  }
  

  
  public void step()
  {
    for (Objekt sch : schaldr)
    {
      sch.step();
    }
    if(this.getA() == Kompass.getLvlX() && this.getB() == Kompass.getLvlY())
    	Text.tipp1 = true;
  
    if(this.getA() != Kompass.getLvlX() || this.getB() != Kompass.getLvlY())
    	Text.tipp1 = false;
  }
  
  @Override
  public void collision()
  {
    for (Objekt sch : schaldr)
    {
      sch.collision();
    }
  }
  
  @Override
  public void draw()
  {
    for (Objekt sch : schaldr)
    {
      sch.draw();
    }
  }
  
  @Override
  public void drawGUI()
  {
    for (Objekt sch : schaldr)
    {
      sch.drawGUI();
    }
  }
  
}
