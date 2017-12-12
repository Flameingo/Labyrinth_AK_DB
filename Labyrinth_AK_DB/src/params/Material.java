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
  EMERALD(.0215f, .1745f, .0215f, .55f, .07568f, .61424f, .07568f, .55f, .633f, .727811f, .633f, .55f, .6f),
  JADE(.135f, .2225f, .1575f, .95f, .54f, .89f, .63f, .95f, .316228f, .316228f, .316228f, .95f, .1f),
  OBSIDIAN(.05375f, .05f, .06625f, .82f, .18275f, .17f, .22525f, .82f, .332741f, .328634f, .346435f, .82f, .3f),
  PEARL(.25f, .20725f, .20725f, .922f, 1f, .829f, .829f, .922f, .296648f, .296648f, .296648f, .922f, .088f),
  RUBY(.1745f, .01175f, .01175f, .55f, .61424f, .04136f, .04136f, .55f, .727811f, .626959f, .626959f, .55f, .6f),
  TURQUOISE(.1f, .18725f, .1745f, .8f, .396f, .74151f, .69102f, .8f, .297254f, .30829f, .306678f, .8f, .1f),
  BRASS(.329412f, .223529f, .027451f, 1, .780392f, .568627f, .113725f, 1, .992157f, .941176f, .807843f, 1, .21794872f),
  BRONZE(.2125f, .1275f, .054f, 1, .714f, .4284f, .18144f, 1, .393548f, .271906f, .166721f, 1, .2f),
  POLISHED_BRONZE(.25f, .148f, .06475f, 1, .4f, .2368f, .1036f, 1, .774597f, .458561f, .200621f, 1, .6f),
  CHROME(.25f, .25f, .25f, 1, .4f, .4f, .4f, 1, .774597f, .774597f, .774597f, 1, .6f),
  COPPER(.19125f, .0735f, .0225f, 1, .7038f, .27048f, .0828f, 1, .256777f, .137622f, .086014f, 1, .1f),
  POLISHED_COPPER(.2295f, .08825f, .0275f, 1, .5508f, .2118f, .066f, 1, .580594f, .223257f, .0695701f, 1, .4f),
  GOLD(.24725f, .1995f, .0745f, 1, .75164f, .60648f, .22648f, 1, .628281f, .555802f, .366065f, 1, .4f),
  POLISHED_GOLD(.24725f, .2245f, .0645f, 1, .34615f, .3143f, .0903f, 1, .797357f, .723991f, .208006f, 1, .65f),
  SILVER(.19225f, .19225f, .19225f, 1, .50754f, .50754f, .50754f, 1, .508273f, .508273f, .508273f, 1, .4f),
  POLISHED_SILVER(.23125f, .23125f, .23125f, 1, .2775f, .2775f, .2775f, 1, .773911f, .773911f, .773911f, 1, .7f),
  BLACK_PLASTIC(0, 0, 0, 1, .01f, .01f, .01f, 1, .50f, .50f, .50f, 1, .25f),
  CYAN_PLASTIC(0, .1f, .06f, 1, 0, .50980392f, .50980392f, 1, .50196078f, .50196078f, .50196078f, 1, .25f),
  GREEN_PLASTIC(0, 0, 0, 1, .1f, .35f, .1f, 1, .45f, .55f, .45f, 1, .25f),
  RED_PLASTIC(0, 0, 0, 1, .5f, 0, 0, 1, .7f, .6f, .6f, 1, .25f),
  WHITE_PLASTIC(0, 0, 0, 1, .55f, .55f, .55f, 1, .70f, .70f, .70f, 1, .25f),
  YELLOW_PLASTIC(0, 0, 0, 1, .5f, .5f, 0, 1, .60f, .60f, .50f, 1, .25f),
  BLACK_RUBBER(.02f, .02f, .02f, 1, .01f, .01f, .01f, 1, .4f, .4f, .4f, 1, .078125f),
  CYAN_RUBBER(0, .05f, .05f, 1, .4f, .5f, .5f, 1, .04f, .7f, .7f, 1, .078125f),
  GREEN_RUBBER(0, .05f, 0, 1, .4f, .5f, .4f, 1, .04f, .7f, .04f, 1, .078125f),
  RED_RUBBER(.05f, 0, 0, 1, .5f, .4f, .4f, 1, .7f, .04f, .04f, 1, .078125f),
  WHITE_RUBBER(.05f, .05f, .05f, 1, .5f, .5f, .5f, 1, .7f, .7f, .7f, 1, .078125f),
  YELLOW_RUBBER(.05f, .05f, 0, 1, .5f, .5f, .4f, 1, .7f, .7f, .04f, 1, .078125f),
  BACKSTEIN(.1f, 0, 0, 1, .5f, 0, 0, 1, .1f, 0, 0, 1, 1),
  BACKSTEIN2(0.2f,0,0.02f,0.9f,0.6f,0,0, 1, 0.2f,0,0,1,1),
  BACKSTEIN3(0.05f,0.05f,0,0.95f,0.3f,0,0,0.9f,0,0,0.1f,1,1);
  
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
    this.shininess = shininess * 128;
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
