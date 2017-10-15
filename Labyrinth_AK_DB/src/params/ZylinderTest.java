package params;

public class ZylinderTest extends Param
{
  
  public float b;
  
  public ZylinderTest(float xscl, float yscl, float zscl, float b)
  {
    super(xscl, yscl, zscl, 0, (float) Math.PI * 2, 0, 1);
    this.b=b;
  }
  
  @Override
  public float x(float u, float v)
  {
    float alpha = (float) Math.cos(u);
    float beta = (float) (Math.cos(u)-Math.cos(u/2));
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    float alpha = (float) Math.sin(u);
    float beta = (float) (Math.sin(u)-Math.cos(u/2));
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    float alpha = 0;
    float beta = 1-(float)Math.cos(u/2);
    return alpha + v * (beta - alpha);
  }
  
}
