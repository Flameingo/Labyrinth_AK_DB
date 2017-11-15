package models3D;

import main.Objekt;
import params.Material;

public class AbschnittB extends Objekt
{
  protected Objekt [] waende = new Objekt[1];
  
  public AbschnittB()
  {
    
//    for(int i = 0; i < 3; i++)
//    {
//    waende[i] = new PrototypWand(i*wandFeld/2,0,0,0,0,0);
//    waende[i+3] = new BeschaedigteWandRANDOM(-wandFeld/2-0.1f,i*-wandFeld/2+0.1f,0,90,0,0);
//    }
//    for (int q = 0; q < 2; q++)
//    {
//      waende [q+6] = new PrototypWand ((q+1)*wandFeld/2-1.35f,-1.5f,0,0,0,0);
//      waende [q+8] = new PrototypWand (-wandFeld/2+1.4f,q*-wandFeld/2-1.4f,0,90,0,0);
//    }
    waende[0] = new WandTest(0,0,0,0,0,0,7f,7f);
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
    Material.BACKSTEIN.use();
    for (Objekt wand : waende)
    {
      wand.draw();
    }
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
}
