package params;

public class ZylinderMantel extends Param
{
  
  public ZylinderMantel(float xscl, float yscl, float zscl)
  {
    super(xscl, yscl, zscl, 0, (float) Math.PI * 2, 0, 1);
  }
  
  @Override
  public float x(float u, float v)
  {
    return (float) Math.cos(u); // same as:
    // float alpha = (float) Math.cos(u);
    // float beta = (float) Math.cos(u);
    // return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    return (float) Math.sin(u); // same as:
    // float alpha = (float) Math.sin(u);
    // float beta = (float) Math.sin(u);
    // return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    return v; // same as:
    // float alpha = 0;
    // float beta = 1;
    // return alpha + v * (beta - alpha);
  }
  
  @Override
  void setResolution()
  {
    nfact = zscl;
    mfact = (float) (Math.PI * (xscl + yscl));
    minM = 3;
  }
  
}
