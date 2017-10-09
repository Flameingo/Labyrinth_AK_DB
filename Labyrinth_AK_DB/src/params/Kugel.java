package params;

public class Kugel extends Param
{
  
  private float[] p1;
  
  public Kugel(float[] p1, float r)
  {
    super(r, r, r, (float) -Math.PI / 2, (float) Math.PI / 2, (float) -Math.PI, (float) Math.PI);
    this.p1 = p1;
  }
  
  public Kugel(float[] p1, float r, float[] col)
  {
    this(p1, r);
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
