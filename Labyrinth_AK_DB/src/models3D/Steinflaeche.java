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
    
    
  
//    Point [] P = new Point[0] ;
//    P[0]= new Point(0,0,0);
//    P[1]= new Point(1,1,0);
//    P[2]= new Point (2,3,1);
//    P[3]= new Point (1,2,3);
//    myShape.addParam(new Prisma(null, 3f)); //genaue Codierung der Schleife für die Steine muss noch festgelegt werden
    
    
    
    
    
    
    
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
