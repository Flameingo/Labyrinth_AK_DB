package params;

public class Kugel extends Param
{
  /**
   * 
   * @param r Radius der Kugel
   */
  public Kugel(float r)
  {
    super(r, r, r, (float) -Math.PI / 2, (float) Math.PI / 2, (float) -Math.PI, (float) Math.PI);
  }
  /**
   * 
   * @param r Radius der Kugel
   * 
   * @param col Farbe der Kugel
   */
  public Kugel(float r, float[] col)
  {
    this(r);
    this.col = col;
  }
  
  @Override
  public float x(float u, float v)
  {
    return (float) (Math.cos(v) * Math.sin(u));
  }
  
  @Override
  public float y(float u, float v)
  {
    return (float) (Math.cos(v) * Math.cos(u));
  }
  
  @Override
  public float z(float u, float v)
  {
    return (float) Math.sin(v);
  }
  
}
