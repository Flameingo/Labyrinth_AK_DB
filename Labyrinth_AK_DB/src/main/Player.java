package main;

import basics.Point;

public class Player extends Objekt
{
  
  // Position im Spiel
  Point pos = new Point(5, 0, 0);
  // Kameraausrichtung
  Point cam = new Point(-1, 0, 0);
  
  @Override
  public void step()
  {
    Point lookat = Point.add(pos, cam);
    Labyrinth.setView(pos, lookat);
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
