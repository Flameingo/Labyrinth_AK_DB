package path;

import basics.Level;
import main.Objekt;
import models3D.Tuer;
import params.Material;

public class Tuer_U extends Lab
{
  
  public Tuer_U(String name, float x, float y, float z)
  {
    addMoving(new Tuer(name, x, y, z, 0, 0, 0));
  }
  
  public Tuer_U(String name, Level lev)
  {
    this(name, lev.x1 + 0.4f, lev.y1 + 0.05f, 0);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
}
