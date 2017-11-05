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
    
    Labyrinth.addObject(new Turm(3,2,1,-2,3,4));
    
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
