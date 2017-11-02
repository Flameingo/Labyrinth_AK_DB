package main;

import static org.lwjgl.opengl.GL11.*;
import models3D.*;
import params.*;

public class Spawner extends Objekt
{
  
  public static float wandFeld = 5.70f;
  
  /**
   * created once at the start of the game and places all objects that should be in the game at the start.
   */
  public Spawner()
  {
    Labyrinth.addObject(new Player()); // Wird benoetigt, um die Kamera innerhalb des Spiels zu steuern
    
    // Hier werden die Objekte ins Spiel gesetzt:
    Labyrinth.addObject(new Turm(0,0,0));
    Labyrinth.addObject(new PrototypWand(0,0,0,0,0,0));
    Labyrinth.addObject(new  TuerWand(-wandFeld/2,0,0,0,0,0));
    Labyrinth.addObject(new BeschaedigteWandRANDOM(-wandFeld,0,0,0,0,0));
    Labyrinth.addObject(new PrototypWand(-wandFeld-4.7f,-1.1f,0,-90,0,0,90));
    
    
    // Definition der Lichtquellen:
    glEnable(GL_LIGHT0);
    glLightfv(GL_LIGHT0, GL_AMBIENT, new float[] { .2f, .2f, .2f, 1 });
    glLightfv(GL_LIGHT0, GL_DIFFUSE, new float[] { 1, 1, 1, 1 });
    glLightfv(GL_LIGHT0, GL_SPECULAR, new float[] { 1, 1, 1, 1 });
    glLightfv(GL_LIGHT0, GL_POSITION, new float[] { 1, 1, 1, 0 });
  }
  
  @Override
  public void step()
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
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }
  
}
