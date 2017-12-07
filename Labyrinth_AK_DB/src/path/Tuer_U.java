package path;

import basics.Level;
import main.Objekt;
import models3D.Tuer;
import params.Material;

public class Tuer_U extends Objekt
{
  protected Objekt [] tuer = new Objekt[0];
	  
  public Tuer_U(String name,float x, float y, float z)
  {
	tuer[0] = new Tuer(name,x,y,z,0,0,0); 
  }
  public Tuer_U(String name, Level lev)
  {
	  this(name, lev.x1 + 0.4f,lev.y1+0.05f,0);
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

