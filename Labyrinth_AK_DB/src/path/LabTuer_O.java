package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.BeschaedigteWandRANDOM;
import models3D.TWD;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabTuer_O extends Lab
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
  public LabTuer_O(float x, float y, float x2, float y2, float hoehe)
  {
    
    float yy2 = y2 - WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    add(new TWD((x + x2) / 2 + 0.13f, yy2, boden, 0, 0, 0, Math.abs(x2 - x), hoehe));
    hitbox.add("Rahmen_O");
  }
  
  public LabTuer_O(Level lev, float hoehe)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabTuer_O(Level lev)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, 2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabTuer_O(Etage e, Level lev)
  {
    this(e, lev.x1, lev.y1, lev.x2, lev.y2);
    this.a = lev.x2;
    this.b = lev.y1;
    
  }
  
  public LabTuer_O(Etage e, float x, float y, float x2, float y2)
  {

    this.e = e;
    float yy2 = y2 - WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    add(new TWD((x + x2) / 2 + 0.13f, yy2, boden + 2.1f * e.wert(), 0, 0, 0, Math.abs(x2 - x), 2));
    hitbox.add("Rahmen_O");
  }
  
}
