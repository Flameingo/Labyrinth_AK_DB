package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabWeg_r_l extends Lab
{
  
  /**
   * Zwei Punkte (x,y) und (x2,y2) spannen ein Quadrat auf. Von (x,y) bis (x,y2) und von (x2, y) bis (x2,y2) verlaufen
   * die Wandstuecke.
   * 
   * @param x
   * @param y
   * @param x2
   * @param y2
   * @param hoehe
   * @param alpha
   *          bestimmt die Drehung um die z-Achse (Hoehe)
   */
  public LabWeg_r_l(float x, float y, float x2, float y2, float hoehe)
  {
    
    float yy = y + WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    float yy2 = y2 - WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    
    add(new Wand((x + x2) / 2 + 0.13f, yy, boden, 0, 0, 0, Math.abs(x2 - x), hoehe));
    add(new Wand((x + x2) / 2 + 0.13f, yy2, boden, 0, 0, 0, Math.abs(x2 - x), hoehe));
    hitbox.add("U");
    hitbox.add("O");
  }
  
  public LabWeg_r_l(Level lev, float hoehe)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabWeg_r_l(Level lev)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, 2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabWeg_r_l(Etage e, Level lev)
  {
    this(e, lev.x1, lev.y1, lev.x2, lev.y2);
    this.a = lev.x2;
    this.b = lev.y1;
    
  }
  
  public LabWeg_r_l(Etage e, float x, float y, float x2, float y2)
  {
    this.e = e;
    
    float yy = y + WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    float yy2 = y2 - WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    
    add(new Wand((x + x2) / 2 + 0.13f, yy, boden + 2.1f * e.wert(), 0, 0, 0, Math.abs(x2 - x), 2));
    add(new Wand((x + x2) / 2 + 0.13f, yy2, boden + 2.1f * e.wert(), 0, 0, 0, Math.abs(x2 - x), 2));
    hitbox.add("O");
    hitbox.add("U");
  }
}
