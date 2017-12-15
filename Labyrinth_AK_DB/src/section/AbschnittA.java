package section;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import models3D.Tuer;
import params.Material;
import path.*;

public class AbschnittA extends Objekt
{
	protected Objekt[] waende = new Objekt[3];
	protected Objekt[] steine = new Objekt[0];
	  
	public AbschnittA()
	{
		waende[0] = new LabGitter("l",new Level(1,13));
		waende[1] = new Sackgasse(new Level(1,13),"l");
		waende[2] = new Tuer_L("01",new Level(0,0));
	}
	
	@Override
	public void step()
	{
		
		  for (Objekt wand : waende)
		      wand.step();
		    for (Objekt stein : steine)
		      stein.step();	
	}

	@Override
	public void collision()
	{
		
		 for (Objekt wand : waende)
		      wand.collision();
		    for (Objekt stein : steine)
		      stein.collision();
	}

	@Override
	public void draw() 
	{
		
	    for (Objekt wand : waende)
	        wand.draw();
	      for (Objekt stein : steine)
	        stein.draw();	
	}

	@Override
	public void drawGUI() 
	{
		for (Objekt wand : waende)
		      wand.drawGUI();
		    for (Objekt stein : steine)
		      stein.drawGUI();
		
	}

}
