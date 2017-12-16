package section;

import java.util.LinkedList;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import params.Material;
import path.*;

public class DD2 extends Objekt //Zusatzobjekte fuer AbschnittD, die im Verlaufe des Spiels verschwinden.
{
	 protected LinkedList<Objekt> waende = new LinkedList<Objekt>();
	 
	
	public DD2()
	{
		
			 waende.add(new LabDmgWeg_O(new Level(7, 12)));
			 waende.add(new LabDmgWeg_U(new Level(7, 12))); //Diese Waende sind nach der Betaetigung des Schalters aktiv.
		
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
