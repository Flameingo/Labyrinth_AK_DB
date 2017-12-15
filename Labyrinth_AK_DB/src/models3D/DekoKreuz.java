package models3D;

import basics.Level;
import basics.Point;
import basics.Text;
import main.Labyrinth;
import main.Objekt;
import params.Material;
import params.Quader;
import params.Shape;

public class DekoKreuz extends Objekt
{
	
	protected Shape myShape = new Shape();
	
	public DekoKreuz(Level lev, String ecke)
	{
		myShape.addParam(new Quader("Mitte", 0.05f,0.1f,1), new Point(0,0,0.5f));
		myShape.addParam(new Quader("Mitte", 0.05f,0.6f,0.1f), new Point(0,0,0.7f));
		
		switch(ecke)
		{
			case "ro": 
				pos.x = lev.x2 - 0.4f;
				pos.y = lev.y2 - 0.5f;
				this.alpha = 10;
				break;
			case "ru":
			  pos.x = lev.x2 - 0.4f;
			  pos.y = lev.y1 + 0.5f;
				this.alpha = - 10;
				break;
			case "lo":
			  pos.x = lev.x1 + 0.4f;
			  pos.y = lev.y2 - 0.5f;
				this.alpha = - 10;
				break;
			case "lu":
			  pos.x = lev.x1 + 0.4f;
			  pos.y = lev.y1 + 0.5f;
				this.alpha = 10;
				break;
			default:
			  pos.x = lev.x1 + 0.75f;
			  pos.y = lev.y2 - 0.75f;
				break;
		}
		
		myShape.translate(new Point(pos.x,pos.y,0));
		myShape.rotate(new float[]{alpha,0,0});
		Point p;
		String Ausgabe = "Press F to pay respect";
		 p = Point.add(Labyrinth.player.pos, -pos.x, -pos.y, -0);
	        if (p.length("xy") < 1) Text.draw_text(Ausgabe, new Point (10,30), 40);
	}
	
	@Override
	public void step() {
		
		
	}

	@Override
	public void collision() {
				
	}

	@Override
	public void draw() 
	{
		Material.BRONZE.use();
		myShape.draw();
		
	}

	@Override
	public void drawGUI() {
		
		
	}

}
