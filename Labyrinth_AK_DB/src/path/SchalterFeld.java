package path;

import basics.Level;
import main.Objekt;
import models3D.Schalter;

public class SchalterFeld extends Objekt
{
  
  float                    x;
  float                    y;
  protected Schalter[] schaldr = new Schalter[1];
  
  public SchalterFeld(String befehl, float x, float y, float x2, float y2)
  {
	
    this.x = (x2 + x)/2;
    this.y = (y2+y)/2;
    schaldr[0] = new Schalter(befehl,(x2 + x) / 2, (y2 + y) / 2, 0, 0, 0, 0);
  }
  
  public SchalterFeld(String befehl, Level lev)
  {
    this(befehl,lev.x1,lev.y1, lev.x2, lev.y2);
    this.a = lev.x2;
	this.b = lev.y1;
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
