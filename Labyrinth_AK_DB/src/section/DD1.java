package section;

import java.util.LinkedList;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import params.Material;
import path.*;

public class DD1 extends Objekt //Zusatzobjekte fuer AbschnittD, die im Verlaufe des Spiels verschwinden.
{
	 protected LinkedList<Objekt> waende = new LinkedList<Objekt>();
	 
	
	public DD1()
	{
			waende.add(new LabDmgWeg_L(new Level(7, 12))); // nach betaetigung von Schalter D1 wird dieses Stueck um 90 grad
		                                                   // gedreht.
		    waende.add(new LabDmgWeg_R(new Level(7, 12))); // nach betaetigung von Schalter D1 wird dieses Stueck um 90 grad
		                                                   // gedreht.
		    
		
	}
	
	@Override
	public void step()
	{
		
		  for (Objekt wand : waende)
		      wand.step();
		   	
	}

	@Override
	public void collision()
	{
		
		 for (Objekt wand : waende)
		      wand.collision();
		  
	}

	@Override
	public void draw() 
	{
		
	    for (Objekt wand : waende)
	        wand.draw();
	     	
	}

	@Override
	public void drawGUI() 
	{
		for (Objekt wand : waende)
		      wand.drawGUI();
		  
		
	}

}
