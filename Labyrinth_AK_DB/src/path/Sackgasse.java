package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class Sackgasse extends Objekt
{
  protected Objekt [] waende = new Objekt[3];
  
/**
 * Zwei Punkte (x,y) und (x2,y2) spannen ein Quadrat auf. Von 
 * (x,y) bis (x,y2) und von (x2, y) bis (x2,y2) verlaufen die Wandstuecke.
 * @param x
 * @param y
 * @param x2
 * @param y2
 * @param hoehe
 * @param alpha bestimmt die Drehung um die z-Achse (Hoehe)
 * @param stase "rechts", "links", "oben", "unten" oder die jeweiligen Anfangsbuchstaben um die Seite der Oeffnung zu bestimmen (bezogen auf x,y-Ebene)
 */
  public Sackgasse(float x, float y, float x2, float y2, float hoehe, String stase)
  {
	  float yy = y + WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
	  float yy2 = y2 - WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
	  float xx = x + WandBlock.wdbreite/2;
	  float xx2 = x2 - WandBlock.wdbreite/2;
	    
    if(stase == "rechts" || stase == "r")
    {
        
    	waende [0] = new Wand((x+x2)/2+0.13f, yy, boden, 0,0,0, Math.abs(x2-x), hoehe);
    	waende [1] = new Wand((x+x2)/2+0.13f, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
    	waende [2] = new Wand(xx, (y+y2)/2+0.13f, boden, 90,0,0,Math.abs(y2-y), hoehe);
    }
   if(stase == "oben" || stase == "o")
   {
         
	   waende[0] = new Wand(xx, (y+y2)/2+0.13f, boden, 90,0,0,Math.abs(y2-y), hoehe);
	   waende[1] = new Wand(xx2, (y+y2)/2+0.13f, boden ,90,0,0,Math.abs(y2-y), hoehe);
	   waende[2] = new Wand((x+x2)/2+0.13f, yy, boden, 0,0,0, Math.abs(x2-x), hoehe);
   }
   if(stase == "links" || stase =="l")
   {
	   waende [0] = new Wand((x+x2)/2+0.13f, yy, boden, 0,0,0, Math.abs(x2-x), hoehe);
	   waende [1] = new Wand((x+x2)/2+0.13f, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
	   waende [2] = new Wand(xx2, (y+y2)/2+0.13f, boden ,90,0,0,Math.abs(y2-y), hoehe);
   }
   if(stase == "unten" || stase == "u")
   {
	   waende[0] = new Wand(xx, (y+y2)/2+0.13f, boden, 90,0,0,Math.abs(y2-y), hoehe);
	   waende[1] = new Wand(xx2, (y+y2)/2+0.13f, boden ,90,0,0,Math.abs(y2-y), hoehe);
	   waende[2] = new Wand((x+x2)/2+0.13f, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
   }
  }
  
  public Sackgasse(Level lev, float hoehe,String stase)
  {
	  this(lev.x1,lev.y1,lev.x2,lev.y2, hoehe,stase);
  }
  public Sackgasse(Level lev,String stase)
  {
	  this(lev.x1,lev.y1,lev.x2,lev.y2, 2,stase);
  }
  
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
