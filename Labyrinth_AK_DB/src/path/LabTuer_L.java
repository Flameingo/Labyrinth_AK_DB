package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.TWD;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabTuer_L extends Lab
{
  
  /**
   * Zwei Punkte spannen ein Quadrat auf
   * 
   * @param x
   * @param y
   * @param z
   * @param x2
   * @param y2
   * @param z2
   */
  public LabTuer_L(float x, float y, float x2, float y2, float hoehe)
  {
    
    float xx = x + WandBlock.wdbreite / 2;
    add(new TWD(xx, (y + y2) / 2 + 0.13f, boden, 90, 0, 0, Math.abs(y2 - y), hoehe));
    
  }
  
  public LabTuer_L(Level lev, float hoehe)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabTuer_L(Level lev)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, 2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
}
