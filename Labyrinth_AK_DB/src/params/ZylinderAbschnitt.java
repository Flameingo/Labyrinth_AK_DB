package params;

import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class ZylinderAbschnitt extends Param
{
  
  private Param deckel;
  private Param mantel;
  private Param schnittseite1;
  private Param schnittseite2;
  
  /**
   * Erschafft ein Objekt in der Form eines schweizer Kaeses
   * 
   * @param xscl
   *          x-Koordinate des Kreises
   * 
   * @param yscl
   *          y-Koordinate des Kreises, muss dem x-Wert entsprechen f�r einen Kreis mit dem Radius x.
   * 
   * @param zscl
   *          H�he des Zylinderabschnitts
   * 
   * @param winkel
   *          In Gradmass anzugeben
   */
  public ZylinderAbschnitt(float xscl, float yscl, float zscl, float winkel)
  {
    super();
    this.zscl = zscl;
    deckel = new Kreisabschnitt(xscl, yscl, winkel);
    mantel = new ZylinderMantelAbschnitt(xscl, yscl, zscl, winkel);
    Point p1 = new Point(0, 0, 0);
    Point p2 = new Point(0, 0, zscl);
    Point p3 = new Point(xscl, 0, 0);
    Point p4 = new Point(xscl, 0, zscl);
    winkel = (float) (Math.PI * winkel / 180);
    Point p5 = new Point((float) (xscl * Math.cos(winkel)), (float) (yscl * Math.sin(winkel)), 0);
    Point p6 = Point.add(p5, 0, 0, zscl);
    schnittseite1 = new Viereck(p1, p3, p2, p4);
    schnittseite2 = new Viereck(p1, p2, p5, p6);
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
    schnittseite1.draw();
    schnittseite2.draw();
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
  
  @Override
  void setResolution()
  {
    // unused
    
  }
  
}
