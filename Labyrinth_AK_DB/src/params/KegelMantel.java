package params;

public class KegelMantel extends Param
{
  
  public KegelMantel(float xscl, float yscl, float zscl) //Zeichnet einen Kegel mit xscl und yscl als Grundflaeche und zscl als Hoehe, allerdings ist die Grundflaeche selbst nicht enthalten.
  {															// Sprich, das Objekt ist nach unten geoeffnet.
    super(xscl, yscl, zscl, 0, (float) (2 * Math.PI), 0, 1);
  }
  
  public KegelMantel(float xscl, float yscl, float zscl, Material mat)
  {
    super(xscl, yscl, zscl, 0, (float) (2 * Math.PI), 0, 1, mat);
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
    minM = 3;
  }
  
}
