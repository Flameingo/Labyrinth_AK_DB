package main;

public abstract class Wand extends Objekt
{
  protected float laenge;
  protected float biegung;
  
  abstract void step();
  
  abstract void draw();
  
  abstract void collision();
  
  abstract void drawGUI();
}