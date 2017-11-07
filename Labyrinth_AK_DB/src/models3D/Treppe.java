package models3D;

import basics.Point;
import main.Objekt;
import params.Quader;
import params.Shape;

public class Treppe extends Objekt
{
  protected static float stufenlaenge = 0.5f;
  protected static float stufenhoehe = 0.5f;
  protected static float stufenbreite = 2;
  protected static float stufenhoehe2 = 0.1f;
  protected float stflaenge, stfbreite, stfhoehe;
  
  protected float bogen;
  protected float treppenlaenge;
  
  protected Shape myShape = new Shape();
  
  public Treppe(float x, float y, float z, float w1, float w2, float w3)
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
  
  
  
  public Treppe(float x, float y, float z, float w1, float w2, float w3, float stflaenge, float stfbreite, float stfhoehe)
  {
    this.x = x;
    this.y = y;
    this.z = z;
    
    this.alpha = w1;
    this.beta = w2;
    this.gamma = w3;
    
    myShape.translate(new Point(x, y, z));   //Verantwortlich für die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich für die Drehung des gesamtes Objektes
    
    for (int q = 0; q < 10; q++)
    {
      myShape.addParam(new Quader ("Mitte",this.stflaenge*2,this.stfbreite,this.stfhoehe),new Point(this.x+this.stflaenge*q, this.z, this.y+this.stfhoehe*q));
    
    }
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
  public void draw()
  {
    myShape.draw();
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
