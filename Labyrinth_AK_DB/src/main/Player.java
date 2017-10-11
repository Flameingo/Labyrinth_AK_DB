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
        break;
      case GLFW_KEY_D:
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
  }
  
  private void camRotate(float leftright, float updown)
  {
    // rotates the Point "cam" with the given angles
    // Left - Right:
    float temp = (float) (cam.y * Math.cos(leftright) + cam.x * Math.sin(leftright));
    cam.x = (float) (cam.y * -Math.sin(leftright) + cam.x * Math.cos(leftright));
    cam.y = temp;
    // Up - Down:
    float xyLength = Math.abs(cam.length("xy"));
    temp = (float) (cam.z * Math.cos(updown) + xyLength * Math.sin(updown));
    float arc = (float) Math.atan(cam.x / cam.y);
    cam.x = (float) (cam.x * Math.cos(updown) - cam.z * Math.sin(updown) * Math.sin(arc));
    cam.y = (float) (cam.y * Math.cos(updown) - cam.z * Math.sin(updown) * Math.cos(arc));
    cam.z = temp;
    
    // fix rounding errors
    cam.normalize();
    
    System.out.println("Vert: " + cam.z);
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
  
}
