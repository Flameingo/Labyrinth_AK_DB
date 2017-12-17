package path;

import params.*;
import main.Labyrinth;
import main.Objekt;

import static org.lwjgl.opengl.GL11.*;

import basics.Level;
import basics.Point;

public class Steinflaeche extends Objekt
{
  protected Shape   myShape = new Shape();
  protected Shape   putz    = new Shape();
  protected Point[] hitbox  = new Point[3];
  
  public Steinflaeche(float x, float y, float z, float alpha, float beta, float gamma)
  {
    pos.x = x;
    pos.y = y;
    pos.z = z;
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
    
    putz.addParam(new Quader("Mitte", 1.4f, 1.4f, 0.05f), new Point(0.75f, 0.75f, 0));
    
    for (int vor = 0; vor < 10; vor++)
    {
      for (int r = 0; r < 5; r++)
      {
        myShape.addParam(new Quader("Mitte", 0.192f, 0.292f, 0.1f), new Point(0.1f + vor * 0.15f, 0.15f + r * 0.30f));
      }
    }
    
    putz.translate(new Point(x, y, z)); // Verantwortlich fuer die Verschiebung des gesamtes Putz.
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des gesamtes Putz.
    
    myShape.translate(new Point(x, y, z)); // Verantwortlich fuer die Verschiebung des restlichen Objektes.
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des restlichen Objektes.
    
    hitbox[0] = new Point(-.7f, -.7f, .05f);
    hitbox[1] = new Point(.7f, -.7f, .05f);
    hitbox[2] = new Point(-.7f, .7f, .05f);
    for (Point p : hitbox)
    {
      p.rotateZ(alpha);
      p.add(pos);
    }
  }
  
  public Steinflaeche(Level lev)
  {
    this(lev.x1, lev.y1, 0, 0, 0, 0);
    this.a = lev.x2;
    this.b = lev.y1;
  }
  
  public Steinflaeche(Level lev, Etage e)
  {
    pos.x = lev.x1;
    pos.y = lev.y1;
    pos.z = e.wert() * 2.1f;
    
    putz.addParam(new Quader("Mitte", 1.4f, 1.4f, 0.05f), new Point(0.75f, 0.75f, 0));
    
    for (int vor = 0; vor < 10; vor++)
    {
      for (int r = 0; r < 5; r++)
      {
        myShape.addParam(new Quader("Mitte", 0.192f, 0.292f, 0.1f),
            new Point(0.1f + vor * 0.15f, 0.15f + r * 0.30f, 0));
      }
    }
    
    putz.translate(new Point(pos.x, pos.y, pos.z)); // Verantwortlich fuer die Verschiebung des gesamtes Putz.
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des gesamtes Putz.
    
    myShape.translate(new Point(pos.x, pos.y, pos.z)); // Verantwortlich fuer die Verschiebung des restlichen Objektes.
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des restlichen
    
    this.a = lev.x2;
    this.b = lev.y1;
    
    hitbox[0] = new Point(-.7f, -.7f, .05f);
    hitbox[1] = new Point(.7f, -.7f, .05f);
    hitbox[2] = new Point(-.7f, .7f, .05f);
    for (Point p : hitbox)
    {
      p.rotateZ(alpha);
      p.add(pos);
    }
  }
  
  @Override
  public void step()
  {
  }
  
  @Override
  public void collision()
  {
    int res = 10;
    for (int i = 0; i < res; i++)
      for (int j = 0; j < res; j++)
      {
        Point p = Point.lip2(hitbox, (float) i / res, (float) j / res);
        while (Labyrinth.player.hitbox(p))
          Labyrinth.player.pos.z += .1f;
      }
  }
  
  @Override
  public void draw()
  {
    Material.BACKSTEIN.use();
    myShape.draw();
    Material.COPPER.use();
    putz.draw();
  }
  
  @Override
  public void drawGUI()
  {
  }
  
}
