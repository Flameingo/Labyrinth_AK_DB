package path;

import main.Objekt;
import models3D.Schalter;

public class SchalterFeld extends Objekt{

	protected Schalter [] schaldr = new Schalter[1];
	
	public SchalterFeld(float x, float y, float x2, float y2)
	{
	schaldr[0] = new Schalter(x2-x,y2-y,0,0,0,0);
	}
	public void step() {
		// TODO Auto-generated method stub
		schaldr[0].step();
		schaldr[0].setSchalter(true);
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		schaldr[0].setSchalter(true);
		for(Objekt sch : schaldr)
		{
			sch.draw();
		}
	}

	@Override
	public void drawGUI() {
		// TODO Auto-generated method stub
		
	}
	

	
}
