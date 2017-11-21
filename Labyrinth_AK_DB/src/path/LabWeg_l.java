package path;

import basics.Point;
import main.Objekt;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabWeg_l extends Objekt
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
  public LabWeg_l(float x, float y, float x2, float y2, float hoehe,boolean gedreht)
  {
    
   
    if(!gedreht)
    {
      float yy = y + WandBlock.wdbreite/2;//Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
      waende [0] = new Wand((x+x2)/2+0.13f, yy, boden, 0,0,0, Math.abs(x2-x), hoehe);
    }
      
   
    if(gedreht)
    {
      float xx = x + WandBlock.wdbreite/2;
      waende[0] = new Wand(xx, (y+y2)/2+0.13f, boden, 90,0,0, Math.abs(y2-y), hoehe);
    }
     
    
   
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
