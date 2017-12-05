package path;

import basics.Level;
import main.Objekt;
import models3D.Schalter;

public class SchalterFeld extends Objekt
{
  
  float                    x;
  float                    y;
  public static Schalter[] schaldr = new Schalter[1];
  
  public SchalterFeld(float x, float y, float x2, float y2)
  {
    this.x = x2 - x;
    this.y = y2 - y;
    schaldr[0] = new Schalter((x2 - x) / 2, (y2 - y) / 2, 0, 0, 0, 0);
  }
  
  public SchalterFeld(Level lev)
  {
    this(lev.x1, Math.abs(lev.y1), lev.x2, lev.y2);
  }
  
  public void sfschalten()
  {
    SchalterFeld.schaldr[0].schalten();
  }
  
  public void step()
  {
    for (Objekt sch : schaldr)
    {
      sch.step();
    }
  }
  
  @Override
  public void collision()
  {
    for (Objekt sch : schaldr)
    {
      sch.collision();
    }
  }
  
  @Override
  public void draw()
  {
    for (Objekt sch : schaldr)
    {
      sch.draw();
    }
  }
  
  @Override
  public void drawGUI()
  {
    for (Objekt sch : schaldr)
    {
      sch.drawGUI();
    }
  }
  
}
