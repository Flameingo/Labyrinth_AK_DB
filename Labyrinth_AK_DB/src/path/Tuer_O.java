package path;

import basics.Level;
import main.Objekt;
import models3D.Tuer;
import params.Material;

public class Tuer_O extends Lab
{
  
  public Tuer_O(String name, float x, float y, float z)
  {
    addMoving(new Tuer(name, x, y, z, 180, 0, 0));
  }
  
  public Tuer_O(String name, Level lev)
  {
    this(name, lev.x2 - 0.35f, lev.y2 - 0.05f, 0);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
}
