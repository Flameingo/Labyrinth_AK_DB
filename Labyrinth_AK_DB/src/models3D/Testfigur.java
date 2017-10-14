package models3D;

import basics.*;
import main.Objekt;
import params.*;

public class Testfigur extends Objekt
{
  
  private Shape myShape = new Shape();
  
  public Testfigur()
  {
    myShape.addParam(new Kugel(1), new Point(0, 0, 3));
    myShape.addParam(new Quader("Mitte", 5, 2, 2));
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
