package unused;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import params.Material;
import path.*;

public class AbschnittBC extends Objekt
{
	protected Objekt[] waende = new Objekt[28];
	protected Objekt[] steine = new Objekt[2];
	  
	public AbschnittBC()
	{
		waende[0] = new Sackgasse(new Level (0,13),"l");
		waende[1] = new LabWeg_r_l(new Level(-1,13));
		waende[2] = new LabWeg_r_l(new Level(-2,13));
		waende[3] = new LabEck_ro(new Level(-3,13));
		
		for(int i = 0; i < 20; i++)
		{
			waende[i+4] = new LabWeg_o_u(new Level(-3,12-i));
		}
		
		waende[24] = new LabEck_ru(new Level(-3,-8));
		waende[25] = new LabWeg_r_l(new Level(-2,-8));
		waende[26] = new LabWeg_r_l(new Level(-1,-8));
		waende[27] = new Sackgasse(new Level(0,-8),"l");
		
		//Ecksteine
		steine[0] = new Eckstein(new Level(-2,13));
		steine[1] = new Eckstein(new Level(-2,-7));
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
