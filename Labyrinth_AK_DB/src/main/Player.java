package main;

import basics.Text;
import basics.Point;
import models3D.Schalter;
import path.SchalterFeld;

import static org.lwjgl.glfw.GLFW.*;

public class Player extends Objekt
{
  // This is the player object that controls movement
  
  // get settings
  private final float        spdLR   = Settings.PlayerRotationLeftRight;
  private final float        spdUD   = Settings.PlayerRotationUpDown;
  private final float        spdMOV  = Settings.PlayerMovementSpeed;
  private final float        spdSIDE = Settings.PlayerSideStepSpeed;
  
  // Position im Spiel
  public Point               pos     = new Point(0, -20, 1);             // Ursp 0,-1,3 /fuer AbschnittD (0, -20, 1)
  // Kameraausrichtung
  Point                      cam     = new Point(1, 0, 0);
  
  // hitbox:
  // Zylinder mit Hoehe h_h, Radius h_r
  // Kamera sitzt auf Hoehe k_h und um k_off nach vorne versetzt
  private final static float h_h     = 1.7f;
  private final static float h_r     = .15f;
  private final static float k_h     = 1.2f;
  // private final static float k_off = 0;
  
  @Override
  public void step()
  {
    for (int key : Labyrinth.keys)
    {
      // bewegungen anhand WASD und arrow-keys einleiten.
      Point p;
      switch (key)
      {
      case GLFW_KEY_W:
        p = new Point(cam.x, cam.y, 0);
        p.normalize();
        pos.add(Point.mult(p, spdMOV));
        break;
      case GLFW_KEY_S:
        p = new Point(cam.x, cam.y, 0);
        p.normalize();
        pos.add(Point.mult(p, -spdMOV));
        break;
      case GLFW_KEY_A:
        sidestep(spdSIDE);
        break;
      case GLFW_KEY_D:
        sidestep(-spdSIDE);
        break;
      case GLFW_KEY_LEFT:
        camRotate(spdLR, 0);
        break;
      case GLFW_KEY_RIGHT:
        camRotate(-spdLR, 0);
        break;
      case GLFW_KEY_UP:
        if (cam.z < .8) camRotate(0, spdUD);
        break;
      case GLFW_KEY_DOWN:
        if (cam.z > -.8) camRotate(0, -spdUD);
        break;
      default:
        break;
      }
    }
    pos.add(0, 0, -.1f);
  }
  
  /** moves the Player to the side */
  private void sidestep(float spd)
  {
    float dirY = (float) (cam.x * Math.PI);
    float dirX = (float) (cam.y * -Math.PI);
    Point dir = new Point(dirX, dirY, 0);
    dir.normalize();
    dir.mult(spd);
    pos.add(dir);
  }
  
  /**
   * rotates the Point "cam" with the given angles
   * 
   * @param leftright
   *          dreht die Sicht nach Links / Rechts. Positive Werte drehen nach links.
   * @param updown
   *          dreht die Sicht nach Oben / Unten. Positive Werte drehen nach oben.
   */
  private void camRotate(float leftright, float updown)
  {
    // Left - Right:
    if (leftright != 0)
    {
      float tempY = (float) (cam.y * Math.cos(leftright) + cam.x * Math.sin(leftright));
      cam.x = (float) (cam.y * -Math.sin(leftright) + cam.x * Math.cos(leftright));
      cam.y = tempY;
    }
    // Up - Down:
    if (updown != 0)
    {
      float xyLength = cam.length("xy");
      float tempZ = (float) (cam.z * Math.cos(updown) + xyLength * Math.sin(updown));
      float arc = (float) Math.atan(cam.x / cam.y);
      float tempXY = (float) (xyLength * Math.cos(updown) - cam.z * Math.sin(updown));
      if (cam.y < 0) tempXY *= -1;
      cam.x = (float) (tempXY * Math.sin(arc));
      cam.y = (float) (tempXY * Math.cos(arc));
      cam.z = tempZ;
    }
    // fix rounding errors
    cam.normalize();
  }
  
  /**
   * returns true if the Point p is in the hitbox of the player
   * 
   * @param p
   *          Point that is tested
   * @return boolean value wether the Point is in the hitbox
   */
  public boolean hitbox(Point p)
  {
    if (p.z <= pos.z) return false;
    if (p.z >= pos.z + h_h) return false;
    if (Math.abs(p.x - pos.x) > h_r) return false;
    if (Math.abs(p.y - pos.y) > h_r) return false;
    Point dist = Point.add(pos, Point.neg(p));
    if (dist.length("xy") > h_r) return false;
    return true;
  }
  
  public void updatecam()
  {
    // Kameraposition in Klasse "Labyrinth" aktualisieren.
    Point campos = Point.add(pos, 0, 0, k_h);
    Point lookat = Point.add(campos, cam);
    Labyrinth.setView(campos, lookat);
    
    if (Settings.DrawPlayerPOS) System.out.println(this);
  }
  
  @Override
  public void collision()
  {
  }
  
  @Override
  public void draw()
  {
  }
  
  @Override
  public void drawGUI()
  {
    Text.draw_test();
    if (Settings.FPS_ON) Text.draw_text("" + (int) Main.fps, new Point(700, 540), 50);
  }
  
  @Override
  public String toString()
  {
    return "Player [pos=" + pos + ", cam=" + cam + "]";
  }
}
