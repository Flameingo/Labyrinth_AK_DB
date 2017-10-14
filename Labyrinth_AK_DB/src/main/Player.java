package main;

import basics.Point;
import static org.lwjgl.glfw.GLFW.*;

public class Player extends Objekt
{
  // This is the player object that controls movement
  
  // get settings
  private final float spdLR   = Settings.PlayerRotationLeftRight;
  private final float spdUD   = Settings.PlayerRotationUpDown;
  private final float spdMOV  = Settings.PlayerMovementSpeed;
  private final float spdSIDE = Settings.PlayerSideStepSpeed;
  
  // Position im Spiel
  Point               pos     = new Point(5, 0, 0);
  // Kameraausrichtung
  Point               cam     = new Point(-1, 0, 0);
  
  @Override
  public void step()
  {
    for (int i = 0; i < Labyrinth.keys.length; i++)
    {
      // bewegungen anhand WASD und arrow-keys einleiten.
      switch (Labyrinth.keys[i])
      {
      case GLFW_KEY_W:
        pos.add(Point.mult(cam, spdMOV));
        break;
      case GLFW_KEY_S:
        pos.add(Point.mult(cam, -spdMOV));
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
    // Kameraposition in Klasse "Labyrinth" aktualisieren.
    Point lookat = Point.add(pos, cam);
    Labyrinth.setView(pos, lookat);
    
    if (Settings.DrawPlayerPOS) System.out.println(Labyrinth.findInstance(new Player()));
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
      float tempXY = (float) (Math.signum(cam.y) * (xyLength * Math.cos(updown) - cam.z * Math.sin(updown)));
      cam.x = (float) (tempXY * Math.sin(arc));
      cam.y = (float) (tempXY * Math.cos(arc));
      cam.z = tempZ;
    }
    // fix rounding errors
    cam.normalize();
  }
  
  @Override
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void draw()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public String toString()
  {
    return "Player [pos=" + pos + ", cam=" + cam + "]";
  }
}
