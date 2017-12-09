package models3D;

import basics.Point;
import main.Spawner;
import params.Quader;

public class BeschaedigteWandRANDOM extends WandBlock
{
  
	
  public BeschaedigteWandRANDOM(float x, float y, float z, float w1, float w2, float w3)
  {
  super(x,y,z,w1,w2,w3);
  
  float qX = wandFeld/2;
  
  for (int k = 0; k<wdhoehe; k++)
  {
    
    
    if (k%2 == 0)
    {
     
        for (int i = 0; i<wdlaenge; i++)
        {
          if (Math.random()>0.2f)
          myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.26f+qX,0,k*0.06f+boden));
          
       }
    }
       else
       {
         myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+qX,0,k*0.06f+boden));
         myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((wdlaenge-1)*0.26f+0.065f+qX,0,k*0.06f+boden));
         
         for (int i = 0; i<wdlaenge-1;i++)
         {           
           if (Math.random()>0.2f)
           myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (i*0.26f+0.13f+qX,0,k*0.06f+boden));
         }
       }
    }
  }
  
  public BeschaedigteWandRANDOM(float x, float y, float z, float alpha, float beta, float gamma, float laenge, float hoehe)
  {
  super(x,y,z,alpha, beta, gamma);
  
  float vX = - laenge/2;
  int matrix [][] = new int[25][40];
  
  for (int hoch = 0; hoch < hoehe*100/6; hoch++)
  {
    
    
    if (hoch%2 == 0)
    {
     
        for (int rechts = 0; rechts < (laenge)*10/2.6; rechts++)
        {
          if (Math.random()>0.2f)
          {
        	  myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(rechts*0.26f+vX,0,hoch*0.06f+boden));
        	  matrix[rechts+1][hoch+1] = 1;
        	  
        	  if (matrix[rechts+1][hoch] == 1)
        	  {
        		  putz.addParam(new Quader("Mitte", 0.2f,wdbreite/2, 0.04f), new Point(rechts*0.26f+vX,0,hoch*0.06f+boden-0.03f));
        	  }
        	  if (matrix[rechts][hoch+1] == 1)
        	  {
        		  putz.addParam(new Quader("Mitte", 0.2f,wdbreite/2,0.04f), new Point(rechts*0.26f+vX,0,hoch*0.06f+boden-0.02f));
        	  }
          }
       }
    }
       else
       {
         myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+vX,0,hoch*0.06f+boden));
         myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((int)(laenge*10/2.6f)*0.26f+0.0625f+vX, 0, hoch * 0.06f+boden));
         
         for (int rechts2 = 0; rechts2 < (laenge)*10/2.6 - 1;rechts2++)
         {           
           if (Math.random()>0.2f)
           {
        	   myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (rechts2*0.26f+0.13f+vX,0,hoch*0.06f+boden));
        	   if (matrix[rechts2+1][hoch] == 1)
         	   {
         		  putz.addParam(new Quader("Mitte", 0.2f,wdbreite/2, 0.04f), new Point(rechts2*0.26f+0.13f+vX,0,hoch*0.06f+boden-0.03f));
         	   }
         	   if (matrix[rechts2][hoch+1] == 1)
         	   {
         		  putz.addParam(new Quader("Mitte", 0.2f,wdbreite/2,0.04f), new Point(rechts2*0.26f+0.13f+vX,0,hoch*0.06f+boden-0.02f));
         	   }
           }
         }
       }
    }
  }
  
  public BeschaedigteWandRANDOM(float x, float y, float z, float w1, float w2, float w3, float biege)
  {
    
    super (x,y,z,w1,w2,w3, biege);
    

    
    for (int k = 0; k<wdhoehe; k++)
    {
      
      
      if (k % 2 == 0)
      {
        

             
          for (int i = 0; i<wdlaenge; i++)
          {
            double biegend1 = (i*biege*Math.PI)/3600;
            double biegend11 = (i*biege)/10;
            myShape.addParam(new Quader("Mitte", 0.25f+(i*biege)/30000, wdbreite, 0.05f), 
                new Point((float)Math.cos(biegend1)*i*0.25f+qX,(float)Math.sin(biegend1)*i*0.25f,k*0.06f+boden), new float[] {(float) biegend11,0,0});
            
         }
      }
         else
         {
           myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f+qX,0,k*0.06f+boden));
           myShape.addParam(new Quader("Mitte", 0.125f+(biege*biege)/90000,wdbreite,0.05f), 
               new Point((float)Math.cos((biege*Math.PI)/360)*(2.57f-biege/1200)+qX,(float)Math.sin((biege*Math.PI)/360)*(2.68f-biege/600),k*0.06f+boden),
               new float[] {biege,0,0});
           
           for (int i = 0; i<wdlaenge-1;i++)
           {           
             double biegend2 = ((i+0.5f)*biege*Math.PI)/3600;
             double biegend22 = ((i+0.5f)*biege)/10;
             myShape.addParam(new Quader("Mitte", 0.25f+(i*biege)/30000,wdbreite,0.05f), 
                 new Point ((float)Math.cos(biegend2)*i*0.25f+0.13f+qX,(float)Math.sin(biegend2)*i*0.25f,k*0.06f+boden), new float[]{(float) biegend22,0,0});
           }
      
         }
      }
    
    

  }
  
  
}
