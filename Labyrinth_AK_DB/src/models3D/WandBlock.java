package models3D;

import params.Quader;
import main.Objekt;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class WandBlock extends Objekt
{
  
  protected int wdlaenge = 11;
  protected int wdhoehe = 25;
  protected float wdbreite = 0.1f;
  protected float x,y,z;
  protected float w1,w2,w3;
  protected Shape myShape = new Shape();
  
  
  public WandBlock(float x, float y, float z,float w1, float w2, float w3)
  {
    this.x=x;
    this.y=y;
    this.z=z;
    this.w1=w1;
    this.w2=w2;
    this.w3=w3;
   
  }
  
  
  public WandBlock(float biege)
  {
    for (int k = 0; k<wdhoehe; k++)
    {
      
      
      if (k%2 == 0)
      {
       
          for (int i = 0; i<wdlaenge; i++)
          {
         
            myShape.addParam(new Quader("Mitte", 0.25f, wdbreite, 0.05f), new Point(i*0.27f-biege*biege*0.3f*i*i,(i*biege)*(i*biege),k*0.06f), new float[] {i*i*biege*biege*45,0,0});
            
         }
      }
         else
         {
           myShape.addParam(new Quader("Mitte", 0.125f,wdbreite, 0.05f), new Point(-0.065f,0,k*0.06f));
           myShape.addParam(new Quader("Mitte", 0.125f,wdbreite,0.05f), new Point((wdlaenge-1)*0.27f+0.065f-biege*biege*32,biege*biege*105,k*0.06f), new float[] {45*100*biege*biege,0,0});
           
           for (int i = 0; i<wdlaenge-1;i++)
           {           
             
             myShape.addParam(new Quader("Mitte", 0.25f,wdbreite,0.05f), new Point (i*0.27f+0.13f-biege*biege*0.3f*i*i,(i*biege)*(i*biege)*1.1f,k*0.06f), new float[]{i*i*biege*biege*45,0,0});
           }
      
         }
      }
  }
  public void draw()
  {
    myShape.draw();
  }
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
}
