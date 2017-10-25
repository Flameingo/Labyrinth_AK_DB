package params;

public class Kreisabschnitt extends Param
{
  
  public Kreisabschnitt(float xscl, float yscl, float q)
  {
    super(xscl, yscl, 1, 0, (float) Math.PI * 2* q/360, 0, 1);
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
    float beta = 0;
    return alpha + v * (beta - alpha);
  }
  
}