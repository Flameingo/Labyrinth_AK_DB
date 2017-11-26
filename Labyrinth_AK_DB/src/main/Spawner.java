package main;

import static org.lwjgl.opengl.GL11.*;
import models3D.*;
import params.*;
import path.LabEck_lo;
import path.LabEck_lu;
import path.LabEck_ro;
import path.LabEck_ru;
import path.LabWeg_O;
import path.LabWeg_R;
import path.LabWeg_U;
import path.LabWeg_L;
import path.LabWeg_r_l;
import path.Sackgasse;

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
//    Labyrinth.addObject(new LabEck_ru(0,0,3,3,2,true));
//    Labyrinth.addObject(new LabEck_lu(3,0,6,3,2,true));
//    Labyrinth.addObject(new LabEck_ro(0,-3,3,0,2,true));
//    Labyrinth.addObject(new LabEck_lo(3,-3,6,0,2, true));
    Labyrinth.addObject(new LabWeg_R(0,0,3,3,2));
    Labyrinth.addObject(new LabWeg_U(0,0,3,3,2));

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
