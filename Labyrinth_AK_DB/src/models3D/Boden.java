package models3D;

import basics.Point;
import main.Labyrinth;
import main.Objekt;
import params.Material;
import params.Shape;
import params.Viereck;

public class Boden extends Objekt
{
  protected Shape myShape = new Shape();
  
  public Boden()
  {
    Point p1 = new Point(-45, -45, 0);
    Point p2 = new Point(45, -45, 0);
    Point p3 = new Point(-45, 45, 0);
    Point p4 = new Point(45, 45, 0);
    myShape.addParam(new Viereck(p1, p2, p3, p4));

    
  }
  
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
    
  }
  
  Point p1 = new Point(0, 0, 0);
  Point up = new Point(0, 0, 1);
  
  @Override
  public void collision()
  {
    int res = 450;
    float length = 45;
    for (int i = 0; i < res; i++)
      for (int j = 0; j < res; j++)
      {
        Point p = new Point(-length + i * 2 * length / res, -length + j * 2 * length / res, 0);
         while (Labyrinth.player.hitbox(p))
        {
          Labyrinth.player.pos.z += .1f;
        }
      }
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
