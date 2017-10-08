package params;

public class Viereck extends Param
{
  
  private float[] p1;
  private float[] p2;
  private float[] p3;
  private float[] p4;
  
  public Viereck(float[] p1, float[] p2, float[] p3, float[] p4)
  {
    super(1, 1, 1, 0, 1, 0, 1);
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }
  
  public Viereck(float[] p1, float[] p2, float[] p3, float[] p4, float[] col)
  {
    this(p1, p2, p3, p4);
   //TODO col
  }
  
  @Override
  public float x(float u, float v)
  {
    float alpha = p1[0] + u * (p2[0] - p1[0]);
    float beta = p3[0] + u * (p4[0] - p3[0]);
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    float alpha = p1[1] + u * (p2[1] - p1[1]);
    float beta = p3[1] + u * (p4[1] - p3[1]);
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    float alpha = p1[2] + u * (p2[2] - p1[2]);
    float beta = p3[2] + u * (p4[2] - p3[2]);
    return alpha + v * (beta - alpha);
  }
  
}
