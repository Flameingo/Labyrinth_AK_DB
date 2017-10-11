package main;

import basics.Point;
import static org.lwjgl.glfw.GLFW.*;

public class Player extends Objekt
{
  // get settings
  private final float spdLR   = Settings.PlayerRotationLeftRight;
  private final float spdUD   = Settings.PlayerRotationLeftRight;
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
        camRotate(1, 0);
        break;
      case GLFW_KEY_RIGHT:
        camRotate(-1, 0);
        break;
      case GLFW_KEY_UP:
        camRotate(0, 1);
        break;
      case GLFW_KEY_DOWN:
        camRotate(0, -1);
        break;
      default:
        break;
      }
    }
    Point lookat = Point.add(pos, cam);
    Labyrinth.setView(pos, lookat);
  }
  
  private void camRotate(int leftright, int updown)
  {
    // rotates the Point cam with the given angles
    // Left - Right:
    float arc = spdLR * leftright;
    float temp = (float) (cam.y * Math.cos(arc) + cam.x * Math.sin(arc));
    cam.x = (float) (cam.y * -Math.sin(arc) + cam.x * Math.cos(arc));
    cam.y = temp;
    // Up - Down:
    arc = spdUD * updown;
    float xyLength = (float) Math.sqrt(cam.x * cam.x + cam.y * cam.y);
    temp = (float) (cam.z * Math.cos(arc) + xyLength * Math.sin(arc));
    float ratio = cam.x / cam.y;
    cam.x = (float) (cam.x * Math.cos(arc) - cam.z * Math.sin(arc) * ratio);
    cam.y = (float) (cam.y * Math.cos(arc) - cam.z * Math.sin(arc) / ratio);
    cam.z = temp;
    
    cam.refresh2();
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
