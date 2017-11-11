package models3D;

import main.Objekt;

public class AbschnittB extends Objekt
{
  protected Objekt [] waende = new Objekt[10];
  
  public AbschnittB()
  {
    for(int i = 0; i < 3; i++)
    {
    waende[i] = new WandTest(i*wandFeld/2,0,0,0,0,0);
    waende[i+3] = new BeschaedigteWandRANDOM(-wandFeld/2-0.1f,i*-wandFeld/2+0.1f,0,90,0,0);
    }
    for (int q = 0; q < 2; q++)
    {
      waende [q+6] = new WandTest ((q+1)*wandFeld/2-1.35f,-1.5f,0,0,0,0);
      waende [q+8] = new WandTest (-wandFeld/2+1.4f,q*-wandFeld/2-1.4f,0,90,0,0);
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
