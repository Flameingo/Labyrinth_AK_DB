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
    Point p3 = new Point(-20,-7.5f,0);
    Point p4 = new Point(20,-7.5f,0);
  myShape.addParam(new Viereck(p1,p2,p3,p4));  
  	Point p5 = new Point(-20,-7.5f,0);
  	Point p6 = new Point(12,-7.5f,0);
  	Point p7 = new Point(-20,20,0);
  	Point p8 = new Point(12,20,0);
  myShape.addParam(new Viereck(p5,p6,p7,p8));
  	Point p9 = new Point(12,-4.5f);
  	Point p10 = new Point(15,-4.5f);
  	Point p11 = new Point(12,20,0);
  	Point p12 = new Point(15,20,0);
  myShape.addParam(new Viereck(p9,p10,p11,p12));
  	Point p13 = new Point(15,-4.5f,0);
  	Point p14 = new Point(20,-4.5f,0);
  	Point p15 = new Point(15,20,0);
  	Point p16 = new Point(20,20,0);
  myShape.addParam(new Viereck(p13,p14,p15,p16));
  
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
    Material.GREEN_RUBBER.use();
    myShape.draw();
    
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
