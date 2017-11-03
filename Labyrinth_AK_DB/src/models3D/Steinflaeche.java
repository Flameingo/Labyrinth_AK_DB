package models3D;

import params.*;
import params.Quader;
import main.Objekt;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class Steinflaeche extends Objekt
{
  protected Shape myShape = new Shape();
  protected float x, y, z;
  
  public Steinflaeche(float x, float y, float z, float alpha, float beta, float gamma)
  {
    this.x = x;
    this.y = y;
    this.z = z;
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
    
    myShape.translate(new Point(x, y, z)); // Verantwortlich fuer die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des gesamtes Objektes
    
    
    float winkel = 0;
    double sz=  Math.PI/12;
    Point p1 = new Point ((float)Math.cos(winkel),(float)Math.sin(winkel),0);
    Point p3 = new Point ((float)Math.cos(winkel+sz),(float)Math.sin(winkel),0);
    Point p2 = new Point ((float)Math.cos(winkel+sz),(float)Math.sin(winkel+sz),0);
    Point p4 = new Point ((float)Math.cos(winkel),(float)Math.sin(winkel+sz),0);
    Point p5 = new Point ((float)Math.cos(winkel),(float)Math.sin(winkel),0.3f);
    Point p7 = new Point ((float)Math.cos(winkel+sz),(float)Math.sin(winkel+sz),0.3f);
    Point p6 = new Point ((float)Math.cos(winkel+sz),(float)Math.sin(winkel+sz),0.3f);
    Point p8 = new Point ((float)Math.cos(winkel),(float)Math.sin(winkel),0.3f);
    
    myShape.addParam(new Unregelm(p1,p2,p3,p4,p5,p6,p7,p8)); //genaue Codierung der Schleife für die Steine muss noch festgelegt werden
    
    
    
    
    
    
    
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
    
  }
  
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
