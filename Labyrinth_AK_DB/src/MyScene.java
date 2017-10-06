
//Imports
import static org.lwjgl.glfw.GLFW.*; // für keyboard
import java.nio.FloatBuffer;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL11.*;

public class MyScene
{
  // private Variablen
  float         winkel1 = 45;
  float         winkel2 = 45;
  
  Koerper[]     bodys   = {};
  
  FloatBuffer   fb      = BufferUtils.createFloatBuffer(16);
  Matrix4f      m       = new Matrix4f();
  
  float[]       eye     = { 5, 0, 0 };
  final float[] up      = { 0, 1, 0 };
  
  public int[]  keys    = {};
  
  public MyScene()
  {
    float[] p1, col;
    col = new float[] { 1, 0, 0 };
    p1 = new float[] { 1, 0, 0 };
    addObject(new Kugel(p1, 2, col));
  }
  
  private void addObject(Koerper body)
  {
    Koerper[] newBodys = new Koerper[bodys.length + 1];
    for (int i = 0; i < bodys.length; i++)
      newBodys[i] = bodys[i];
    newBodys[bodys.length] = body;
    bodys = newBodys;
  }
  
  private void addObject(Param simple)
  {
    addObject(new Simple(simple));
  }
  
  private boolean keyCheck(int key)
  {
    for (int i = 0; i < keys.length; i++)
    {
      if (keys[i] == key) return true;
    }
    return false;
  }
  
  public void initGLState()
  {
    glEnable(GL_DEPTH_TEST);
    
    m.setPerspective((float) Math.PI / 2f, 16f / 9f, 0.1f, 15f);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    m.get(fb);
    glLoadMatrixf(fb);
    
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    
    glClearColor(0, 0, 0, 0); // Set the clear color
  }
  
  public void renderLoop()
  {
    float eing = (float) (Math.PI / 180);
    float temp = (float) (eye[0] * Math.cos(eing) + eye[2] * Math.sin(eing));
    eye[2] = (float) (eye[0] * -Math.sin(eing) + eye[2] * Math.cos(eing));
    eye[0] = temp;
    m.setLookAt(eye[0], eye[1], eye[2], 0, 0, 0, up[0], up[1], up[2]);
    m.get(fb);
    
    glPushMatrix();
    glLoadMatrixf(fb);
    glRotatef(winkel1, 0, 1, 0);
    winkel1 += 0.5;
    glRotatef(winkel2, 0, 0, 1);
    winkel2 += 0.2;
    for (int i = 0; i < bodys.length; i++)
      bodys[i].draw();
    glPopMatrix();
  }
  
  public void keyboard(int key, int action)
  {
    
  }
}
