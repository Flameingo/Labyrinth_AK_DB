package params;

import basics.Point;

public class Quader extends Param
{
  
  Param[] seiten = { null, null, null, null, null, null };
  
  public Quader(String kind, float length, float width, float height)
  {
    super();
    Point p1 = new Point(0, 0, 0);
    switch (kind)
    {
    case "Ecke":
      break;
    default:
      p1.x = -length / 2;
      p1.y = -width / 2;
      p1.z = -height / 2;
    }
    // seiten erstellen
    Point p2, p3, p4, p5, p6, p7, p8;
    p2 = Point.add(p1, length, 0, 0);
    p3 = Point.add(p1, 0, width, 0);
    p4 = Point.add(p1, length, width, 0);
    p5 = Point.add(p1, 0, 0, height);
    p6 = Point.add(p2, 0, 0, height);
    p7 = Point.add(p3, 0, 0, height);
    p8 = Point.add(p4, 0, 0, height);
    
    seiten[0] = new Viereck(p1, p2, p3, p4);
    seiten[1] = new Viereck(p1, p2, p5, p6);
    seiten[2] = new Viereck(p1, p3, p5, p7);
    seiten[3] = new Viereck(p2, p4, p6, p8);
    seiten[4] = new Viereck(p3, p4, p7, p8);
    seiten[5] = new Viereck(p5, p6, p7, p8);
    
  }
  
  public Quader(String kind)
  {
    this(kind, 1, 1, 1);
  }
  
  public void draw()
  {
    for (int i = 0; i < seiten.length; i++)
    {
      seiten[i].draw();
    }
  }
  
  @Override
  protected float x(float u, float v)
  {
    // unused
    return 0;
  }
  
  @Override
  protected float y(float u, float v)
  {
    // unused
    return 0;
  }
  
  @Override
  protected float z(float u, float v)
  {
    // unused
    return 0;
  }
  
}
