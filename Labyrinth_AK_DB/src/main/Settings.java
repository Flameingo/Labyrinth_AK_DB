package main;

public final class Settings
{
  // settings that are changeable are collected here, so they can be found and
  // changed easily.
  
  // dev settings
  public final static boolean FPS_ON                  = true;
  public final static boolean DrawPlayerPOS           = false;
  
  /** controls the resolution of all drawn Objects */
  public final static float   RenderSolution          = 1 / .1f;
  // Player rotation speeds:
  public final static float   PlayerRotationLeftRight = (float) (Math.PI / 60);
  public final static float   PlayerRotationUpDown    = (float) (Math.PI / 180);
  
  public final static float   PlayerMovementSpeed     = .07f;
  public final static float   PlayerSideStepSpeed     = .05f;
  public static final boolean POLYMODE_ON             = false;
}
