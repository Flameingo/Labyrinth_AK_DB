package path;

import main.*;
import params.Material;

public class Lab extends Objekt
{
  protected Objekt[] waende = new Objekt[3];
  
  public void step()
  {
    for (Objekt wand : waende)
      if (wand != null) wand.step();
  }
  
  public void collision()
  {
    for (Objekt wand : waende)
      if (wand != null) wand.collision();
  }
  
  public void draw()
  {
    Material.BACKSTEIN.use();
    for (Objekt wand : waende)
      if (wand != null) wand.draw();
  }
  
  public void drawGUI()
  {
    for (Objekt wand : waende)
      if (wand != null) wand.drawGUI();
  }
  
}
