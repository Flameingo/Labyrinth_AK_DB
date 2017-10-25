package params;

import basics.Point;
import main.Settings;

public class KegelMantel extends Param
{
  
  public KegelMantel(float xscl, float yscl, float zscl)
  {
    super(xscl, yscl, zscl, 0, (float) (2 * Math.PI), 0, 1);
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
  
  @Override
  void setResolution()
  {
    nfact = zscl;
    mfact = (float) (Math.PI * (xscl + yscl));
  }
  
}
