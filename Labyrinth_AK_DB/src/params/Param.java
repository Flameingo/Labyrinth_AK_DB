package params;

//Imports
import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;

import org.lwjgl.BufferUtils; // to create a float buffer in place of the glfloat array

import main.Settings;

/**
 * Die verschiedenen Parametrisierungen im Paket "params" erhalten hier ihre draw()-Funktion.
 */
public abstract class Param
{
  // private Variablen
  
  protected float  xscl     = 1, yscl = 1, zscl = 1;
  private float    u_l, u_r, v_l, v_r;
  private float    u_i, v_j, u_i_1, v_j_1;
  private int      m        = 0, n = 0;
  protected int    minN     = 1, minM = 1;
  protected float  mfact, nfact;
  private float    delta_u, delta_v;
  
  private Material material = null;
  
  /** placeholder Param for connecting multiple Params into one or if the standard constructor can't be used */
  public Param()
  {
    
  }
  
  /**
   * Konstruktor ohne Material
   * 
   * @param xscl
   *          Skalierung in x-Richtung
   * @param yscl
   *          Skalierung in y-Richtung
   * @param zscl
   *          Skalierung in z-Richtung
   * @param u1
   *          Untere Schranke fuer u
   * @param u2
   *          Obere Schranke fuer u
   * @param v1
   *          Untere Schranke fuer v
   * @param v2
   *          Obere Schranke fuer v
   */
  public Param(float xscl, float yscl, float zscl, float u1, float u2, float v1, float v2)
  {
    init(xscl, yscl, zscl, u1, u2, v1, v2);
  }
  
  /**
   * Manchmal kann der Konstruktor nicht direkt ausgefuehrt werden, in diesem Fall muss mit dieser Funktion
   * nach-initialisiert werden.
   */
  protected void init(float xscl, float yscl, float zscl, float u1, float u2, float v1, float v2)
  {
    this.xscl = xscl;
    this.yscl = yscl;
    this.zscl = zscl;
    u_l = u1;
    u_r = u2;
    v_l = v1;
    v_r = v2;
    // Berechnung der notwendigen Aufloesung fuer die Variablen m und n:
    setResolution();
    m = (int) Math.ceil(mfact * Settings.RenderSolution);
    n = (int) Math.ceil(nfact * Settings.RenderSolution);
    m = Math.max(minM, m);
    n = Math.max(minN, n);
    delta_u = (u_r - u_l) / m;
    delta_v = (v_r - v_l) / n;
  }
  
  /** sets mfact and nfact as factors that control the resolution of the params polygon-net */
  abstract void setResolution();
  
  /**
   * Konstruktor mit Material
   * 
   * @param xscl
   *          Skalierung in x-Richtung
   * @param yscl
   *          Skalierung in y-Richtung
   * @param zscl
   *          Skalierung in z-Richtung
   * @param u1
   *          Untere Schranke fuer u
   * @param u2
   *          Obere Schranke fuer u
   * @param v1
   *          Untere Schranke fuer v
   * @param v2
   *          Obere Schranke fuer v
   * @param mat
   *          Material des Params, one of enum Material
   */
  public Param(float xscl, float yscl, float zscl, float u1, float u2, float v1, float v2, Material mat)
  {
    this(xscl, yscl, zscl, u1, u2, v1, v2);
    material = mat;
  }
  
  /**
   * Manchmal kann der Konstruktor nicht direkt ausgefuehrt werden, in diesem Fall muss mit dieser Funktion
   * nach-initialisiert werden.
   */
  protected void init(float xscl, float yscl, float zscl, float u1, float u2, float v1, float v2, Material mat)
  {
    init(xscl, yscl, zscl, u1, u2, v1, v2);
    material = mat;
  }
  
  protected void setMaterial(Material mat)
  {
    material = mat;
  }
  
  public void draw()
  {
    if (material != null) material.use();
    drawParametrisierung();
  }
  /**
   * 
   */
  protected void drawParametrisierung()
  {
    glPolygonMode(GL_FRONT, GL_LINE);
    glPolygonMode(GL_BACK, GL_POINT); // Rueckseite der Objekte werden als Punkte gezeichnet. Sind Punkte zu sehen, muss
                                      // also das Objekt korrigiert werden.
    
    for (int i = 0; i < m; i++)
    {
      u_i = u_l + delta_u * i;
      u_i_1 = u_i + delta_u;
      
      for (int j = 0; j < n; j++)
      {
        v_j = v_l + delta_v * j;
        v_j_1 = v_j + delta_v;
        
        glBegin(GL_TRIANGLE_FAN);
        glVertex3f(xscl * x(u_i, v_j), yscl * y(u_i, v_j), zscl * z(u_i, v_j));
        glVertex3f(xscl * x(u_i_1, v_j), yscl * y(u_i_1, v_j), zscl * z(u_i_1, v_j));
        glVertex3f(xscl * x(u_i_1, v_j_1), yscl * y(u_i_1, v_j_1), zscl * z(u_i_1, v_j_1));
        glVertex3f(xscl * x(u_i, v_j_1), yscl * y(u_i, v_j_1), zscl * z(u_i, v_j_1));
        glEnd();
      }
    }
  }
  
  abstract protected float x(float u, float v);
  
  abstract protected float y(float u, float v);
  
  abstract protected float z(float u, float v);
}
