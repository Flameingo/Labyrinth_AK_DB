/* 
 * Die verschiedenen Parametrisierung im Paket "params" erhalten hier ihre draw()-Funktion.
*/

package params;

//Imports
import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;

import org.lwjgl.BufferUtils; // to create a float buffer in place of the glfloat array

import main.Settings;

public abstract class Param
{
  // private Variablen
  
  private float     xscl = 1, yscl = 1, zscl = 1;
  private float     u_l, u_r, v_l, v_r;
  private float     u_i, v_j, u_i_1, v_j_1;
  private int       m, n;
  private float     delta_u, delta_v;
  
  protected float[] col  = { 1, 1, 1 };
  
  /**
   * Konstruktor ohne Farbe
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
    this.xscl = xscl;
    this.yscl = yscl;
    this.zscl = zscl;
    u_l = u1;
    u_r = u2;
    v_l = v1;
    v_r = v2;
    m = Settings.RenderSolution;
    n = Settings.RenderSolution;
    delta_u = (u_r - u_l) / m;
    delta_v = (v_r - v_l) / n;
  }
  
  public Param(float xscl, float yscl, float zscl, float u1, float u2, float v1, float v2, float[] col)
  {
    this(xscl, yscl, zscl, u1, u2, v1, v2);
    this.col = col;
  }
  
  public void draw()
  {
    glColor3fv(col);
    drawParametrisierung();
  }
  
  private void drawParametrisierung()
  {
    glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
    
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
