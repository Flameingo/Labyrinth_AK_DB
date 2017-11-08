package models3D;

import params.Quader;
import main.Objekt;
import main.Spawner;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class WandBlock extends Objekt
{
  /** Anzahl der nebeneinanderliegenden Steine minus 1*/
  protected static int wdlaenge = 11;
  /** Anzahl der übereinanderliegenden Steine minus 1*/
  protected static int wdhoehe = 25;
  /** Definiert die Breite jedes Backsteins der Wand */
  protected static float wdbreite = 0.1f;
  
  /**
   * Diese Verschiebung jedes Objekts um die x - Achse sorgt dafuer, dass der Ursprung in der Mitte der Wand liegt.
   */
  protected float qX = - Spawner.wandFeld/2;
  
  /** Die x,y und z - Koordinaten bestimmen den Standort des Objekts 
   * Hierbei beeinflusst die z-Achse die Hoehe.
   * */
 
  
  
  /** biege beschreibt die eventuelle Biegung des Objekts,
   * ein positiver Wert enspricht einer Biegung nach links
   */
  protected float biege;
  /**
   * Diese Objekte werden in entsprechenden Klassen von der Methode myShape.draw(); im Spiel platziert.
   */
  protected Shape myShape = new Shape();
  
 /**
   * Der Konstruktor der Klasse WandBlock dient nur als Oberklasse. 
   * Wird eine der Unterklassen mit 6 Float-Werten aufgerufen, wird eine gerade Wand 
   * erstellt, wird dieser mit 7 Float-Werten aufgerufen, wird das Wandstück um diesen Wert gebogen.
   * 
   * @param x x-Koordinate
   * 
   * @param y y-Koordinate
   * 
   * @param z z-Koordinate, die 3 Koordinaten geben eine untere Ecke der Wand an.
   * 
   * @param w1 Winkel für die Drehung um die z-Achse
   * 
   * @param w2 Winkel für die Drehung um die y-Achse
   * 
   * @param w3 Winkel für die Drehung um die x-Achse
   * 
   * @param biege Biegt die Wand nach links fuer positive Werte in Gradmass, nach rechts fuer negative.
   *              Nur für den Typ PrototypWand verfügbar.
   * 
   */
  
  public WandBlock(float x, float y, float z,float w1, float w2, float w3, float biege)
  {
    
    this.x = x;
    this.y = y;
    this.z = z;
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    this.biege = biege;
    
    myShape.translate(new Point(x, y, z));   //Verantwortlich für die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich für die Drehung des gesamtes Objektes
  }
  /**
   * Der Konstruktor der Klasse WandBlock dient nur als Oberklasse. 
   * Wird eine der Unterklassen mit 6 Float-Werten aufgerufen, wird eine gerade Wand 
   * erstellt, wird dieser mit 7 Float-Werten aufgerufen, wird das Wandstück um diesen Wert gebogen.
   * 
   * @param x x-Koordinate
   * 
   * @param y y-Koordinate
   * 
   * @param z z-Koordinate, die 3 Koordinaten geben eine untere Ecke der Wand an.
   * 
   * @param w1 Winkel für die Drehung um die z-Achse
   * 
   * @param w2 Winkel für die Drehung um die y-Achse
   * 
   * @param w3 Winkel für die Drehung um die x-Achse
   * 
   */
  public WandBlock(float x, float y, float z,float w1, float w2, float w3)
  {
    
    this.x = x;
    this.y = y;
    this.z = z;
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    
    myShape.translate(new Point(x, y, z));   //Verantwortlich für die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich für die Drehung des gesamtes Objektes
   
  }
  
  public void draw()
  {

        myShape.draw();
 
  }
  @Override
  public void step()
  {
   
    
  }
  @Override
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
}
