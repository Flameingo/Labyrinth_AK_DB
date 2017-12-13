package models3D;

import main.Objekt;

public class DisplayList_Objekt
{
  private Objekt  objekt;
  private boolean washidden = true;
  
  DisplayList_Objekt(Objekt obj)
  {
    objekt = obj;
  }
  
  public boolean hasChanged()
  {
    if (washidden == objekt.hidden) return false;
    setWasHiddenRight();
    return true;
  }
  
  public void setWasHiddenRight()
  {
    washidden = objekt.hidden;
  }
  
  public void step()
  {
    objekt.step();
  }
  
  public void collision()
  {
    if (!objekt.hidden) objekt.collision();
  }
  
  public void draw()
  {
    if (!objekt.hidden) objekt.draw();
  }
  
  public void drawGUI()
  {
    if (!objekt.hidden) objekt.drawGUI();
  }
}
