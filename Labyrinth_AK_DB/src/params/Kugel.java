package params;

public class Kugel extends Param
{
  /**
   * 
   * @param r
   *          Radius der Kugel
   */
  public Kugel(float r)
  {
    super(r, r, r, -(float) Math.PI / 2, (float) Math.PI / 2, 0, (float) Math.PI * 2);
  }
  
  /**
   * 
   * @param r
   *          Radius der Kugel
   * 
   * @param col
   *          Farbe der Kugel
   */
  public Kugel(float r, Material mat)
  {
    this(r);
    setMaterial(mat);
  }
  
  @Override
  public float x(float u, float v)
  {
    return (float) (Math.cos(u) * Math.sin(v));
  }
  
  @Override
  public float y(float u, float v)
  {
    return (float) (Math.cos(u) * Math.cos(v));
  }
  
  @Override
  public float z(float u, float v)
  {
    return (float) Math.sin(u);
  }
  
  @Override
  void setResolution()
  {
    nfact = (float) Math.PI * xscl;
    mfact = nfact * 2;
    minN = 3;
    minM = 2;
  }
  
}
