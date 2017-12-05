package section;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import params.Material;
import path.*;

public class AbschnittBC extends Objekt
{
	protected Objekt[] waende = new Objekt[2];
	protected Objekt[] steine = new Objekt[0];
	  
	public AbschnittBC()
	{
		waende[0] = new Sackgasse(new Level (0,13),"l");
		waende[1] = new Sackgasse(new Level(0,-8),"l");
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
