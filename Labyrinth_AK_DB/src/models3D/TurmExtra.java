package models3D;

import main.Labyrinth;
import main.Objekt;
import main.Spawner;

public class TurmExtra extends Objekt
{

  public TurmExtra ()
  {
    
    Labyrinth.addObject(new Turm(0,0,0,0,0,0));
    
    
    Labyrinth.addObject(new PrototypWand(0,0,0,0,0,0));
    Labyrinth.addObject(new PrototypWand(0,3.4f,0,0,0,0));
    Labyrinth.addObject(new PrototypWand(0,0,1.5f,0,0,0));
    Labyrinth.addObject(new PrototypWand(0,3.4f,1.5f,0,0,0));
    
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld/2,0,0,0,0,0));
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld,0,0,0,0,0));
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld/2,3.4f,0,0,0,0));
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld,3.4f,0,0,0,0));
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld/2,0,1.5f,0,0,0));
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld,0,1.5f,0,0,0));
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld/2,3.4f,1.5f,0,0,0));
    Labyrinth.addObject(new PrototypWand(-Spawner.wandFeld,3.4f,1.5f,0,0,0));
    
    Labyrinth.addObject(new Zinne(0,0,3,0,0,0));
    Labyrinth.addObject(new Zinne(0,3.4f,3,0,0,0));
    Labyrinth.addObject(new Zinne(-Spawner.wandFeld/2,0,3,0,0,0));
    Labyrinth.addObject(new Zinne(-Spawner.wandFeld/2,3.4f,3,0,0,0));
    Labyrinth.addObject(new Zinne(-Spawner.wandFeld,0,3,0,0,0));
    Labyrinth.addObject(new Zinne(-Spawner.wandFeld,3.4f,3,0,0,0));
  }
  
  
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
    
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
