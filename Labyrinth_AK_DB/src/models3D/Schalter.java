package models3D;

import basics.Point;
import main.Objekt;
import params.Kugel;
import params.Material;
import params.Quader;
import params.Shape;
import params.Zylinder;

public class Schalter extends Objekt{

	protected boolean schalt;
	protected Shape block = new Shape();
	protected Shape hebel = new Shape();
	boolean stop;
	
	private float winkel = 0f;
	public Schalter(float x, float y, float z, float alpha, float beta, float gamma)
	{
		this.stop = true;
		this.schalt = false;
		float slHoehe = 0.1f;
		block.addParam(new Quader("Mitte",0.2f,0.2f,slHoehe),new Point(0,0,slHoehe/2)); //Der Block auf dem  der Schalter angebracht ist.
		hebel.addParam(new Zylinder(0.03f,0.03f,0.4f), new Point(0,0,slHoehe),new float []{0,35,0});
		block.addParam(new Kugel(0.1f), new Point(0,0,slHoehe-0.05f));
	}
	public void schalten()
	{	if (this.schalt = true)
		{
			this.schalt = false;
			this.stop = false;
		}
		else
		{
			this.schalt = true;
			this.stop = false;
		}
	
	}
	public void setSchalter(boolean modus)
	{
		if (this.schalt == false && this.schalt != modus)
		{
			this.schalt = true;
			this.stop = false;
		}
		else
		{
			if (this.schalt != modus)
			{
				this.schalt = false;
				this.stop = false;
			}
		}
	}
	@Override
	public void step() {
		// TODO Auto-generated method stub
		hebel.rotate(new float[]{0,winkel,0});
		hebel.translate(new Point(winkel*-0.1f/70,0,0));
		
		if(schalt == true)
		{		
			if(stop != true)
				winkel = winkel - 0.2f;
			if(winkel <= - 70)
				stop = true;
		}
		if(schalt == false)
		{
			if(stop != true)
				winkel = winkel + 0.2f;
			if(winkel >= 0)
				stop = true;
		}
		
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		Material.SILVER.use();
		block.draw();
		Material.BLACK_RUBBER.use();
		hebel.draw();
	
	}

	@Override
	public void drawGUI() {
		// TODO Auto-generated method stub
		
	}
	
	
}
