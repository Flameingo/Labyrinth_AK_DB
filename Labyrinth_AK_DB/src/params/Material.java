/**
 * 
 */
package params;

import static org.lwjgl.opengl.GL11.*;

/**
 * Speichert die Materialeigenschaften
 */
public enum Material
{
  RUBIN(.17f, .01f, .01f, .5f, .61f, .04f, .04f, .5f, .73f, .63f, .63f, .5f, 76.8f);
  
  private float[] ambient   = { 0, 0, 0, 1 }, diffuse = { 0, 0, 0, 1 }, specular = { 0, 0, 0, 1 };
  private float   shininess = 128;
  
  private float[] emission  = { 0, 0, 0, 0 };
  
  /** Konstruktor ohne Emission */
  Material(float kaR, float kaG, float kaB, float aa, float kdR, float kdG, float kdB, float ad, float ksR, float ksG,
      float ksB, float as, float shininess)
  {
    ambient = new float[] { kaR, kaG, kaB, aa };
    diffuse = new float[] { kdR, kdG, kdB, ad };
    specular = new float[] { ksR, ksG, ksB, as };
    this.shininess = shininess;
  }
  
  /** Konstruktor mit Emission */
  Material(float kaR, float kaG, float kaB, float aa, float kdR, float kdG, float kdB, float ad, float ksR, float ksG,
      float ksB, float as, float shininess, float keR, float keG, float keB, float ae)
  {
    this(kaR, kaG, kaB, aa, kdR, kdG, kdB, ad, ksR, ksG, ksB, as, shininess);
    emission = new float[] { keR, keG, keB, ae };
  }
  
  /** stellt die GL Statusmaschine fuer dieses Material ein */
  public void use()
  {
    glMaterialf(GL_FRONT, GL_SHININESS, shininess);
    glMaterialfv(GL_FRONT, GL_AMBIENT, ambient);
    glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuse);
    glMaterialfv(GL_FRONT, GL_SPECULAR, specular);
    glMaterialfv(GL_FRONT, GL_EMISSION, emission);
  }
}
