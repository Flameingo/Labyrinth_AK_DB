package models3D;

import params.Quader;
import main.Objekt;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class WandBlock extends Objekt
{
  /** Anzahl der nebeneinanderliegenden Steine minus 1*/
  protected static int wdlaenge = 11;
  /** Anzahl der �bereinanderliegenden Steine minus 1*/
  protected static int wdhoehe = 25;
  /** Definiert die Breite jedes Backsteins der Wand */
  protected static float wdbreite = 0.1f;
  
  /** Die x,y und z - Koordinaten bestimmen den Standort des Objekts */
  protected float x,y,z;
  
  
  /** biege beschreibt die eventuelle Biegung des Objekts,
   * ein positiver Wert enspricht einer Biegung nach links
   */
  protected float biege;
  
  protected Shape myShape = new Shape();
  
 /**
   * Der Konstruktor der Klasse WandBlock dient nur als Oberklasse. 
   * Wird eine der Unterklassen mit 6 Float-Werten aufgerufen, wird eine gerade Wand 
   * erstellt, wird dieser mit 7 Float-Werten aufgerufen, wird das Wandst�ck um diesen Wert gebogen.
   * 
   * @param x x-Koordinate
   * 
   * @param y y-Koordinate
   * 
   * @param z z-Koordinate, die 3 Koordinaten geben eine untere Ecke der Wand an.
   * 
   * @param w1 Winkel f�r die Drehung um die z-Achse
   * 
   * @param w2 Winkel f�r die Drehung um die y-Achse
   * 
   * @param w3 Winkel f�r die Drehung um die x-Achse
   * 
   * @param biege Biegt die Wand nach links fuer positive Werte in Gradmass, nach rechts fuer negative.
   *              Nur f�r den Typ PrototypWand verf�gbar.
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
  }
  /**
   * Der Konstruktor der Klasse WandBlock dient nur als Oberklasse. 
   * Wird eine der Unterklassen mit 6 Float-Werten aufgerufen, wird eine gerade Wand 
   * erstellt, wird dieser mit 7 Float-Werten aufgerufen, wird das Wandst�ck um diesen Wert gebogen.
   * 
   * @param x x-Koordinate
   * 
   * @param y y-Koordinate
   * 
   * @param z z-Koordinate, die 3 Koordinaten geben eine untere Ecke der Wand an.
   * 
   * @param w1 Winkel f�r die Drehung um die z-Achse
   * 
   * @param w2 Winkel f�r die Drehung um die y-Achse
   * 
   * @param w3 Winkel f�r die Drehung um die x-Achse
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
   
  }
  
  public void draw()
  {
    myShape.draw();
  }
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
    
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
