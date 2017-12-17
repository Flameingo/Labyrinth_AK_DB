package models3D;

import params.Material;
import params.Quader;
import main.Objekt;
import main.Spawner;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class WandBlock extends Objekt // Oberklasse aller Wand - Klassen.
{
  // Uebergebene Werte werden abgespeichert.
  // Hier wird die Verschiebung und Drehung aller WandObjekte ("myShape" und "putz") umgesetzt.
  // Davon abgesehen ist die Stein-Breite fuer alle Wand-Typen hier festgesetzt.
  //
  
  // ______________________________________________________________________________________________________________
  // Dieser Abschnitt betrifft nur Unterklassen-Objekte ohne uebergebene Werte fuer Laenge und Hoehe:
  
  /**
   * Anzahl der nebeneinanderliegenden Steine minus 1* aktuell 11 *
   */
  protected static int wdlaenge = 11;
  /**
   * Anzahl der �bereinanderliegenden Steine minus 1 aktuell 25
   */
  protected static int wdhoehe  = 25;
  
  /**
   * Diese Verschiebung jedes Objekts um die x - Achse sorgt dafuer, dass der Ursprung in der Mitte der Wand liegt.
   */
  protected float      qX       = -wandFeld / 2;
  
  /**
   * Die x,y und z - Koordinaten bestimmen den Standort des Objekts Hierbei beeinflusst die z-Achse die Hoehe.
   */
  
  // ___________________________________________________________________________________________________________________
  
  /**
   * Definiert die Breite jedes Backsteins der Wand aktuell 0.1f
   */
  public static float  wdbreite = 0.1f;
  
  /**
   * biege beschreibt die eventuelle Biegung des Objekts, ein positiver Wert enspricht einer Biegung nach links
   */
  protected float      biege;
  /**
   * In diesem Fall sind dies die Backsteine. Diese werden mit "myShape.draw()" gezeichnet.
   */
  protected Shape      myShape  = new Shape();
  /**
   * Der orangene Putz zwischen den Steinen wird hier definiert.
   */
  protected Shape      putz     = new Shape();
  /**
   * Betrifft Randsteine, diese werden nicht mit myShape gezeichnet, da sie einen bestimmten Farbton haben sollen.
   */
  protected Shape      stein    = new Shape();
  
  /**
   * Der Konstruktor der Klasse WandBlock dient nur als Oberklasse. Wird eine der Unterklassen mit 6 Float-Werten
   * aufgerufen, wird eine gerade Wand erstellt, wird dieser mit 7 Float-Werten aufgerufen, wird das Wandst�ck um diesen
   * Wert gebogen.
   * 
   * @param x
   *          x-Koordinate
   * 
   * @param y
   *          y-Koordinate
   * 
   * @param z
   *          z-Koordinate, die 3 Koordinaten geben eine untere Ecke der Wand an.
   * 
   * @param w1
   *          Winkel f�r die Drehung um die z-Achse
   * 
   * @param w2
   *          Winkel f�r die Drehung um die y-Achse
   * 
   * @param w3
   *          Winkel f�r die Drehung um die x-Achse
   * 
   * @param biege
   *          Biegt die Wand nach links fuer positive Werte in Gradmass, nach rechts fuer negative. Nur f�r den Typ
   *          PrototypWand verf�gbar.
   * 
   */
  
  public WandBlock(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
    
    pos.x = x;
    pos.y = y;
    pos.z = z;
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    this.biege = biege;
    
    myShape.translate(new Point(x, y, z)); // Verantwortlich f�r die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich f�r die Drehung des gesamtes Objektes
    putz.translate(pos); // Verantwortlich fuer die Verschiebung des Putzes (Verputz zwischen den Steinen
    																						// (Quader)).
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des Putzes

    stein.translate(pos); // Verantwortlich fuer die Verschiebung der (farblich einheitlichen)
    																					// Randsteine.
    stein.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung der Randsteine.
  }
  
  /**
   * Der Konstruktor der Klasse WandBlock dient nur als Oberklasse. Wird eine der Unterklassen mit 6 Float-Werten
   * aufgerufen, wird eine gerade Wand erstellt, wird dieser mit 7 Float-Werten aufgerufen, wird das Wandst�ck um diesen
   * Wert gebogen.
   * 
   * @param x
   *          x-Koordinate
   * 
   * @param y
   *          y-Koordinate
   * 
   * @param z
   *          z-Koordinate, die 3 Koordinaten geben eine untere Ecke der Wand an.
   * 
   * @param w1
   *          Winkel f�r die Drehung um die z-Achse
   * 
   * @param w2
   *          Winkel f�r die Drehung um die y-Achse
   * 
   * @param w3
   *          Winkel f�r die Drehung um die x-Achse
   * 
   */
  public WandBlock(float x, float y, float z, float w1, float w2, float w3)
  {
    
    pos.x = x;
    pos.y = y;
    pos.z = z;
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    
    myShape.translate(pos); // Verantwortlich fuer die Verschiebung der Backsteinmehrheit (Die mit
                            // zufaelliger Farbe).
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung der Backsteinmehrheit.
    
    putz.translate(pos); // Verantwortlich fuer die Verschiebung des Putzes (Verputz zwischen den Steinen
                         // (Quader)).
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des Putzes
    
    stein.translate(pos); // Verantwortlich fuer die Verschiebung der (farblich einheitlichen)
                          // Randsteine.
    stein.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung der Randsteine.
  }
  
  public void draw()
  {
    myShape.backsteindraw();
    Material.BACKSTEIN.use();
    stein.draw();
    Material.COPPER.use();
    putz.draw();
  }
  
  @Override
  public void step()
  {
  }
  
  @Override
  public void collision()
  {
  }
  
  @Override
  public void drawGUI()
  {
  }
}
