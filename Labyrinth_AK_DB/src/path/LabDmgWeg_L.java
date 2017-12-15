package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.BeschaedigteWandRANDOM;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabDmgWeg_L extends Lab
{
  
  /**
   * Zwei Punkte spannen ein Quadrat auf. An der linken Kante dieses Quadrates (Richtung der negativen x - Achse).
   * 
   * @param x
   * @param y
   * @param z
   * @param x2
   * @param y2
   * @param z2
   */
  public LabDmgWeg_L(float x, float y, float x2, float y2, float hoehe)
  {
    
    float xx = x + WandBlock.wdbreite / 2;
    add(new BeschaedigteWandRANDOM(xx, (y + y2) / 2 + 0.13f, boden, 90, 0, 0, Math.abs(y2 - y), hoehe));
    
  }
  
  public LabDmgWeg_L(Level lev, float hoehe)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabDmgWeg_L(Level lev)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, 2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabDmgWeg_L(Etage e, Level lev)
  {
    this(e, lev.x1, lev.y1, lev.x2, lev.y2);
    this.a = lev.x2;
    this.b = lev.y1;
    
  }
  
  public LabDmgWeg_L(Etage e, float x, float y, float x2, float y2)
  {
    float xx = x + WandBlock.wdbreite / 2;
    add(new BeschaedigteWandRANDOM(xx, (y + y2) / 2 + 0.13f, boden + 2.1f * e.wert(), 90, 0, 0, Math.abs(y2 - y), 2));
  }
}
