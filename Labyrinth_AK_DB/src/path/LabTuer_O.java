package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.BeschaedigteWandRANDOM;
import models3D.TWD;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabTuer_O extends Objekt
{
  protected Objekt [] waende = new Objekt[1];
  
  /**
   *  Zwei Punkte spannen ein Quadrat auf
   * @param x
   * @param y
   * @param z
   * @param x2
   * @param y2
   * @param z2
   */
  public LabTuer_O(float x, float y, float x2, float y2, float hoehe)
  {
    
      float yy2 = y2 - WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.    
      waende [0] = new TWD((x+x2)/2+0.13f, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
    
        
  }
  
  public LabTuer_O(Level lev, float hoehe)
  {
	  this(lev.x1,lev.y1,lev.x2,lev.y2, hoehe);
  }
  public LabTuer_O(Level lev)
  {
	  this(lev.x1,lev.y1,lev.x2,lev.y2, 2);
  }
  public LabTuer_O(Etage e, Level lev)
  {
    this(e, lev.x1, lev.y1, lev.x2, lev.y2);
    
  }
  
  public LabTuer_O(Etage e,float x, float y, float x2, float y2)
  {
	  float yy2 = y2 - WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.    
      waende [0] = new TWD((x+x2)/2+0.13f, yy2, boden+2.1f*e.wert(), 0,0,0, Math.abs(x2-x), 2);
  }
  
//  public LabWeg_O(String kind,float x, float y, float x2, float y2, float hoehe, boolean gedreht) //funktioniert noch nicht richtig !!
//  {
//    float yy2 = y2 - WandBlock.wdbreite/2;//Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
//    float xx2 = x2 - WandBlock.wdbreite/2;
//    
//    if (!gedreht && kind == "BeschaedigteWandRANDOM"||kind == "BWR")
//    {
//    
//    waende [0] = new BeschaedigteWandRANDOM((x+x2)/2, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
//    }
//    if (!gedreht && kind != "BWR" && kind !="BeschaedigteWandRANDOM")
//    {
//    waende [0] = new Wand((x+x2)/2, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe); 
//    }
//    if (gedreht && kind == "BeschaedigteWandRANDOM" || kind == "BWR")
//    {
//      
//      waende[0] = new BeschaedigteWandRANDOM(xx2,(y+y2)/2+0.13f,boden,90,0,0,Math.abs(y2-y), hoehe);
//    }
//    if(gedreht && kind != "BeschaedigteWandRANDOM" && kind != "BWR")
//    {
//      
//      waende[0] = new Wand(xx2,(y+y2)/2+0.13f,boden,90,0,0,Math.abs(y2-y), hoehe);
//    }
//  }
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void draw()
  {
    // TODO Auto-generated method stub
    Material.BACKSTEIN.use();
    for (Objekt wand : waende){
      wand.draw();
    }
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
