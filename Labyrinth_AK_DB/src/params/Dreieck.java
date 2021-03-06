package params;

import basics.*;

public class Dreieck extends Param                         //Es werden 3 Eckpunkte uebergeben (Objekte der Klasse Point), dann wird ein Dreieck gezeichnet. 
{														   //Optional kann ein Material uebergeben werden, das die Farbe bestimmt.
  
  private Point p1;
  private Point p2;
  private Point p3;
  
  public Dreieck(Point p1, Point p2, Point p3, Material mat)
  {
    super();
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    init(1, 1, 1, 0, 1, 0, 1, mat);
  }
  
  public Dreieck(Point p1, Point p2, Point p3)
  {
    super();
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    init(1, 1, 1, 0, 1, 0, 1);
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
