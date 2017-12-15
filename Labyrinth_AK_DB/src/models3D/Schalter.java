package models3D;

import basics.Point;
import main.Funktionen;
import main.Labyrinth;
import main.Objekt;
import main.Player;
import main.Spawner;
import params.Kugel;
import params.Material;
import params.Quader;
import params.Shape;
import params.Zylinder;

import static org.lwjgl.glfw.GLFW.*;

import javax.sound.sampled.*;
import java.io.*;

public class Schalter extends Funktionen
{
  
  boolean         schalt;
  protected Shape block  = new Shape();
  protected Shape hebel  = new Shape();
  boolean         stop;
  public boolean  status;
  
  private float   winkel = 0f;
  
  public Schalter(String befehl, float x, float y, float z, float alpha, float beta, float gamma)
  {
    this.befehl = befehl;
    pos.x = x;
    pos.y = y;
    pos.z = z;
    stop = true;
    schalt = false;
    status = false;
    float slHoehe = 0.1f;
    block.addParam(new Quader("Mitte", 0.2f, 0.2f, slHoehe), new Point(0, 0, slHoehe / 2)); // Der
                                                                                            // Block
                                                                                            // auf
                                                                                            // dem
                                                                                            // der
                                                                                            // Schalter
                                                                                            // angebracht
                                                                                            // ist.
    hebel.addParam(new Zylinder(0.03f, 0.03f, 0.4f), new Point(0, 0, slHoehe), new float[] { 0, 35, 0 });
    block.addParam(new Kugel(0.1f), new Point(0, 0, slHoehe - 0.05f));
    
    block.translate(new Point(x, y, z));
    hebel.translate(new Point(x, y, z));
    
  }
  
  public void schalten()
  {
    if (stop == true)
    {
      stop = false;
      if (status == false)
      {
        status = true;
        Funktionen.plusschalten(this.befehl);
        return;
      }
      status = false;
      Funktionen.minusschalten(this.befehl);
      
    }
  }
  
  public void setSchalter(boolean modus) // nochmal ueberarbeiten
  {
    if (schalt == false && schalt != modus)
    {
      
      stop = false;
      return;
    }
    
    if (schalt != modus)
    {
      
      stop = false;
    }
    
  }
  
  @Override
  public void step()
  {
    for (int key : Labyrinth.keys)
    {
      Point p;
      switch (key)
      {
      case GLFW_KEY_G:
        p = Point.add(Labyrinth.player.pos, -pos.x, -pos.y, -pos.z);
        if (p.length("xy") < 1) schalten();
      }
    }
    if (stop != true)
    {
      hebel.rotate(new float[] { 0, winkel, 0 });
      hebel.translate(new Point(winkel * -0.1f / 70 + pos.x, pos.y, pos.z));
    }
    if (schalt == true)
    {
      if (stop != true) winkel = winkel - 1.5f;
      if (winkel <= -70)
      {
        stop = true;
        schalt = false;
      }
    }
    if (schalt == false)
    {
      if (stop != true) winkel = winkel + 1.5f;
      if (winkel >= 0)
      {
        stop = true;
        schalt = true;
      }
    }
    
  }
  
  @Override
  public void collision()
  {
  }
  
  @Override
  public void draw()
  {
    Material.SILVER.use();
    block.draw();
    Material.BLACK_RUBBER.use();
    hebel.draw();
    
  }
  
  @Override
  public void drawGUI()
  {
  }
  
}
