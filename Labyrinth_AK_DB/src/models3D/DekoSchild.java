package models3D;

import basics.Level;
import basics.Point;
import basics.Text;
import main.Objekt;
import params.Material;
import params.Quader;
import params.Shape;
import params.Zylinder;

public class DekoSchild extends Objekt
{
	
	protected Shape brett = new Shape();
	protected Shape stock = new Shape();
	
	public DekoSchild (float x, float y, float z, float alpha, float beta, float gamma) //warum muss es auch so verdammt schwer sein einen Ring zu konstruieren...
	{
		pushZusatzAufloesung(3);
			brett.addParam(new Quader("Mitte",0.01f,0.5f,0.5f), new Point(0,0,1)); // Das Brett des Schildes an das Botschaften geheftet werden koennen
			stock.addParam(new Zylinder(0.01f,0.01f,0.75f));
		
			brett.translate(new Point(x, y, z));   //Verantwortlich fuer die Verschiebung des Bretts
			brett.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich fuer die Drehung des Bretts
	    
			stock.translate(new Point(x, y, z));   //Verantwortlich fuer die Verschiebung des Holzpfals, auf dem das Brett platziert ist.
			stock.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich fuer die Drehung ...
	    popZusatzAufloesung();
	    
	    Text.draw_text("Mitte", new Point(x+0.2f,y+0.2f,0.5f), 10);
	}
	public DekoSchild (String eck, Level lev) // r ist rechts, o ist oben, u ist unten, l ist links 
	{   
		pushZusatzAufloesung(3);
			brett.addParam(new Quader("Mitte",0.01f,0.5f,0.5f), new Point(0,0,1)); // Das Brett des Schildes an das Botschaften geheftet werden koennen
			stock.addParam(new Zylinder(0.01f,0.01f,0.75f));
		popZusatzAufloesung();                                      //Das Feld wird nach den Kriterien von Level 
		
		switch(eck)
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
		
	
		brett.translate(new Point(pos.x, pos.y, 0));   //Verantwortlich fuer die Verschiebung des Bretts
		brett.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich fuer die Drehung des Bretts
    
		stock.translate(new Point(pos.x, pos.y, 0));   //Verantwortlich fuer die Verschiebung des Holzpfals, auf dem das Brett platziert ist.
		stock.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich fuer die Drehung ...
    
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
		Material.CHROME.use();
		stock.draw();
		Material.WHITE_RUBBER.use();
		brett.draw();
	}

	@Override
	public void drawGUI() {
		// TODO Auto-generated method stub
		
	}


	
}
