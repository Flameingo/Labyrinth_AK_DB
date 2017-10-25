package params;

import static org.lwjgl.opengl.GL11.*;

public class ZylinderAbschnitt extends Param
{
  
  private Param deckel;
  private Param mantel;
  private Param schnittseite1;
  private Param schnittseite2;
  private float zscl;
  
  public ZylinderAbschnitt(float xscl, float yscl, float zscl, float winkel)
  {
    super();
    deckel = new Kreisabschnitt(xscl, yscl, winkel);
    mantel = new ZylinderMantelAbschnitt(xscl, yscl, zscl, winkel);
    schnittseite1 = new ZylAbschnittSchnittseite1(xscl, yscl, zscl);
    schnittseite2 = new ZylAbschnittSchnittseite2(xscl, yscl, zscl, winkel);
    this.zscl = zscl;
  }
  
  public ZylinderAbschnitt(float xscl, float yscl, float zscl, float winkel, Material mat)
  {
    this(xscl, yscl, zscl, winkel);
    setMaterial(mat);
  }
  
  @Override
  protected void drawParametrisierung()
  {
    glFrontFace(GL_CW);
    deckel.draw();
    glFrontFace(GL_CCW);
    mantel.draw();
    glFrontFace(GL_CW);
    schnittseite1.draw();
    glFrontFace(GL_CW);
    schnittseite2.draw();
    glPushMatrix();
    {
      glTranslatef(0, 0, zscl);
      glFrontFace(GL_CCW);
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
  
  @Override
  void setResolution()
  {
    // unused
    
  }
  
}
