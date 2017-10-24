package models3D;

import basics.*;
import main.Objekt;
import params.*;

public class Testfigur extends Objekt
{
  
  private Shape myShape = new Shape();
  
  public Testfigur()
  {
    myShape.addParam(new Kegel(1, 1, 2), new Point(0, 0, 0));
//    myShape.addParam(new Zylinder(1, 2, 1.5f));
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
