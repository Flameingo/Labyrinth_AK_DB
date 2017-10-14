package main;

import models3D.BeschaedigteWand;
import models3D.Testfigur;
import models3D.WandBlock;
import params.*;

public class Spawner extends Objekt
{
  // created once at the start of the game and places all objects that should be
  // in the game at the start.
  /** Alle aufgeführten Objekte werden momentan zu Beginn des Programms aufgerufen und erstellt */
  public Spawner()
  {
    // Labyrinth.addObject(new Testfigur());
    Labyrinth.addObject(new Player());
    Labyrinth.addObject(new WandBlock(0.1f));
    Labyrinth.addObject(new BeschaedigteWand(-2.86f,0,0,0,0,0));
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
