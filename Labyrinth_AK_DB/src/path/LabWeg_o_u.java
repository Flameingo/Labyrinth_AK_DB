package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabWeg_o_u extends Lab
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
  public LabWeg_o_u(float x, float y, float x2, float y2, float hoehe)
  {
    
    float xx = x + WandBlock.wdbreite / 2;
    float xx2 = x2 - WandBlock.wdbreite / 2;
    
    add(new Wand(xx, (y + y2) / 2 + 0.13f, boden, 90, 0, 0, Math.abs(y2 - y), hoehe));
    add(new Wand(xx2, (y + y2) / 2 + 0.13f, boden, 90, 0, 0, Math.abs(y2 - y), hoehe));
    hitbox.add("L");
    hitbox.add("R");
  }
  
  public LabWeg_o_u(Level lev, float hoehe)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabWeg_o_u(Level lev)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, 2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabWeg_o_u(Etage e, Level lev)
  {
    this(e, lev.x1, lev.y1, lev.x2, lev.y2);
    this.a = lev.x2;
    this.b = lev.y1;
    
  }
  
  public LabWeg_o_u(Etage e, float x, float y, float x2, float y2)
  {
    
    float xx = x + WandBlock.wdbreite / 2;
    float xx2 = x2 - WandBlock.wdbreite / 2;
    
    add(new Wand(xx, (y + y2) / 2 + 0.13f, boden + 2.1f * e.wert(), 90, 0, 0, Math.abs(y2 - y), 2));
    add(new Wand(xx2, (y + y2) / 2 + 0.13f, boden + 2.1f * e.wert(), 90, 0, 0, Math.abs(y2 - y), 2));
    hitbox.add("L");
    hitbox.add("R");
  }
  
}
