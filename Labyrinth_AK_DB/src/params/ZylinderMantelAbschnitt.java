package params;

public class ZylinderMantelAbschnitt extends Param //Erfuellt die Funktionen von "Zylindermantel", zusaetzlich wird allerdings ein Winkel uebergeben (Gradmass), es wird nur dieser Winkelgrad
{													//des Kreises (Bodenflaeche des Zylinders) genutzt.
  
  public ZylinderMantelAbschnitt(float xscl, float yscl, float zscl, float winkel)
  {
    super(xscl, yscl, zscl, 0, (float) Math.PI*1/180*winkel, 0, 1);
  }
  
  public ZylinderMantelAbschnitt(float xscl, float yscl, float zscl, float winkel, Material mat)
  {
    this(xscl, yscl, zscl, winkel);
    setMaterial(mat);
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
