package main;

import models3D.BeschaedigteWand;
import models3D.BeschaedigteWandRANDOM;
import models3D.PrototypWand;
import models3D.RundeTreppe;
import models3D.RundeTreppe2;
import models3D.RundeTreppe3;
import models3D.TuerWand;
import models3D.Turm;
import models3D.Testfigur;
import models3D.TestfigurAlex;
import models3D.Treppe;
import models3D.WandBlock;
import models3D.WandMitTuer;
import models3D.WandTest;
import models3D.Tuer;
import params.*;

public class Spawner extends Objekt
{
  
  public static float wandFeld = 5.70f;
  
  
  // created once at the start of the game and places all objects that should be
  // in the game at the start.
  /** Alle aufgeführten Objekte werden momentan zu Beginn des Programms aufgerufen und erstellt */
  public Spawner()
  {
//      Labyrinth.addObject(new Testfigur());
    
    Labyrinth.addObject(new Player()); //Wird benoetigt, um die Kamera innerhalb des Spiels zu steuern
    
    
    Labyrinth.addObject(new RundeTreppe3(0,0,0,0,0,0,180,10));
//    
//    Labyrinth.addObject(new Testfigur());
////<<<<<<< HEAD
    
 

//      Labyrinth.addObject (new Turm(0, 0, 0));

//=======
    //Labyrinth.addObject(new WandBlock());
//>>>>>>> branch 'master' of https://github.com/Flameingo/Labyrinth_AK_DB
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
