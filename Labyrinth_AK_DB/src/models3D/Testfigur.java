package models3D;

import basics.*;
import main.Objekt;
import params.*;

public class Testfigur extends Objekt
{
  
  private Shape myShape = new Shape();
  
  public Testfigur()
  {
    myShape.addParam(new Kegel(1, 1, 2), new Point(0, 0, 2.5f));
    myShape.addParam(new Zylinder(1, 2, 1.5f));
    myShape.addParam(new Kugel(.5f), new Point(3, 0, 0));
    myShape.addParam(new Quader("Mitte", 1, 2, 3), new Point(0, 3, 0));
    myShape.addParam(new Dreieck(new Point(-1, -1, -1), new Point(1, -1, -1), new Point(1, 1, -1)));
    // myShape.addParam(new ZylinderAbschnitt(2,2,1,240));
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
    Material.RUBY.use();
    myShape.draw();
    
  }
  
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
