package models3D;

import basics.Point;
import params.Quader;

public class TWD extends WandBlock{

	  public TWD(float x, float y, float z, float alpha, float beta, float gamma,float laenge,float hoehe)
	  {
	    super(x, y, z, alpha,beta,gamma);
	    
	    float vX = - laenge/2;
	    
	    for (int k = 0; k<hoehe*100/6; k++)
	    {           
	      
	      if ( k % 2 == 0 )
	      {
	        if ( k < 30 )
	        {
	          myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(0.194f+vX,0,k*0.06f + boden));      
	        
		      myShape.addParam(new Quader("Mitte", 0.125f, wdbreite, 0.05f), new Point(1.105f+vX,0,k*0.06f + boden));
	        }   
	       
	          for (int i = 0; i < (laenge)*10/2.6 ; i++)
	          {
	            if (!(( i > 0 && i < 5 ) && ( k < 30 )))
	            {
	              myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.26f+vX,0,k*0.06f + boden));
	            }
	         }
	      }
	      else
	        {
	        
	        
	        myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+vX,0,k*0.06f + boden));
	        myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((int)(laenge*10/2.6f)*0.26f+0.0625f+vX,0,k*0.06f + boden));
	           
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
