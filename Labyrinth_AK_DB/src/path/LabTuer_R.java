package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.BeschaedigteWandRANDOM;
import models3D.TWD;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabTuer_R extends Lab
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
  public LabTuer_R(float x, float y, float x2, float y2, float hoehe)
  {
    
    float xx2 = x2 - WandBlock.wdbreite / 2;
    waende[0] = new TWD(xx2, (y + y2) / 2 + 0.13f, boden, 90, 0, 0, Math.abs(y2 - y), hoehe);
    
  }
  
  public LabTuer_R(Level lev, float hoehe)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public LabTuer_R(Level lev)
  {
    this(lev.x1, lev.y1, lev.x2, lev.y2, 2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  // public LabWeg_L(String kind,float x, float y, float x2, float y2, float hoehe, boolean gedreht) //funktioniert noch
  // nicht richtig !!
  // {
  // float yy2 = y2 - WandBlock.wdbreite/2;//Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
  // float xx2 = x2 - WandBlock.wdbreite/2;
  //
  // if (!gedreht && kind == "BeschaedigteWandRANDOM"||kind == "BWR")
  // {
  //
  // waende [0] = new BeschaedigteWandRANDOM((x+x2)/2, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
  // }
  // if (!gedreht && kind != "BWR" && kind !="BeschaedigteWandRANDOM")
  // {
  // waende [0] = new Wand((x+x2)/2, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
  // }
  // if (gedreht && kind == "BeschaedigteWandRANDOM" || kind == "BWR")
  // {
  //
  // waende[0] = new BeschaedigteWandRANDOM(xx2,(y+y2)/2+0.13f,boden,90,0,0,Math.abs(y2-y), hoehe);
  // }
  // if(gedreht && kind != "BeschaedigteWandRANDOM" && kind != "BWR")
  // {
  //
  // waende[0] = new Wand(xx2,(y+y2)/2+0.13f,boden,90,0,0,Math.abs(y2-y), hoehe);
  // }
  // }
  
}
