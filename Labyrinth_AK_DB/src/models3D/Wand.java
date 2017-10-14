package models3D;

import main.Objekt;

public abstract class Wand extends Objekt
{
  protected float laenge;
  protected float biegung;
  
  public abstract void step();
  
  public abstract void draw();
  
  public abstract void collision();
  
  public abstract void drawGUI();
}