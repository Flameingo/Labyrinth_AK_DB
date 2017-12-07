package models3D;

import basics.Point;
import main.Labyrinth;
import main.Objekt;
import params.Material;
import params.Shape;
import params.Viereck;

public class BodenBC extends Objekt
{
  protected Shape myShape = new Shape();
  
  public BodenBC()
  {
    Point p1 = new Point(-20, -20, 0);
    Point p2 = new Point(20, -20, 0);
    Point p3 = new Point(-20, -7.5f, 0);
    Point p4 = new Point(20, -7.5f, 0);
    myShape.addParam(new Viereck(p1, p2, p3, p4));
    Point p5 = new Point(-20, -7.5f, 0);
    Point p6 = new Point(12, -7.5f, 0);
    Point p7 = new Point(-20, 20, 0);
    Point p8 = new Point(12, 20, 0);
    myShape.addParam(new Viereck(p5, p6, p7, p8));
    Point p9 = new Point(12, -4.5f);
    Point p10 = new Point(13.5f, -4.5f);
    Point p11 = new Point(12, 20, 0);
    Point p12 = new Point(13.5f, 20, 0);
    myShape.addParam(new Viereck(p9, p10, p11, p12));
    Point p13 = new Point(16.5f, -7.5f, 0);
    Point p14 = new Point(20, -7.5f, 0);
    Point p15 = new Point(16.5f, 20, 0);
    Point p16 = new Point(20, 20, 0);
    myShape.addParam(new Viereck(p13, p14, p15, p16));
    Point p17 = new Point (13.5f,-4.5f,0);
    Point p18 = new Point (16.5f,-4.5f,0);
    Point p19 = new Point (13.5f,4.5f,0);
    Point p20 = new Point (16.5f,4.5f,0);
    myShape.addParam(new Viereck(p17,p18,p19,p20));
    Point p21 = new Point (15,-7.5f,0);
    Point p22 = new Point (16.5f,-7.5f,0);
    Point p23 = new Point (15,-4.5f,0);
    Point p24 = new Point (16.5f,-4.5f,0);
    myShape.addParam(new Viereck(p21,p22,p23,p24));
    Point p25 = new Point (13.5f,7.5f,0);
    Point p26 = new Point (16.5f,7.5f,0);
    Point p27 = new Point (13.5f,20,0);
    Point p28 = new Point (16.5f,20,0);
    myShape.addParam(new Viereck(p25,p26,p27,p28));
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
    int res = 200;
    float length = 20;
    for (int i = 0; i < res; i++)
      for (int j = 0; j < res; j++)
      {
        Point p = new Point(-length + i * 2 * length / res, -length + j * 2 * length / res, 0);
        if (!(p.x > 12 && p.x < 15 && p.y > -7.5f && p.y < -4.5f) && !(p.x >13.5f && p.x < 16.5f && p.y > 4.5f && p.y < 7.5f)) while (Labyrinth.player.hitbox(p))
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
