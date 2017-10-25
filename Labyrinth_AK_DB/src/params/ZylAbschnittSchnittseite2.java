package params;

public class ZylAbschnittSchnittseite2 extends Param
{
  private float winkelC;
  
  public ZylAbschnittSchnittseite2(float xscl, float yscl, float zscl, float winkel)
  {
    
    super(xscl, yscl, zscl, 0, (float) 1, 0, 1);
    winkelC = winkel;
  }
  
  public ZylAbschnittSchnittseite2(float xscl, float yscl, float zscl, float winkel, Material mat)
  {
    this(xscl, yscl, zscl, winkel);
    setMaterial(mat);
  }
  
  @Override
  public float x(float u, float v)
  {
    return (float) Math.cos(winkelC*Math.PI/180)*u; // same as:
    // float alpha = (float) Math.cos(u);
    // float beta = (float) Math.cos(u);
    // return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    return (float) Math.sin(winkelC*Math.PI/180)*u; // same as:
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
