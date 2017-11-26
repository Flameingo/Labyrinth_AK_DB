package path;

import basics.Point;
import main.Objekt;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabWeg_o_u extends Objekt
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
 * @param alpha bestimmt die Drehung um die z-Achse (Hoehe)
 */
  public LabWeg_o_u(float x, float y, float x2, float y2, float hoehe)
  {
	  
	    
 
     float xx = x + WandBlock.wdbreite/2;
     float xx2 = x2 - WandBlock.wdbreite/2;
     
     waende[0] = new Wand(xx, (y+y2)/2+0.13f, boden, 90,0,0,Math.abs(y2-y), hoehe);
     waende[1] = new Wand(xx2, (y+y2)/2+0.13f, boden ,90,0,0,Math.abs(y2-y), hoehe);
   
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
