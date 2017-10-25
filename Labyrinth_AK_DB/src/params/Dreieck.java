package params;

import basics.*;
import main.Settings;

public class Dreieck extends Param
{
  
  private Point p1;
  private Point p2;
  private Point p3;
  
  public Dreieck(Point p1, Point p2, Point p3, float[] col)
  {
    super();
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    init(1, 1, 1, 0, 1, 0, 1, col);
  }
  
  public Dreieck(Point p1, Point p2, Point p3)
  {
    this(p1, p2, p3, new float[] { 1, 1, 1 });
  }
  
  @Override
  public float x(float u, float v)
  {
    float alpha = p1.x + u * (p2.x - p1.x);
    float beta = p3.x;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    float alpha = p1.y + u * (p2.y - p1.y);
    float beta = p3.y;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    float alpha = p1.z + u * (p2.z - p1.z);
    float beta = p3.z;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  void setResolution()
  {
    mfact = Point.add(p2, Point.neg(p1)).length();
    nfact = Point.add(p3, Point.neg(p1)).length();
  }
  
}
