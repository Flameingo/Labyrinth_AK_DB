package params;

import static org.lwjgl.opengl.GL11.*;

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
  
  public Kegel(float xscl, float yscl, float zscl, Material mat)
  {
    super();
    boden = new Kreis(xscl, yscl);
    mantel = new KegelMantel(xscl, yscl, zscl);
    setMaterial(mat);
  }
  
  @Override
  protected void drawParametrisierung()
  {
    glFrontFace(GL_CW);
    boden.draw();
    glFrontFace(GL_CCW);
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
  
  @Override
  void setResolution()
  {
    
  }
  
}
