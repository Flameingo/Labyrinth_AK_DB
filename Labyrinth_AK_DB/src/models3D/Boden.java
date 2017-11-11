package models3D;

import basics.Point;
import main.Objekt;
import params.Material;
import params.Shape;
import params.Viereck;

public class Boden extends Objekt
{
  protected Shape myShape = new Shape();
  
  public Boden()
  {
    Point p1 = new Point(-20,-20,0);
    Point p2 = new Point(20,-20,0);
    Point p3 = new Point(-20,20,0);
    Point p4 = new Point(20,20,0);
  myShape.addParam(new Viereck(p1,p2,p3,p4));  
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
    Material.CHROME.use();
    myShape.draw();
    
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
