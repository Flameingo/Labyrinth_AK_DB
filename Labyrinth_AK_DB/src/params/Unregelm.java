package params;

import basics.Point;

public class Unregelm extends Param
{
  
  Param[] seiten = { null, null, null, null, null, null };
  
  public Unregelm(Point p1, Point p2, Point p3, Point p4, Point p5, Point p6, Point p7, Point p8)
  {
    super();
    
    seiten[0] = new Viereck(p1, p3, p2, p4);
    seiten[1] = new Viereck(p1, p2, p5, p6);
    seiten[2] = new Viereck(p1, p5, p3, p7);
    seiten[3] = new Viereck(p2, p4, p6, p8);
    seiten[4] = new Viereck(p3, p7, p4, p8);
    seiten[5] = new Viereck(p5, p6, p7, p8);
    
  }
  
  public Unregelm(Point p1, Point p2, Point p3, Point p4, Point p5, Point p6, Point p7, Point p8, Material mat)
  {
    this(p1, p2, p3, p4, p5, p6, p7, p8);
    setMaterial(mat);
  }
  
  protected void drawParametrisierung()
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
  
  @Override
  void setResolution()
  {
    // unused
  }
  
}
