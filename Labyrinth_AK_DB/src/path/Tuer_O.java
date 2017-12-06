package path;

import basics.Level;
import main.Objekt;
import models3D.Tuer;
import params.Material;

public class Tuer_O extends Objekt
{
  protected Objekt [] tuer = new Objekt[1];
	  
  public Tuer_O(String name, float x, float y, float z)
  {
	tuer[0] = new Tuer(name,x,y,z,180,0,0); 
  }
  public Tuer_O(String name, Level lev)
  {
	  this(name,lev.x2-0.35f,lev.y2-0.05f,0);
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

