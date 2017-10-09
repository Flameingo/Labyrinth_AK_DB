package main;

//Imports
import static org.lwjgl.glfw.GLFW.*; // f�r keyboard
import java.nio.FloatBuffer;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL11.*;

public class Labyrinth
{
  /// Hauptklasse, initialisiert und steuert das Spiel
  
  // Variablen:
  private Objekt[]      objekte = {};                               // contains all objects that are currently in the game
  
  private FloatBuffer   fb      = BufferUtils.createFloatBuffer(16);
  private Matrix4f      m       = new Matrix4f();
  
  private float[]       eye     = { 5, 0, 0 };                      // camera origin
  private final float[] up      = { 0, 1, 0 };                      // defining the camera to be upright
  
  public int[]          keys    = {};                               // every frame, this array is refreshed with all pressed keys at that moment in time
  
  public Labyrinth()
  {
    addObject(new Spawner());
  }
  
  public void addObject(Objekt objekt)
  {
    Objekt[] newObjects = new Objekt[objekte.length + 1];
    for (int i = 0; i < objekte.length; i++)
      newObjects[i] = objekte[i];
    newObjects[objekte.length] = objekt;
    objekte = newObjects;
  }
  
  public void deleteObject(Object objekt)
  {
    Objekt[] newObjects = new Objekt[objekte.length - 1];
    int j = 0;
    for (int i = 0; i < objekte.length; i++)
    {
      if (objekte[i] != objekt)
      {
        newObjects[j] = objekte[i];
        j++;
        if (j >= objekte.length) return;
      }
    }
    objekte = newObjects;
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
