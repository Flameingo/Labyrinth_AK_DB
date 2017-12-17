package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.BeschaedigteWandRANDOM;
import models3D.Gitter;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabGitter extends Lab
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
  public LabGitter(String angabe, float x, float y, float x2, float y2, float hoehe) // steht fuer "oben", "unten",
                                                                                     // "links", "rechts" und
                                                                                     // positioniert an just dieser
                                                                                     // Kante.
  {
    switch (angabe)
    {
    case "o":
      float yy2 = y2 - WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
      add(new Gitter((x + x2) / 2 + 0.13f, yy2, boden, 0, 0, 0, Math.abs(x2 - x), hoehe));
      hitbox.add("O");
      break;
    case "u":
      float yy = y + WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die
      // gewaehlten Grenzen ueberragt.
      add(new Gitter((x + x2) / 2 + 0.13f, yy, boden, 0, 0, 0, Math.abs(x2 - x), hoehe));
      hitbox.add("U");
      break;
    case "l":
      float xx = x + WandBlock.wdbreite / 2; // Damit der Rand der Steine nicht die Grenzen des Feldes ueberragt.
      add(new Gitter(xx, (y + y2) / 2 + 0.13f, boden, 90, 0, 0, Math.abs(y2 - y), hoehe));
      hitbox.add("L");
      break;
    case "r":
      float xx2 = x2 - WandBlock.wdbreite / 2; // Damit der Wandrand nicht die Grenzen des Feldes ueberragt.
      add(new Gitter(xx2, (y + y2) / 2 + 0.13f, boden, 90, 0, 0, Math.abs(y2 - y), hoehe));
      hitbox.add("R");
      break;
    default:
      break;
    }
  }
  
  public LabGitter(String angabe, Level lev, float hoehe)
  {
    this(angabe, lev.x1, lev.y1, lev.x2, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabGitter(String angabe, Level lev)
  {
    this(angabe, lev.x1, lev.y1, lev.x2, lev.y2, 2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  // public LabGitter(Etage e, Level lev)
  // {
  // this(e, lev.x1, lev.y1, lev.x2, lev.y2);
  // this.a = lev.x2;
  // this.b = lev.y1;
  //
  // }
  //
  // public LabGitter(Etage e, float x, float y, float x2, float y2)
  // {
  // float yy2 = y2 - WandBlock.wdbreite / 2; // Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
  // add(new Gitter((x + x2) / 2 + 0.13f, yy2, boden + 2.1f * e.wert(), 0, 0, 0, Math.abs(x2 - x), 2));
  // }
  
}
