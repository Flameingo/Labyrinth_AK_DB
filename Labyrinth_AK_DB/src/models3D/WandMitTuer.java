package models3D;

import basics.Point;
import params.Quader;
import static org.lwjgl.opengl.GL11.*;

public class WandMitTuer extends TuerWand
{

  public WandMitTuer(float x, float y, float z, float w1, float w2, float w3)
  {
    super(x, y, z, w1, w2, w3);
  
    
    myShape.addParam(new Quader("Ecke", 0.65f,0.05f,1.30f), new Point(1.3f+this.x,-0.05f+this.z,-0.02f+this.y));
    
  }
  
}
