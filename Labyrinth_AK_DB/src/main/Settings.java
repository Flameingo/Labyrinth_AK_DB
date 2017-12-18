package main;

public final class Settings
{
  // settings that are changeable are collected here, so they can be found and
  // changed easily.
  
  // dev settings
  public static final boolean FPS_ON                  = true;                    // Gibt ingame im Eck oben links
                                                                                 // konstant die aktuelle Anzahl an
                                                                                 // Frames per Second an.
  public static final boolean DrawPlayerPOS           = false;                   // Gibt den Standort des Spielers in
                                                                                 // Koordinaten an der Konsole aus.
  public static final boolean POLYMODE_ON             = false;                   // Zeichnet die Flaechen nicht mehr und
                                                                                 // zeigt die Facettierung der Objekte.
  public static final boolean FLAT_SHADING            = true;
  public static final boolean DRAW_BACK_POINTS        = false;
  public static final int     DRAW_FONT_POINTS        = 0;
  public static final boolean NEBEL_ON                = true;                    // Ein Nebel, der die Sichtweite
                                                                                 // einschraenkt. Fuer den optimalen
                                                                                 // Spielverlauf auf "true" zu stellen!
  
  public static final boolean SHOW_CURRENT_LEVEL       = true;                   // Zeigt welches Level der Spieler gerade spielt.
  
  /** controls the resolution of all drawn Objects */
  
  public final static float   RenderSolution          = 0;                       // Grafikeinstellung, Spiel ist auf Wert 0 angepasst,
  																				 // Hoehere Werte benoetigen leistungsstarken Rechner.
                                                                                  
                                                                                 // Bestimmt wie fein die Facettierung
                                                                                 // der Objekte ist. 5 ist Richtwert.
  
  public final static float   PlayerRotationLeftRight = (float) (Math.PI / 60);  // Bestimmmt wie schnell Drehungen der
                                                                                 // Spielerkamera durch die Pfeiltasten
  public final static float   PlayerRotationUpDown    = (float) (Math.PI / 180); // erfolgt.
  // Player movement speeds:
  public final static float   PlayerMovementSpeed     = 0.07f;                   // urspruenglich Laufgeschwindigkeit
                                                                                 // des Spielers (vorwaerts und
                                                                                 // rueckwaerts).
                                                                                 // 0.07f
  public final static float   PlayerSideStepSpeed     = .05f;                    // urspruenglich Laufgeschwindigkeit
                                                                                 // fuer Seitwaertsbewegungen.
                                                                                 // 0.05f
  
  // cheats
  public static final boolean SHOW_LEVEL              = true;                    // Gibt im Spiel die Position zur
                                                                                 // Orientierung in Koordinaten
                                                                                 // (Feldkoordinate Level) an.
  
  public static final boolean SKIP_LEVEL_ENABLED      = true;					 //Erlaubt das Ueberspringen des Levels mit "P".
  
  
  
  public static final boolean TELEPORT_ENABLED        = true;                    //Druecke "t" ingame und gib anschlieﬂend A-Koordinate - Enter - B-Koordinate - Enter ein um dich auf
  																				 //das Feld mit den entsprechenden Indizes zu teleportieren.
  // modis
  public static final boolean DARKNESS_MODE           = false;
  
  
}
