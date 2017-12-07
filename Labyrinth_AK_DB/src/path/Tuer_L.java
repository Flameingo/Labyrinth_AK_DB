package path;

import basics.Level;
import main.Objekt;
import models3D.Tuer;
import params.Material;

public class Tuer_L extends Objekt
{
  protected Objekt [] tuer = new Objekt[1];
	  
  public Tuer_L(String name, float x, float y, float z)
  {
	tuer[0] = new Tuer(name,x,y,z,270,0,0); 
  }
  public Tuer_L(String name, Level lev)
  {
	  this(name, lev.x1+0.05f,lev.y2-0.37f,0);
	  this.a = lev.x2;
	  this.b = lev.y1;
  }
  
  
  public void step()
  {
	  tuer[0].step();
	    
  }

	  
  public void collision()
  {

	    
  }

	  
  public void draw()
  {
	
  
    for (Objekt t : tuer){
      t.draw();
    }
  }

	 
  public void drawGUI()
  {
	
	    
  }
}

