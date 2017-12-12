package main;

public class Kompass
{
	
	                                     // Die Funktionen dieser Klasse benutzen die Spielerkoordinaten
										 // um die Koordinaten des Feldes zu ermitteln, auf dem sich 
										 // der Spieler aktuell befindet.
										 // Diese Werte entsprechen den Level-Werten mit denen Objekte in das Spiel gesetzt werden.
	                                     //
	                                     // Der Befehl getLvlX() liefert die a - Koordinate des Feldes.
	                                     // Der Befehl getLvlY() liefert die b - Koordinate des Feldes.
	
	
	
	
	/** Hilfsfunktion fuer getLvlX
	 * 
	 * @param x
	 * @return die Koordinate des eingesetzten 
	 * 			x - Wertes.
	 */
	public static int koordinateX(float x) 
	{
	 float h;
			
	if(x >= 0) 								//Negative Werte muessen anders behandelt werden, da sonst die Berechnung des Rests hierbei fehlerhaft ist.
	{
		h = (x - (x % 1.5f))/1.5f;     //Zieht den Rest modulo 1.5f ab und teilt dann duch 1.5f. 
		return (int)(h + 1);	       // Addiert man 1 hinzu hat man die a -Koordinate des Feldes, auf dem sich der Spieler "x" befindet. 
	}
	
	h = (x + (-x % 1.5f))/1.5f;
	return (int)(h);
			 
	}
	/** Hilfsfunktion fuer getLvlY
	 * 
	 * @param y
	 * @return die Feldkoordinate des eingesetzten 
	 * 			y - Wertes.
	 */
	public static int koordinateY(float y)
	{
	float g;
		
	if( - y >= 0)                             //Negative Werte muessen anders behandelt werden, da sonst die Berechnung des Rests hierbei fehlerhaft ist.
	{
		g = (y - (y % 1.5f))/-1.5f;			//Zieht den Rest modulo 1.5f ab und teilt dann duch - 1.5f. 
		return (int)(g + 1);				// Addiert man 1 hinzu hat man die a -Koordinate des Feldes, auf dem sich der Spieler "x" befindet. 
	}
	
	g = (y + (-y % 1.5f))/-1.5f;
	return (int)(g);
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
}
