package section;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import params.Material;
import path.*;

public class AbschnittBB extends Objekt
{
	protected Objekt[] waende = new Objekt[32];
	protected Objekt[] steine = new Objekt[0];
	  
	public AbschnittBB()
	{
		waende[0] = new LabTuer_L(new Level (3,6));
		waende[1] = new LabTuer_R(new Level(3, 6));
		waende[2] = new LabWeg_U(new Level(3, 6));
		waende[3] = new LabWeg_o_u(new Level(4,9));
	    waende[4] = new LabWeg_U(new Level(4,10));
	    waende[5] = new LabWeg_r_l(new Level(3,10));
	    waende[6] = new LabWeg_U(new Level(2,10));
	    waende[7] = new LabEck_lu(new Level(1,9));
	    waende[8] = new LabEck_ru(new Level(0,9));	
	    waende[9] = new LabWeg_o_u(new Level(0,10));
	    waende[10] = new Sackgasse(new Level(0,11),"o");
	    waende[11] = new LabWeg_L(new Level(1,11));
	    waende[12] = new LabEck_ru(new Level(2,9));
	    waende[13] = new LabWeg_O(new Level(3,9));
	    waende[14] = new LabWeg_U(new Level(1,12));
	    waende[15] = new LabWeg_U(new Level(0,12));
	    waende[16] = new LabEck_ro(new Level(-1,12),true);
	    waende[17] = new LabWeg_L(new Level(-1,11));
	    waende[18] = new LabWeg_L(new Level(-1,10));
	    waende[19] = new LabWeg_O(new Level(-1,9));
	    waende[20] = new LabEck_ru(new Level(-2,9));
	    waende[21] = new LabWeg_L(new Level(-2,10));
	    waende[22] = new LabWeg_L(new Level(-2,11));
	    waende[23] = new LabWeg_L(new Level(-2,12));
	    waende[24] = new LabEck_ro(new Level(-2,13));
	    waende[25] = new LabWeg_r_l(new Level(-1,13));
	    waende[26] = new Sackgasse(new Level(0,13),"l");
	    waende[27] = new LabWeg_U(new Level(3, 5));
	    waende[28] = new LabWeg_U(new Level(4, 5));
	    
	   
	    waende[29] = new LabWeg_o_u(new Level(4, 7));
	   
	    waende[30] = new LabWeg_U(new Level(3, 8));
	    waende[31] = new LabWeg_R(new Level(4, 8));
		
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
