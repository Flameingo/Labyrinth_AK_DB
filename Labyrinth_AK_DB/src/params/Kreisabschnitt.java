package params;

public class Kreisabschnitt extends Param
{
  
  float q;
  
  public Kreisabschnitt(float xscl, float yscl, float q)
  {
    super(xscl, yscl, 1, 0, (float) Math.PI * q / 180, 0, 1);
    this.q = q;
  }
  
  public Kreisabschnitt(float xscl, float yscl, float q, Material mat)
  {
    this(xscl, yscl, q);
    setMaterial(mat);
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
  
  @Override
  void setResolution()
  {
    mfact = (float) (Math.PI * (xscl + yscl));
    minM = 3;
    nfact = (xscl + yscl) / 2;
  }
  
}