package params;

import basics.*;

public class Viereck extends Param
{
  
  private Point p1;
  private Point p2;
  private Point p3;
  private Point p4;
  
  /**
   * 
   * @param p1
   * 
   * @param p2
   * 
   * @param p3
   * 
   * @param p4
   */
  public Viereck(Point p1, Point p2, Point p3, Point p4)
  {
    super();
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
    init(1, 1, 1, 0, 1, 0, 1);
  }
  
  public Viereck(Point p1, Point p2, Point p3, Point p4, float[] col)
  {
    this(p1, p2, p3, p4);
    this.col = col;
  }
  
  @Override
  public float x(float u, float v)
  {
    float alpha = p1.x + u * (p2.x - p1.x);
    float beta = p3.x + u * (p4.x - p3.x);
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    float alpha = p1.y + u * (p2.y - p1.y);
    float beta = p3.y + u * (p4.y - p3.y);
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    float alpha = p1.z + u * (p2.z - p1.z);
    float beta = p3.z + u * (p4.z - p3.z);
    return alpha + v * (beta - alpha);
  }
  
  @Override
  void setResolution()
  {
    mfact = (Point.add(p2, Point.neg(p1)).length() + Point.add(p4, Point.neg(p3)).length()) / 2;
    nfact = (Point.add(p3, Point.neg(p1)).length() + Point.add(p4, Point.neg(p2)).length()) / 2;
  }
  
}
