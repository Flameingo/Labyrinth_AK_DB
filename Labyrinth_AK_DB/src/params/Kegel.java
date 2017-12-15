package params;

import static org.lwjgl.opengl.GL11.*;

public class Kegel extends Param
{
  
  private Param boden;
  private Param mantel;
  /** Zeichnet einen Kegel, xscl und yscl definieren den Boden, xscl = yscl fuer eine Kreisfoermige Grundflaeche, andernfalls Ellipse.
   *  zscl entspricht der Hoehe.
   * @param xscl
   * @param yscl
   * @param zscl
   */
  public Kegel(float xscl, float yscl, float zscl)
  {
    super();
    boden = new Kreis(xscl, yscl);
    mantel = new KegelMantel(xscl, yscl, zscl);
  }
  
  public Kegel(float xscl, float yscl, float zscl, Material mat) //Gleiche Methode, nur kann hier noch die Farbe des Objektes bestimmt werden.
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
