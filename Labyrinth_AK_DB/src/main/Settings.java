package main;

public final class Settings
{
  // settings that are changeable are collected here, so they can be found and
  // changed easily.
  
  // dev settings
  public final static boolean FPS_ON                  = true;
  public final static boolean DrawPlayerPOS           = false;
  public static final boolean POLYMODE_ON             = false;
  public static final boolean FLAT_SHADING            = true;
  public static final boolean DRAW_BACK_POINTS        = false;
  
  /** controls the resolution of all drawn Objects */
  public final static float   RenderSolution          = 5;                      // urspr�nglich 5
  // Player rotation speeds:
  public final static float   PlayerRotationLeftRight = (float) (Math.PI / 60);
  public final static float   PlayerRotationUpDown    = (float) (Math.PI / 180);
  // Player movement speeds:
  public final static float   PlayerMovementSpeed     = 0.07f;                  // urspr�nglich 0.07f
  public final static float   PlayerSideStepSpeed     = .05f;                   // urspr�nglich 0.05f
}
