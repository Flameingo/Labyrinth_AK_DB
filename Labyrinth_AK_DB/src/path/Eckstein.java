package path;

import basics.Level;
import basics.Point;
import main.Objekt;
import params.Material;
import params.Quader;
import params.Shape;

public class Eckstein extends Objekt
{
  
  protected Shape myShape = new Shape();
  protected Shape putz    = new Shape();
  
  public Eckstein(float x, float y, float alpha, float beta, float gamma, int hoehe)
  {
    
    putz.addParam(new Quader("Mitte", 0.2f, 0.2f, hoehe * 0.19f), new Point(0, 0, 0.1f * hoehe));
    myShape.addParam(new Quader("Mitte", 0.075f, 0.075f, 0.19f), new Point(0, 0, (hoehe - 0.5f) * 0.2f));
    for (int hoch = 0; hoch < hoehe; hoch++)
    {
      if (hoch % 2 == 0)
      {
        for (int q = 0; q < 4; q++)
        {
          myShape.addParam(new Quader("Mitte", 0.15f, 0.075f, 0.19f),
              new Point((float) (0.09f * Math.cos(q * Math.PI / 2 + Math.PI / 3)),
                  (float) (0.09f * Math.sin(q * Math.PI / 2 + Math.PI / 3)), hoch * 0.2f + 0.10f),
              new float[] { q * 90, 0, 0 });
        }
      }
      
      else
      {
        for (int q = 0; q < 4; q++)
        {
          myShape.addParam(new Quader("Mitte", 0.15f, 0.075f, 0.19f),
              new Point((float) (0.09f * -Math.cos(q * Math.PI / 2 + Math.PI / 3)),
                  (float) (0.09f * Math.sin(q * Math.PI / 2 + Math.PI / 3)), hoch * 0.2f + 0.10f),
              new float[] { q * 90, 0, 0 });
        }
      }
    }
    
    myShape.translate(new Point(x, y, pos.z)); // Verantwortlich zsm mit untenstehender Funktion f�r die Verschiebung
                                               // des gesamtes Objektes.
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich zsm mit hier darunter stehender Funktion f�r
                                                        // die Drehung des gesamtes Objektes.
    
    putz.translate(new Point(x, y, pos.z)); // Verantwortlich f�r die Verschiebung des Putz.
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich f�r die Drehung des Putz.
  }
  
  public Eckstein(Level lev, int hoehe)
  {
    this(lev.x1, lev.y2, hoehe);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public Eckstein(Level lev)
  {
    this(lev.x1, lev.y2);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public Eckstein(float x, float y)
  {
    this(x, y, 0, 0, 0, 11);
  }
  
  public Eckstein(float x, float y, int hoehe)
  {
    this(x, y, 0, 0, 0, hoehe);
  }
  
  @Override
  public void step()
  {
  }
  
  @Override
  public void collision()
  {
  }
  
  @Override
  public void draw()
  {
    putz.draw();
    Material.BACKSTEIN.use();
    myShape.draw();
  }
  
  @Override
  public void drawGUI()
  {
  }
  
}
