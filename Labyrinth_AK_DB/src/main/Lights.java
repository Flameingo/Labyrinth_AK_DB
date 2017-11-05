package main;

import static org.lwjgl.opengl.GL11.*;

public class Lights
{
  static void setLights()
  {
    glLightfv(GL_LIGHT0, GL_POSITION, new float[] { 1, 1, 1, 0 });
  }
  
  static void init()
  {
    // Definition der Lichtquellen:
    glEnable(GL_LIGHT0);
    glLightfv(GL_LIGHT0, GL_AMBIENT, new float[] { 1, 1, 1, 1 });
    glLightfv(GL_LIGHT0, GL_DIFFUSE, new float[] { 1, 1, 1, 1 });
    glLightfv(GL_LIGHT0, GL_SPECULAR, new float[] { 1, 1, 1, 1 });
  }
}
