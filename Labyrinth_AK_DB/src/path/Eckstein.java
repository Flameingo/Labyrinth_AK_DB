package path;

import basics.Point;
import main.Objekt;
import params.Material;
import params.Quader;
import params.Shape;

public class Eckstein extends Objekt{

	protected Shape myShape = new Shape();
	protected Shape putz = new Shape();
	
	public Eckstein(float x, float y, float alpha, float beta, float gamma ,int hoehe)
	{
		
		putz.addParam(new Quader("Mitte",0.2f,0.2f,hoehe*0.19f), new Point(0,0,0.1f*hoehe));
		myShape.addParam(new Quader("Mitte",0.075f,0.075f,0.19f), new Point(0,0,(hoehe-0.5f)*0.2f));
		for(int hoch = 0; hoch < hoehe; hoch++)
		{
		  if(hoch % 2 == 0)
		  {
			for(int q = 0; q < 4; q++)
			{
				myShape.addParam(new Quader("Mitte",0.15f,0.075f,0.19f),new Point((float)(0.09f*Math.cos(q*Math.PI/2+Math.PI/3)),(float)(0.09f*Math.sin(q*Math.PI/2+Math.PI/3)),hoch*0.2f+0.10f), new float[] {q*90,0,0});
			}
		  }
		  
		  else
		  {
			for(int q = 0; q < 4; q++)
			{
				myShape.addParam(new Quader("Mitte",0.15f,0.075f,0.19f),new Point((float)(0.09f*-Math.cos(q*Math.PI/2+Math.PI/3)),(float)(0.09f*Math.sin(q*Math.PI/2+Math.PI/3)),hoch*0.2f+0.10f), new float[] {q*90,0,0});
			}  
		  }
		}
		
		 myShape.translate(new Point(x, y, z));   //Verantwortlich für die Verschiebung des gesamtes Objektes
		 myShape.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich für die Drehung des gesamtes Objektes
		
	}
	public Eckstein(float x, float y)
	{
		this(x,y,0,0,0,11);
	}
	public Eckstein(float x, float y, int hoehe)
	{
		this(x,y,0,0,0,hoehe);
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
		putz.draw();
		Material.BACKSTEIN.use();
		myShape.draw();
		
	}

	@Override
	public void drawGUI() {
		// TODO Auto-generated method stub
		
	}

}
