package params;

public class Kegel extends Param
{
  
  private Param boden;
  private Param mantel;
  
  public Kegel(float xscl, float yscl, float zscl)
  {
    super();
    boden = new Kreis(xscl, yscl);
    mantel = new KegelMantel(xscl, yscl, zscl);
  }
  
  @Override
  public void draw()
  {
    boden.draw();
    mantel.draw();
  }
  
  @Override
  protected float x(float u, float v)
  {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  protected float y(float u, float v)
  {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  protected float z(float u, float v)
  {
    // TODO Auto-generated method stub
    return 0;
  }
  
}
