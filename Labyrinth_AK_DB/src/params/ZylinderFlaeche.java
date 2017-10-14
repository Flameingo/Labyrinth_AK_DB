package params;

import basics.Point;

public class ZylinderFlaeche extends Param
{
  
  public ZylinderFlaeche(float height, float breite1, float breite2, Point pos, float[] rot)
  {
    super(breite1, breite2, height, 0, (float) (2 * Math.PI), 0, 1);
  }
  
  @Override
  public float x(float u, float v)
  {
    float alpha = (float) Math.cos(u);
    float beta = 0;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    float alpha = (float) Math.sin(u);
    float beta = 0;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    float alpha = 0;
    float beta = 1;
    return alpha + v * (beta - alpha);
  }
  
}
