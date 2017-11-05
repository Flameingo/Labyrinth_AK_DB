package models3D;

import basics.Point;
import main.Objekt;
import params.Quader;
import params.Shape;
import params.ZylinderAbschnitt;

public class Buch extends Objekt
{
  protected Shape myShape = new Shape();
  protected static float breiteBuch = 0.05f;
  protected static float laengeBuch = 0.1f;
  protected static float hoeheBuch = 0.15f;
  
  public Buch(float x, float y, float z, float alpha, float beta, float gamma)
  {
    myShape.addParam(new Quader("Mitte",laengeBuch, breiteBuch, hoeheBuch), new Point(0,0,0) );
    myShape.addParam(new ZylinderAbschnitt(breiteBuch/2,breiteBuch/2, hoeheBuch, 180), new Point(0,0,-hoeheBuch/2),new float[]{90,0,0});
    
    
    
    
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
    // TODO Auto-generated method stub
    myShape.draw();
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
