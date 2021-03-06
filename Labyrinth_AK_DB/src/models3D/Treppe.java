package models3D;

import basics.Point;
import main.Objekt;
import params.Material;
import params.Quader;
import params.Shape;

public class Treppe extends Objekt
{
  protected static float stufenlaenge = 0.5f;
  protected static float stufenhoehe  = 0.5f;
  protected static float stufenbreite = 2;
  protected static float stufenhoehe2 = 0.1f;
  protected float        stflaenge, stfbreite, stfhoehe;
  
  protected float        bogen;
  protected float        treppenlaenge;
  
  protected Shape        myShape      = new Shape();
  
  /**
   * 
   * @param x
   * @param y
   * @param z
   * @param w1
   * @param w2
   * @param w3
   */
  public Treppe(float x, float y, float z, float w1, float w2, float w3)
  {
    pos.x = x;
    pos.y = y;
    pos.z = z;
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    
    myShape.translate(new Point(x, y, z)); // Verantwortlich f�r die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich f�r die Drehung des gesamtes Objektes
    
  }
  
  /**
   * 
   * @param x
   * @param y
   * @param z
   * @param w1
   * @param w2
   * @param w3
   * @param stflaenge
   * @param stfbreite
   * @param stfhoehe
   */
  public Treppe(float x, float y, float z, float w1, float w2, float w3, float stflaenge, float stfbreite,
      float stfhoehe)
  {
    pos.x = x;
    pos.y = y;
    pos.z = z;
    
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    
    myShape.translate(new Point(x, y, z)); // Verantwortlich f�r die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich f�r die Drehung des gesamtes Objektes
    
    for (int q = 0; q < 10; q++)
    {
      myShape.addParam(new Quader("Mitte", this.stflaenge * 2, this.stfbreite, this.stfhoehe),
          new Point(pos.x + this.stflaenge * q, pos.z, pos.y + this.stfhoehe * q));
      
    }
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
  public void draw()
  {
    Material.BACKSTEIN.use();
    myShape.draw();
  }
  
  @Override
  public void drawGUI()
  {
  }
  
}
