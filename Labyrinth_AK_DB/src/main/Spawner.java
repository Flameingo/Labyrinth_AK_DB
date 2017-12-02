package main;

import static org.lwjgl.opengl.GL11.*;

import basics.Level;
import models3D.*;
import params.*;
import path.*;
import section.AbschnittB;
import section.TurmExtra;



public class Spawner extends Objekt
{
  public static boolean makeStatic = false;
  
  
  /**
   * created once at the start of the game and places all objects that should be in the game at the start.
   */
  public Spawner()
  {

	  
   Labyrinth.addObject(new Player()); // Wird benoetigt, um die Kamera innerhalb des Spiels zu steuern
    
    // Hier werden die Objekte ins Spiel gesetzt:
    
    makeStatic = true;
    Labyrinth.addObject(new Boden());
   
    Labyrinth.addObject(new SchalterFeld(0,0,5,5));

   
  
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
