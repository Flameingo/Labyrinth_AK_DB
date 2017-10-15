package params;

import static org.lwjgl.opengl.GL11.*;

public class Zylinder extends Param
{
  
  private Param deckel;
  private Param mantel;
  private float zscl;
  
  public Zylinder(float xscl, float yscl, float zscl)
  {
    super();
    deckel = new Kreis(xscl, yscl);
    mantel = new ZylinderMantel(xscl, yscl, zscl);
    this.zscl = zscl;
  }
  
  @Override
  public void draw()
  {
    deckel.draw();
    mantel.draw();
    glPushMatrix();
    {
      glTranslatef(0, 0, zscl);
      deckel.draw();
    }
    glPopMatrix();
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