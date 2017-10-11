package main;

//Imports
import static org.lwjgl.glfw.GLFW.*; // f�r keyboard
import java.nio.FloatBuffer;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import basics.Point;

import static org.lwjgl.opengl.GL11.*;

public class Labyrinth
{
  /// Hauptklasse, initialisiert und steuert das Spiel
  
  // Variablen:
  private static Objekt[]    objekte = {};                               // contains
                                                                         // all
                                                                         // objects
                                                                         // that
                                                                         // are
                                                                         // currently
                                                                         // in
                                                                         // the
                                                                         // game
  
  private static FloatBuffer fb      = BufferUtils.createFloatBuffer(16);
  private static Matrix4f    m       = new Matrix4f();
  
  private static Point       eye     = new Point(5, 0, 0);               // camera
                                                                         // origin
  private static final Point up      = new Point(0, 0, 1);               // defining
  // the
  // camera
  // to
  // be
  // upright
  private static Point       lookat  = new Point(0, 0, 0);
  
  public static int[]        keys    = {};                               // every
                                                                         // frame,
                                                                         // this
                                                                         // array
                                                                         // is
                                                                         // refreshed
                                                                         // with
                                                                         // all
                                                                         // pressed
                                                                         // keys
                                                                         // at
                                                                         // that
                                                                         // moment
                                                                         // in
                                                                         // time
  
  public static void beginGame()
  {
    addObject(new Spawner());
  }
  
  public static void addObject(Objekt objekt)
  {
    Objekt[] newObjects = new Objekt[objekte.length + 1];
    for (int i = 0; i < objekte.length; i++)
      newObjects[i] = objekte[i];
    newObjects[objekte.length] = objekt;
    objekte = newObjects;
  }
  
  public static void deleteObject(Object objekt)
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
  
  private static boolean keyCheck(int key)
  {
    for (int i = 0; i < keys.length; i++)
    {
      if (keys[i] == key) return true;
    }
    return false;
  }
  
  public static void initGLState()
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
  
  public static void setView(Point eye, Point lookat)
  {
    // standard setter
    Labyrinth.eye = eye;
    Labyrinth.lookat = lookat;
  }
  
  public static void renderLoop()
  {
    for (int i = 0; i < objekte.length; i++)
      objekte[i].step();
    for (int i = 0; i < objekte.length; i++)
      objekte[i].collision();
    
    m.setLookAt(eye.x, eye.y, eye.z, lookat.x, lookat.y, lookat.z, up.x, up.y, up.z);
    m.get(fb);
    
    glPushMatrix();
    glLoadMatrixf(fb);
    for (int i = 0; i < objekte.length; i++)
      objekte[i].draw();
    glPopMatrix();
    
    for (int i = 0; i < objekte.length; i++)
      objekte[i].drawGUI();
  }
  
  public static void keyboard(int key, int action)
  {
    
  }
}
