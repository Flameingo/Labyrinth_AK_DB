package models3D;

import basics.Point;
import main.Labyrinth;
import main.Objekt;
import main.Settings;
import params.Kugel;
import params.Shape;

import static params.Material.*;
import static org.lwjgl.opengl.GL11.*;

public class Fog extends Objekt
{
  private Shape fog = new Shape();
  
  public Fog()
  {
	  if(!Settings.DARKNESS_MODE)
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
	  if(Settings.DARKNESS_MODE)
	  {
		  pushZusatzAufloesung(10);
		  fog.addParam(new Kugel(1, FOGFINAL), new Point(0, 0, 0));
		  fog.addParam(new Kugel(0.95f, FOG), new Point(0, 0, 0));
		  fog.addParam(new Kugel(0.9f, FOG), new Point(0, 0, 0));
		  fog.addParam(new Kugel(0.8f, FOG), new Point(0, 0, 0));
		  fog.addParam(new Kugel(0.75f, FOG), new Point(0, 0, 0));
		  fog.addParam(new Kugel(0.66f, FOG), new Point(0, 0, 0));
		  fog.addParam(new Kugel(0.6f, FOG), new Point(0, 0, 0));
		  fog.addParam(new Kugel(0.5f, FOG), new Point(0, 0, 0));
		  popZusatzAufloesung();
	  }
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
