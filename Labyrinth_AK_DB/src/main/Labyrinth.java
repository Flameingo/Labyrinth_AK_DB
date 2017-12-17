package main;

//Imports
import static org.lwjgl.glfw.GLFW.*; // fuer keyboard
import java.nio.FloatBuffer;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import basics.Text;
import models3D.DisplayList;
import models3D.Fog;
import params.Kugel;
import params.Shape;
import basics.Point;

import static org.lwjgl.opengl.GL11.*;

/** Hauptklasse, initialisiert und steuert das Spiel */
public class Labyrinth
{
  // Variablen:
  /** contains all objects that are currently in the game */
  private static Objekt[]    objekte = {};
  
  private static FloatBuffer fb      = BufferUtils.createFloatBuffer(16);
  private static Matrix4f    m       = new Matrix4f();
  
  /** camera origin */
  private static Point       eye     = new Point(5, 0, 0);
  /** defining the camera to be upright */
  private static final Point up      = new Point(0, 0, 1);
  /** center point of the view */
  private static Point       lookat  = new Point(0, 0, 0);
  
  public static Player       player  = new Player();
  
  /**
   * every frame, this array is refreshed with all pressed keys at that moment in time
   */
  public static int[]        keys    = {};
  
  private static DisplayList fog     = new DisplayList();
  
  public static void beginGame()
  {
    Text.init();
    addObject(new Spawner());
    addObject(player);
    fog.addObjekt(new Fog());
  }
  
  /**
   * fuegt ein Objekt in das Array "objekte" ein
   * 
   * @param objekt
   *          Das Objekt, das hinzugefuegt wird
   */
  public static void addObject(Objekt objekt)
  {
    Objekt[] newObjects = new Objekt[objekte.length + 1];
    for (int i = 0; i < objekte.length; i++)
      newObjects[i] = objekte[i];
    newObjects[objekte.length] = objekt;
    objekte = newObjects;
  }
  
  /**
   * entfernt ein Objekt aus dem Array "objekte"
   * 
   * @param objekt
   *          Das Objekt, das entfernt wird
   */
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
  
  /**
   * ueberprueft, ob eine gegebene Taste gedrueckt ist
   * 
   * @param key
   *          Die Taste, die geprueft wird. Anzugeben als Integer mithilfe der GLFW-Tasten-enums.
   * @return Ein boolscher Wert, der angibt, ob die Taste gedrueckt ist.
   */
  private static boolean keyCheck(int key)
  {
    for (int i = 0; i < keys.length; i++)
    {
      if (keys[i] == key) return true;
    }
    return false;
  }
  
  /** Initialisiert die Statusmaschine von Open_GL */
  public static void initGLState()
  {
    Lights.init();
    
    glMatrixMode(GL_PROJECTION);
    int far = 4;
    if (!Settings.NEBEL_ON) far = 100;
    m.setPerspective((float) Math.PI / 2f, 16f / 9f, 0.01f, far);
    glLoadIdentity();
    m.get(fb);
    glLoadMatrixf(fb);
    
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    
    glClearColor(.1f, .15f, .15f, 0); // Set the clear color
    
  }
  
  /**
   * standard setter fuer die Variablen "eye" und "lookat"
   * 
   * @param eye
   *          Kamera-Ursprungspunkt
   * @param lookat
   *          Mittelpunkt der Perspektive
   */
  public static void setView(Point eye, Point lookat)
  {
    Labyrinth.eye = eye;
    Labyrinth.lookat = lookat;
  }
  
  /**
   * Bringt die Objekte zum Leben.
   * <p>
   * Fuer alle Objekte im Array "objekte" werden die Funktionen
   * <p>
   * step()
   * <p>
   * collision()
   * <p>
   * draw()
   * <p>
   * drawGUI()
   * <p>
   * ausgefuehrt.
   * <p>
   * Ausserdem wird die Kameraperspektive aktualisiert.
   */
  public static void renderLoop()
  {
    for (Objekt o : objekte)
      // if (!o.hidden) o.step();
      o.step();
    for (Objekt o : objekte)
      if (!o.hidden) o.collision();
    player.updatecam();
    
    if (Settings.POLYMODE_ON) glPolygonMode(GL_FRONT, GL_LINE);
    glPolygonMode(GL_BACK, GL_NONE);
    if (Settings.DRAW_BACK_POINTS) glPolygonMode(GL_BACK, GL_POINT);// Rueckseite
                                                                    // der
                                                                    // Objekte
                                                                    // werden
                                                                    // als
                                                                    // Punkte
                                                                    // gezeichnet.
                                                                    // Sind
                                                                    // Punkte zu
                                                                    // sehen,
                                                                    // muss also
                                                                    // das
                                                                    // Objekt
                                                                    // korrigiert
                                                                    // werden.
    
    if (Settings.FLAT_SHADING) glShadeModel(GL_FLAT);
    
    glMatrixMode(GL_MODELVIEW);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_LIGHTING);
    
    m.setLookAt(eye.x, eye.y, eye.z, lookat.x, lookat.y, lookat.z, up.x, up.y, up.z);
    m.get(fb);
    glLoadMatrixf(fb);
    
    Lights.setLights();
    
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    glEnable(GL_BLEND);
    for (Objekt o : objekte)
      if (!o.hidden)
      {
        glPushMatrix();
        o.translate_rotate();
        o.draw();
        glPopMatrix();
      }
    if (Settings.NEBEL_ON)
    {
      // glDepthMask(false);
      m.setLookAt(1, 0, 0, 0, 0, 0, up.x, up.y, up.z);
      m.get(fb);
      glLoadMatrixf(fb);
      fog.draw();
      // glDepthMask(true);
    }
    glDisable(GL_BLEND);
    
    glDisable(GL_LIGHTING);
    glMatrixMode(GL_PROJECTION);
    glPushMatrix();
    glLoadIdentity();
    glOrtho(0, 800, 0, 600, 0, 10);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    for (Objekt o : objekte)
      if (!o.hidden) o.drawGUI();
    glMatrixMode(GL_PROJECTION);
    glPopMatrix();
  }
  
  /**
   * Behandelt Tastenanschlaege.
   * <p>
   * Wird nur fuer Tastenanschlaege verwendet, nicht fuer das Halten einer Taste. Das Halten wird in der Funktion
   * keyCheck() behandelt.
   * 
   * @param key
   *          Taste, die gedrueckt wurde.
   * @param action
   *          Art des Tastendrucks
   * @see Labyrinth#keyCheck(int)
   */
  public static void keyboard(int key, int action)
  {
    if (action == GLFW_PRESS) player.teleport(key);
  }
  
  /**
   * Sucht ein Objekt einer bestimmten Klasse im Array "objekte"
   * <p>
   * Damit kann ein Objekt, fuer das man keine Referenz hat, trotzdem referenziert werden. Allerdings sollte nur eine
   * Instanz des Objekt vorhanden sein, da nur das zuerst gefundene zurueckgegeben wird.
   * 
   * @param identifier
   *          Platzhalter fuer die Klasse, die gesucht wird. Einfach eine leere Instanz der gesuchten Klasse uebergeben,
   *          zB: findInstance(new GesuchteKlasse());
   * @return Die Referenz des gesuchten Objekts
   */
  public static Objekt findInstance(Objekt identifier)
  {
    for (int i = 0; i < objekte.length; i++)
    {
      if (objekte[i].getClass() == identifier.getClass()) { return objekte[i]; }
    }
    return null;
  }
}
