package models3D;

import basics.Level;
import basics.Point;
import main.Objekt;
import params.Material;
import params.Shape;
import params.Zylinder;

public class Gitter extends Objekt
{
  protected Shape myShape = new Shape();
  
  public Gitter(String B,float x, float y, float z, float alpha, float beta, float gamma, float stgbreite, float stghoehe)
  {
    this.x = x;
    this.y = y;
    this.z = z;
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
    
    if(B == "+")
      myShape.addParam(new Zylinder(0.03f,0.03f,0.2f*stghoehe*5-0.1f),
          new Point(0.1f*(stgbreite*5),0,0));
    
    for (int rechts = 0; rechts < stgbreite*5 ; rechts++)
    {
                                                                          //Erschafft die Vertikalen Stangen,
                                                                          //String "+" erschafft ein abschließendes Gitterstück
      myShape.addParam(new Zylinder (0.03f,0.03f,0.2f*stghoehe*5-0.1f), 
          new Point(0.2f*(rechts)-0.1f*(stgbreite*5.5f),0,0), new float[]{0,0,0});
      
    }  
   
    for (int hoch = 0; hoch < stghoehe*5; hoch++)
    {                                                                   //Erschafft die waagrechten Stangen
      myShape.addParam(new Zylinder (0.03f,0.03f,0.2f*stgbreite*5-0.1f), 
          new Point(-(stgbreite*5.5f)*0.1f,0,0.1f+0.2f*hoch), new float[]{0,90,0});
      
      
    }
    myShape.translate(new Point(x, y, z));   //Verantwortlich fï¿½r die Verschiebung des gesamtes Objektes
    myShape.rotate(new float[] { alpha, beta, gamma }); //Verantwortlich fï¿½r die Drehung des gesamtes Objektes
  }
  
  public Gitter(float x, float y, float z, float alpha, float beta, float gamma, float stgbreite, float stghoehe){
    this("-",x ,y ,z ,alpha ,beta ,gamma, stgbreite, stghoehe);
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
  public void draw()
  {
    Material.CHROME.use();
    myShape.draw();
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}
