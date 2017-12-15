package main;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import basics.*;
import params.Param;

public abstract class Objekt // Oberklasse saemtlicher Klassen aus "models3D", "params", "path" und "section", sowie
                             // Spawner, Funktionen und Player.
{ // Hier sind die abstrakten Koerper der Methoden "draw","step","collision" und "drawGui" untergebracht.
  
  // Die in allen Models3D enthaltenen Variablen x,y,z (Die Koordinaten zur Platzierung des Objektes) und alpha, beta,
  // gamma
  // (Drehung des Objektes: alpha : z - Achse, beta : y - Achse, gamma : x - Achse) sind hier definiert.
  // Die Rotation oder Verschiebung eines Objektes, die innerhalb dessen Klasse aufgerufen wird, wird hier ausgefuehrt.
  
  // getA() und getB() finden Relevanz fuer das path-Package, damit kann jedem Objekt das Feld zugeordnet werden, auf
  // dem es sich
  // befindet.
  
  // Variablen
  
  /**
   * Statusmaschine: Die Minimale Aufloesung eines Params kann hiermit erhoeht werden. Muss vor dem Aufruf des
   * Konstruktors gesetzt werden.
   */
  private static float zusatzAufloesung = 1;
  
  /** this enables us to push and pop the Variable zusatzAufloesung */
  private float        pushedZA;
  
  // Variablen
  /**
   * Auf "true" geschaltet verhindert dieser boolean in Relation zu einer DisplayList, das Objekte dieser DisplayList
   * gerade sichtbar sind.
   */
  public boolean       hidden           = false;
  
  // pos for position, angles for rotation
  /**
   * 1/2 * wandFeld entspricht der Laenge einer Backsteinwand, die OHNE einen floatwert "laenge" uebergeben wird.
   */
  
  public final float   wandFeld         = 5.70f;
  /**
   * Fuer jedes WandBlock-Objekt uebernommener Wert der dessen z-Koordinate anaddiert wird. Folge dessen ist das Objekt
   * auf dem "Boden" stehend und schneidet diesen nicht.
   */
  public final float   boden            = 0.016f;
  
  /**
   * alpha ist z - Achse (senkrechte Achse) beta ist y - Achse gamma ist x - Achse
   */
  protected float      alpha            = 0, beta = 0, gamma = 0;
  
  /**
   * Hilfsvariablen zur Ermittlung aller auf einem bestimmten Feld liegenden Objekten.
   */
  protected float      a, b;
  
  public Point         pos              = new Point(0, 0, 0);
  
  // Funktionen
  
  /**
   * @return Liefert den A-Wert der Feldkoordinate eines Lab-Objektes.
   */
  public int getA()
  {
    return (int) (this.a / 1.5f);
  }
  
  /**
   * @return Liefert den B-Wert der Feldkoordinate eines Lab-Objektes.
   */
  public int getB()
  {
    return (int) (this.b / -1.5f);
  }
  
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
  
  /**
   * returns the Variable zusatzAufloesung to its previous state
   * 
   * @return the zusatzAufloesung
   */
  public void popZusatzAufloesung()
  {
    Objekt.zusatzAufloesung = pushedZA;
  }
  
  /**
   * pushes the Variable zusatzAufloesung
   * 
   * @param zusatzAufloesung
   *          the zusatzAufloesung to set
   */
  public void pushZusatzAufloesung(float zusatzAufloesung)
  {
    pushedZA = Objekt.zusatzAufloesung;
    Objekt.zusatzAufloesung = zusatzAufloesung;
  }
  
  public static float getZusatzAufloesung()
  {
    return zusatzAufloesung;
  }
}
