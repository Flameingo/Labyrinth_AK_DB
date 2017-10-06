
public class Dreieck extends Param
{
  
  private float[] p1;
  private float[] p2;
  private float[] p3;
  
  public Dreieck(float[] p1, float[] p2, float[] p3, float[] col)
  {
    super(1, 1, 1, 0, 1, 0, 1, col);
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }
  
  public Dreieck(float[] p1, float[] p2, float[] p3)
  {
    this(p1, p2, p3, new float[] { 1, 1, 1 });
  }
  
  // TODO Parametrisierung
  
  @Override
  public float x(float u, float v)
  {
    float alpha = p1[0] + u * (p2[0] - p1[0]);
    float beta = p3[0];
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    float alpha = p1[1] + u * (p2[1] - p1[1]);
    float beta = p3[1];
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    float alpha = p1[2] + u * (p2[2] - p1[2]);
    float beta = p3[2];
    return alpha + v * (beta - alpha);
  }
  
}
