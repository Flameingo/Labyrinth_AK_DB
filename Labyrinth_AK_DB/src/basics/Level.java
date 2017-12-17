package basics;

public class Level{
public float x1,x2,y1,y2;
public int a,b;
	/**
	 * Erleichtert den Labyrinthbau auf der waagrechten Ebene. Dabei wird ein quadratisches Raster auf diese Ebene gelegt. a und b sind die Indize
	 * 
	 * 
	 *  Waende angrenzender Felder schliessen die Luecke 
	 *  So koennen Objekte leichter an den gewuenschten Ort innerhalb einer Labyrinthstruktur platziert werden, da diese zumeist 
	 *  Die Koordinaten bilden eine Ebene mit z = 0 mit quadratischen Feldern. Das gewaehlte Feld wird durch a und b ausgewaehlt,
	 *  a wird groe�er in Richtung der positiven x - Achse, b ... negativen y - Achse
	 *  
	 *  Der Mittelpunkt berechnet sich aus x = 1.5 * a - 0.75 und y = - 1.5f * b + 0.75 
	 *  
	 * @param a Nach "rechts" wachsender Index des Feldes 
	 * @param b Nach "unten" wachsender Index des Feldes
	 */
public Level (int a, int b) 
{
  this.a = a;
  this.b = b;
	this.x1 = a*1.5f - 1.5f; //Diese 4 Koordinaten spannen ein Quadrat auf
	this.y1 = b*(-1.5f);
	this.x2 = a*1.5f;
	this.y2 = b*(-1.5f) + 1.5f;		
	
//           Dieses quadratische Feld ist wie folgt zu verstehen :	 
//	         
//	         x1,y2          ...       1.5         ...              x2,y2
//	         
//	          ...			  Feldmittelpunkt: 		               ...
//	          1.5 			x =  1.5 * a - 0.75                    1.5                                          ....   pos. x - Achse
//	          ...			y = -1.5 * b + 0.75                    ...
//	          
//	         x1,y1          ...       1.5         ...              x2,y1
//	   
	
	
	
//                             .....
//                           neg. y - Achse
	
}

public Point getMitte()
{
  return new Point(1.5f * a - 0.75f,-1.5f * b + 0.75f);
}

}
