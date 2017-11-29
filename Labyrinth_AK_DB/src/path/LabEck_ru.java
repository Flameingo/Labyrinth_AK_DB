package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabEck_ru extends Objekt
{
  protected Objekt [] waende = new Objekt[2];
  
/**
 * Zwei Punkte (x,y) und (x2,y2) spannen ein Quadrat auf. Von 
 * (x,y) bis (x,y2) und von (x2, y) bis (x2,y2) verlaufen die Wandstuecke.
 * @param x
 * @param y
 * @param x2
 * @param y2
 * @param hoehe
 * @param bogen Bogen im Eck oder nicht
 */
  public LabEck_ru(float x, float y, float x2, float y2, float hoehe, boolean bogen)
  {
	  waende = new Objekt[3];
	  
	  if(bogen == true)
		  waende [2] = new Wand ("E",x+1.75f,y2-1.75f,boden,90,0,0,90,hoehe);
		
	  if (bogen == false)
		  waende [2] = new Wand ("E",x,y2,boden,270,0,0,90,hoehe);
    
    float yy = y + WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    float yy2 = y2 - WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    
   
    waende [0] = new Wand((x+x2)/2+0.13f, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
   
     float xx = x + WandBlock.wdbreite/2;
     float xx2 = x2 - WandBlock.wdbreite/2;
     
     waende[1] = new Wand(xx, (y+y2)/2+0.13f, boden, 90,0,0,Math.abs(y2-y), hoehe);
       
  }
  
  
  public LabEck_ru(Level lev, float hoehe, boolean bogen)
  {
	  this(lev.x1,lev.y1,lev.x2,lev.y2, hoehe, bogen);
  }
  public LabEck_ru(Level lev, boolean bogen)
  {
	  this(lev.x1,lev.y1,lev.x2,lev.y2, 2, bogen);
  }
  public LabEck_ru(Level lev)
  {
	  this(lev.x1,lev.y1,lev.x2,lev.y2,2);
  }
  
  public LabEck_ru(float x, float y, float x2, float y2, float hoehe)
  {
	
    float yy = y + WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    float yy2 = y2 - WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    
   
    waende [0] = new Wand((x+x2)/2+0.13f, yy2, boden, 0,0,0, Math.abs(x2-x), hoehe);
   
     float xx = x + WandBlock.wdbreite/2;
     float xx2 = x2 - WandBlock.wdbreite/2;
     
     waende[1] = new Wand(xx, (y+y2)/2+0.13f, boden, 90,0,0,Math.abs(y2-y), hoehe);
       
  }
  
  public LabEck_ru(Level lev, Etage e,boolean bogen)
  {
	  this(e,lev.x1,lev.y1,lev.x2,lev.y2,bogen);
  }
  
  public LabEck_ru(Etage e, float x, float y, float x2, float y2, boolean bogen)
  {
  waende = new Objekt[3];
	  
	  if(bogen == true)
		  waende [2] = new Wand ("E",x+1.75f,y2-1.75f,boden+2.1f*e.wert(),90,0,0,90,2);
		
	  if (bogen == false)
		  waende [2] = new Wand ("E",x,y2,boden+2.1f*e.wert(),270,0,0,90,2);
    
    float yy = y + WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    float yy2 = y2 - WandBlock.wdbreite/2; //Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
    
   
    waende [0] = new Wand((x+x2)/2+0.13f, yy2, boden+2.1f*e.wert(), 0,0,0, Math.abs(x2-x), 2);
   
     float xx = x + WandBlock.wdbreite/2;
     float xx2 = x2 - WandBlock.wdbreite/2;
     
     waende[1] = new Wand(xx, (y+y2)/2+0.13f, boden+2.1f*e.wert(), 90,0,0,Math.abs(y2-y), 2);
      
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
