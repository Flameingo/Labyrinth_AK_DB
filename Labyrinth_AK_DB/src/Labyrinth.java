
//Imports
import static org.lwjgl.glfw.GLFW.*; // f�r keyboard
import java.nio.FloatBuffer;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL11.*;

public class Labyrinth
{
  //Hauptklasse, initialisiert und steuert das Spiel
  // private Variablen
  Objekt[]      objekte = {};
  
  FloatBuffer   fb      = BufferUtils.createFloatBuffer(16);
  Matrix4f      m       = new Matrix4f();
  
  float[]       eye     = { 5, 0, 0 };
  final float[] up      = { 0, 1, 0 };
  
  public int[]  keys    = {};
  
  public Labyrinth()
  {
    
  }
  
  private void addObject(Objekt objekt)
  {
    Objekt[] newBodys = new Objekt[objekte.length + 1];
    for (int i = 0; i < objekte.length; i++)
      newBodys[i] = objekte[i];
    newBodys[objekte.length] = objekt;
    objekte = newBodys;
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
    for (int i = 0; i < objekte.length; i++)
      objekte[i].draw();
    glPopMatrix();
  }
  
  public void keyboard(int key, int action)
  {
    
  }
}
