package models3D;

import basics.Point;
import main.*;
import params.*;

public class Turm extends Objekt
{
  private final int  hoehe  = 4;
  
  protected Objekt[] waende = new Objekt[hoehe * 4];
  Objekt             treppe;
//  Objekt             stein;
  protected float    x, y, z;
  
  public Turm(float x, float y, float z, float alpha, float beta, float gamma)
  {
    pos = new Point(x, y, z);
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
    
    for (int r = 0; r < hoehe; r++) // r Setzt mehrere Wandelemente uebereinander
    {
      for (int rota = 0; rota < 4; rota++) // Setzt 4 Wandelemente zu einem Kreis zusammen
      {
        waende[r * 4 + rota] = new WandTest(0, 1.7f, r * 1.5f, rota * 90, 0, 0, 90);
      }
    }
    
    treppe = new RundeTreppe("S", 0, 1.7f, 0, 0, 0, 0, 360, 30); // Erstellt die sich im Turminneren
    // befindende Wendelteppe sowie eine Saule
    // in deren Mitte.
    
//    stein = new Steinflaeche(0, 6, 0, 0, 0, 0);
    
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
    Material.RED_PLASTIC.use();
    for (Objekt wand : waende)
    {
      wand.draw();
    }
    treppe.draw();
//    stein.draw();
  }
  
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
