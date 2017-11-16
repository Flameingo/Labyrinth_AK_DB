package models3D;

import basics.Point;
import main.Objekt;
import params.Shape;

public class Turm extends Objekt
{
  // private final int hoehe = 4;
  
  protected Objekt[] waende  = new Objekt[16];
  protected Objekt[] bonus   = new Objekt[1];
  protected Objekt[] zinnen  = new Objekt[4];
  Objekt             treppe;
  
  protected Shape    myShape = new Shape();
  
  /**
   * 
   * @param T
   *          Der Aufruf "T" fuer diesen String erschafft eine zweite Tuer. Wird ein anderer Aufruf fuer diesen String
   *          getaetigt, wird ein isolierter Turm erschaffen. Koordinaten:
   * @param x
   * @param y
   * @param z
   * 
   * @param alpha
   *          Drehung z - Achse
   * @param beta
   *          Drehung y - Achse
   * @param gamma
   *          Drehung x - Achse
   */
  public Turm(String T, float x, float y, float z, float alpha, float beta, float gamma)
  {
    pos = new Point(x, y, z);
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
    
    if (T != "T") // Die obere Ebene im Falle des isolierten Turms.
    {
      myShape.addParam(new params.ZylinderAbschnitt(1.7F, 1.7F, 0.3F, 210.0F), new Point(0.0F, 1.7F, 5.726F),
          new float[] { 180.0F, 0.0F, 0.0F });
    }
    
    if (T == "T")
    {
      waende = new Objekt[20];
      
      myShape.addParam(new params.ZylinderAbschnitt(1.7F, 1.7F, 0.35F, 160.0F), new Point(0.0F, 1.7F, 3.251F),
          new float[] { 70.0F, 0.0F, 0.0F });
      /*
       * Die Ebene nach dem ersten Treppenabschnitt ist durch den obenstehenden Befehl definiert, die untere definiert
       * die obere Ebene des Turms.
       */
      myShape.addParam(new params.ZylinderAbschnitt(1.7F, 1.7F, 0.3F, 210.0F), new Point(0.0F, 1.7F, 5.81F),
          new float[] { 30.0F, 0.0F, 0.0F });
    }
    
    for (int d = 0; d < 3; d++)
    {
      waende[d] = new Wand(0.0F, 1.7F, 0.0F, d * 90, 0.0F, 0.0F, 90.0F);
    }
    waende[3] = new TuerWand(0.0F, 1.7F, 0.0F, 270.0F, 0.0F, 0.0F, 90.0F);
    
    if (T != "T")
    {
      for (int r = 1; r < 4; r++)
      {
        for (int rota = 0; rota < 4; rota++)
        {
          
          waende[(r * 4 + rota)] = new Wand(0.0F, 1.7F, r * 1.5F, rota * 90, 0.0F, 0.0F, 90.0F);
        }
      }
    }
    
    if (T == "T")
    {
      for (int rota = 0; rota < 4; rota++)
      {
        waende[(4 + rota)] = new Wand(0.0F, 1.7F, 1.5F, rota * 90, 0.0F, 0.0F, 90.0F);
        waende[(8 + rota)] = new WandHalbeH(0.0F, 1.7F, 3.0F, rota * 90, 0.0F, 0.0F, 90.0F);
        waende[(16 + rota)] = new WandHalbeH(0.0F, 1.7F, 5.25F, rota * 90, 0.0F, 0.0F, 90.0F);
      }
      for (int rota = 2; rota < 5; rota++)
      {
        waende[(10 + rota)] = new Wand(0.0F, 1.7F, 3.75F, rota * 90, 0.0F, 0.0F, 90.0F);
      }
      waende[15] = new TuerWand(0.0F, 1.7F, 3.75F, 90.0F, 0.0F, 0.0F, 90.0F);
    }
    
    if (T != "T")
    {
      bonus[0] = new RundeTreppe("S", 0.0F, 1.7F, 0.026F, 120.0F, 0.0F, 0.0F, 360.0F, 30);
    }
    
    if (T == "T")
    {
      bonus = new Objekt[2];
      bonus[0] = new RundeTreppe("S", 0.0F, 1.7F, 0.026F, 120.0F, 0.0F, 0.0F, 360.0F, 18);
      bonus[1] = new RundeTreppe(0.0F, 1.7F, 3.301F, 160.0F, 0.0F, 0.0F, 360.0F, 13);
    }
    
    for (int rota = 0; rota < 4; rota++)
    {
      zinnen[rota] = new Zinne(0.0F, 1.7F, 6.0F, 90 * rota, 0.0F, 0.0F, 90.0F);
    }
  }
  
  public void step()
  {
  }
  
  public void collision()
  {
  }
  
  public void draw()
  {
    params.Material.BACKSTEIN.use();
    for (Objekt wand : waende)
    {
      wand.draw();
    }
    for (Objekt bon : bonus)
    {
      bon.draw();
    }
    for (Objekt zinne : zinnen)
    {
      zinne.draw();
    }
    
    myShape.draw();
  }
  
  public void drawGUI()
  {
  }
}