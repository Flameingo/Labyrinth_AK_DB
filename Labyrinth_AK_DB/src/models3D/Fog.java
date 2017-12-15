package models3D;

import basics.Point;
import main.Labyrinth;
import main.Objekt;
import params.Kugel;
import params.Shape;

import static params.Material.*;
import static org.lwjgl.opengl.GL11.*;

public class Fog extends Objekt
{
  private Shape fog = new Shape();
  
  public Fog()
  {
    pushZusatzAufloesung(10);
    fog.addParam(new Kugel(3, FOGFINAL), new Point(0, 0, 0));
    fog.addParam(new Kugel(2.95f, FOG), new Point(0, 0, 0));
    fog.addParam(new Kugel(2.6f, FOG), new Point(0, 0, 0));
    fog.addParam(new Kugel(2.25f, FOG), new Point(0, 0, 0));
    fog.addParam(new Kugel(1.9f, FOG), new Point(0, 0, 0));
    fog.addParam(new Kugel(1.55f, FOG), new Point(0, 0, 0));
    fog.addParam(new Kugel(1.2f, FOG), new Point(0, 0, 0));
    fog.addParam(new Kugel(1f, FOG), new Point(0, 0, 0));
    popZusatzAufloesung();
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
    fog.draw();
  }
  
  @Override
  public void drawGUI()
  {
  }
  
}
