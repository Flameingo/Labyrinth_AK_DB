package params;

public class Kreis extends Param
{
  
  public Kreis(float xscl, float yscl)
  {
    super(xscl, yscl, 1, 0, (float) Math.PI * 2, 0, 1);
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
    return 0; // same result as:
    // float alpha = 0;
    // float beta = 0;
    // return alpha + v * (beta - alpha);
  }
  
  @Override
  void setResolution()
  {
    mfact = (float) (Math.PI * (xscl + yscl));
    nfact = (xscl + yscl) / 2;
    minM = 3;
  }
}
