package params;

import basics.Point;

import static org.lwjgl.opengl.GL11.*;

public class Prisma extends Param
{
  Param   deckel;
  Param[] mantel;
  float   hoehe;
  
  public Prisma(Point[] punkte, float hoehe)
  {
    deckel = new Vieleck(punkte);
    mantel = new Param[punkte.length - 1];
    for (int i = 0; i < mantel.length; i++)
      mantel[i] = new Viereck(punkte[i], punkte[i + 1], Point.add(punkte[i], 0, 0, hoehe),
          Point.add(punkte[i + 1], 0, 0, hoehe));
    this.hoehe = hoehe;
  }
  
  @Override
  protected void drawParametrisierung()
  {
    glFrontFace(GL_CW);
    deckel.draw();
    glFrontFace(GL_CCW);
    for (Param p : mantel)
    {
      p.draw();
    }
    glPushMatrix();
    {
      glTranslatef(0, 0, hoehe);
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
    // TODO Auto-generated method stub
    
  }
}
