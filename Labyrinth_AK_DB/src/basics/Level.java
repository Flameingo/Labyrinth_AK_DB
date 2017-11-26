package basics;

public class Level{
public float x1,x2,y1,y2;
	/**
	 * Erleichtert den Labyrinthbau.
	 * Die Koordinaten bilden eine Ebene mit z = 0 mit quadratischen Feldern. Das gewaehlte Feld wird durch a und b ausgewaehlt,
	 *  a wird groeﬂer in Richtung der positiven x - Achse, b ... positiven y - Achse
	 *  
	 * @param a 
	 * @param b
	 */
public Level (int a, int b) 
{
	this.x1 = a*1.5f - 1.5f;
	this.y1 = b*(-1.5f);
	this.x2 = a*1.5f;
	this.y2 = b*(-1.5f) + 1.5f;		
	
}

}
