package main;

import static org.lwjgl.opengl.GL11.*;
import models3D.*;
import params.*;

public class Spawner extends Objekt
{
  public static boolean makeStatic = false;
  
<<<<<<< HEAD


  

=======
  /**
   * 5.7f, entspricht der Laenge von zwei WandBloecken
   */
  
  public static float   wandFeld   = 5.70f;
>>>>>>> branch 'master' of https://github.com/Flameingo/Labyrinth_AK_DB
  
  /**
   * created once at the start of the game and places all objects that should be in the game at the start.
   */
  public Spawner()
  {
    Labyrinth.addObject(new Player()); // Wird benoetigt, um die Kamera innerhalb des Spiels zu steuern
    // Hier werden die Objekte ins Spiel gesetzt:
    
    makeStatic = true;
    Labyrinth.addObject(new Boden());
    Labyrinth.addObject(new AbschnittB());
    // Labyrinth.addObject(new TurmExtra());
    
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
