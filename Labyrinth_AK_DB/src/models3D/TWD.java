package models3D;

import basics.Point;
import params.Quader;

public class TWD extends WandBlock{
		/**
		 * Gleicht dem (ersten von oben) Konstruktor der "Wand"-Klasse, nur ist hier ein Loch, das fuer eine Tuere geeignet ist in der Wand. Das Objekt der 
		 * Klasse "Tuer" passt exakt in diese Oeffnung. So sind auch "LabTuer" und "Tuer" - Klassen aus path aufeinander angepasst.
		 * LabTuer beschreibt das Wandstueck, Tuer die Tuere selbst.
		 * 
		 * @param x
		 * @param y
		 * @param z
		 * @param alpha
		 * @param beta
		 * @param gamma
		 * @param laenge
		 * @param hoehe
		 */
	  public TWD(float x, float y, float z, float alpha, float beta, float gamma,float laenge,float hoehe) //Der Unterschied von "myShape" und "stein" 
	  {                                                                                                    //ist nur von Bedeutung fuer die Beleuchtung.
	    super(x, y, z, alpha,beta,gamma);
	    
	    float vX = - laenge/2;
	    
	    for (int k = 0; k<hoehe*100/6; k++) //Das k ist in die z - Richtung laufende Variable und ordnet die Steinreihen uebereinander.
	    {           
	      
	      if ( k % 2 == 0 )
	      {
	        if ( k < 30 )
	        {
	          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(0.194f+vX,0,k*0.06f + boden));      
	        
		      myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.105f+vX,0,k*0.06f + boden));
	        }   
	       
	          for (int i = 0; i < (laenge)*10/2.6 ; i++) //Das i ist die in x - Richtung laufende Variable und ordnet die Steine einer Reihe nebeneinander.
	          {
	            if (!(( i > 0 && i < 5 ) && ( k < 30 )))
	            {
	              myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.26f+vX,0,k*0.06f + boden));
	            }
	         }
	      }
	      else
	      {
	        
	        
	        stein.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+vX,0,k*0.06f + boden));
	        stein.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((int)(laenge*10/2.6f)*0.26f+0.0625f+vX,0,k*0.06f + boden));
	           
	          for (int i = 0; i < (laenge)*10/2.6 - 1;i++)
	            {           
	              if (!(( i > 0 && i < 4 ) && ( k < 30 ))) 
	               {
	                myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (i*0.26f+0.13f+vX,0,k*0.06f + boden));
	               }
	            }
	         }
	      }
	  
	  } 
}
