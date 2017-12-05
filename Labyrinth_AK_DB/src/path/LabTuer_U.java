package path;

import basics.Level;
import main.Objekt;
import models3D.TWD;
import models3D.Wand;
import models3D.WandBlock;
import params.Material;

public class LabTuer_U extends Objekt {
	
	protected Objekt [] waende = new Objekt[1];
	  
	  /**
	   *  Zwei Punkte spannen ein Quadrat auf
	   * @param x
	   * @param y
	   * @param z
	   * @param x2
	   * @param y2
	   * @param z2
	   */
	  public LabTuer_U(float x, float y, float x2, float y2, float hoehe)
	  {
	    
	   
	   
	      float yy = y + WandBlock.wdbreite/2;//Damit die Wandbreite nicht die gewaehlten Grenzen ueberragt.
	      waende [0] = new TWD((x+x2)/2+0.13f, yy, boden, 0,0,0, Math.abs(x2-x), hoehe);
	    
	     
	    
	   
	  }
	  
	  public LabTuer_U(Level lev, float hoehe)
	  {
		  this(lev.x1,lev.y1,lev.x2,lev.y2, hoehe);
	  }
	  public LabTuer_U(Level lev)
	  {
		  this(lev.x1,lev.y1,lev.x2,lev.y2, 2);
	  }
	  
	  
	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		    for (Objekt wand : waende)
		    {
		      wand.draw();
		    }
	}

	@Override
	public void drawGUI() {
		// TODO Auto-generated method stub
		
	}

}