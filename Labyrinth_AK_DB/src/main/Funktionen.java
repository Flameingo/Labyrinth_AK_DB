package main;

public class Funktionen extends Objekt{
	/**
	 * In diesen String koennen bestimmte Begriffe eingetragen werden, die bei Ausfuehren einer Interaktion eine bestimmte Handlung durchfuehren.
	 * B_BB: plus - Abschnitt B verschwindet, Abschnitt BB erscheint - minus umgekehrt
	 * BB_BC: plus - Abschnitt BB verschwindet, Abschnitt BC erscheint, - minus umgekehrt. 
	 * BC_C:: minus - Abschnitt BC verschwindet, Abschnitt C erscheint.
	 */
	protected String befehl;
	protected static boolean stand01 = false;
	protected static boolean stand02 = false;
	protected static boolean stand03 = false;

	public static boolean ueberpruefung(String name)
	{
		switch(name)
		{
		case "01": return stand01;
		case "02": return stand02;
		case "03": return stand03;
		default:
			return false;
		}
	}
	public static void plusschalten(String call)
	{
		switch(call)
		{
		    case "BB": stand01 = true;
		        break;
		    	
		    case "B_BB": Spawner.abschnittB.hidden = true;
		    			 Spawner.abschnittBB.hidden = false;
		    			 stand01 = false;
		    			 stand02 = true;
		    	break;
		
		
			case "BB_BC": Spawner.abschnittBB.hidden = true;
						  Spawner.abschnittBC.hidden = false;
			    break;
			
			case "BC_C": Spawner.abschnittBC.hidden = true;
						 Spawner.abschnittC.hidden = false;
				break;
				
			default:
				break;
		}
			return;
	}
	
	public static void minusschalten(String call)
	{
		switch(call)
		{
			case "B_BB": Spawner.abschnittB.hidden = false;
						 Spawner.abschnittBB.hidden = true;
						 stand01 = true;
						 stand02 = false;
				break;
		
			case "BB_BC": Spawner.abschnittBB.hidden = false;
						  Spawner.abschnittBC.hidden = true;
			    break;
			    
			case "BC_C": Spawner.abschnittBC.hidden = false;
						 Spawner.abschnittC.hidden = true;
			    break;
			    
			default:
				break;
		}
			return;
	}
	
	public static void allHide()
	{
		
	}
	/** Hilfsfunktion fuer getLvlX
	 * 
	 * @param x
	 * @return die Koordinate des eingesetzten 
	 * 			x - Wertes.
	 */
	public static int koordinateX(float x) 
	{
	 float h;
			
	if(x >= 0)
	{
		h = (x - (x % 1.5f))/1.5f;
		return (int)(h + 1);	
	}
	
	h = (x + (x % 1.5f))/1.5f;
	return (int)(h+1);
			 
	}
	/** Hilfsfunktion fuer getLvlY
	 * 
	 * @param y
	 * @return die Feldkoordinate des eingesetzten 
	 * 			y - Wertes.
	 */
	public static int koordinateY(float y) //Rechnet fuer getLvlY
	{
	float g;
		
	if( - y >= 0)
	{
		g = (y - (y % 1.5f))/-1.5f;
		return (int)(g + 1);
	}
	
	g = (y + (y % 1.5f))/-1.5f;
	return (int)(g+1);
	}
	/** 
	 * @return a - Wert des Feldes, auf dem sich der Spieler aktuell befindet.
	 */
	public static int getLvlX()           //Liefert den a - Wert des Feldes (Level), auf dem sich der Spieler aktuell befindet.
	{																	// a nimmt zu in Richtung der positiven x - Achse.
		return koordinateX(Labyrinth.player.pos.x);
	}
	/**
	 * @return b - Wert des Feldes, auf dem sich der Spieler aktuell befindet.
	 */
	public static int getLvlY()            //Liefert den b - Wert des Feldes (Level), auf dem sich der Spieler aktuell befindet.
	{                                                                    // b nimmt zu in Richtung der negativen y - Achse.
		return koordinateY(Labyrinth.player.pos.y);
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
		
	}

	@Override
	public void drawGUI() {
		// TODO Auto-generated method stub
		
	}

}
