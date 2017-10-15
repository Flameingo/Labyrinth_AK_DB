package models3D;

import params.Quader;
import main.Objekt;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class WandBlock extends Objekt
{
  /** Anzahl der nebeneinanderliegenden Steine minus 1*/
  protected int wdlaenge = 11;
  /** Anzahl der übereinanderliegenden Steine minus 1*/
  protected int wdhoehe = 25;
  /** Definiert die Breite jedes Backsteins der Wand */
  protected float wdbreite = 0.1f;
  
  /** Die x,y und z - Koordinaten bestimmen den Standort des Objekts */
  protected float x,y,z;
  /** w1 beschreibt die Drehung um die z-Achse */
  protected float w1;
  /** w2 beschreibt die Drehung um die y-Achse */
  protected float w2;
  /** w3 beschreibt die Drehung um die x-Achse */
  protected float w3;
  /** biege beschreibt die eventuelle Biegung des Objekts,
   * ein positiver Wert enspricht einer Biegung nach links
   */
  protected float biege;
  
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
   * @param z z-Koordinate
   * 
   * @param w1 Winkel für die Drehung um die z-Achse
   * 
   * @param w2 Winkel für die Drehung um die y-Achse
   * 
   * @param w3 Winkel für die Drehung um die x-Achse
   * */
  public WandBlock(float x, float y, float z,float w1, float w2, float w3)
  {
    
    this.x = x;
    this.y = y;
    this.z = z;
    this.w1 = w1;
    this.w2 = w2;
    this.w3 = w3;
   
  }
  public WandBlock(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
  this.x = x;
  this.y = y;
  this.z = z;
  this.w1 = w1;
  this.w2 = w2;
  this.w3 = w3;
  this.biege = biege;
    
  }
  
  public WandBlock(float biege)
  {
    for (int k = 0; k<wdhoehe; k++)
    {
      
      
      if (k % 2 == 0)
      {
       
          for (int i = 0; i<wdlaenge; i++)
          {
         
            myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.27f-biege*biege*0.3f*i*i,(i*biege)*(i*biege),k*0.06f), new float[] {i*i*biege*biege*45,0,0});
            
         }
      }
         else
         {
           myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f,0,k*0.06f));
           myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((wdlaenge-1)*0.27f+0.065f-biege*biege*32,biege*biege*105,k*0.06f), new float[] {45*100*biege*biege,0,0});
           
           for (int i = 0; i<wdlaenge-1;i++)
           {           
             
             myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (i*0.27f+0.13f-biege*biege*0.3f*i*i,(i*biege)*(i*biege)*1.1f,k*0.06f), new float[]{i*i*biege*biege*45,0,0});
           }
      
         }
      }
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
