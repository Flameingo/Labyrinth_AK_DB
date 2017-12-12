package main;

public class Funktionen extends Objekt{
	/**
	 * In diesen String koennen bestimmte Begriffe eingetragen werden, die bei Ausfuehren einer Interaktion eine bestimmte Handlung durchfuehren.
	 * Objekte der Unterklassen dieser Klasse werden mit einem solchen String-Wert erstellt. 
	 * 
	 * B_BB: plus - Abschnitt B verschwindet, Abschnitt BB erscheint - minus umgekehrt
	 * BB_BC: plus - Abschnitt BB verschwindet, Abschnitt BC erscheint, - minus umgekehrt. 
	 * BC_C:: minus - Abschnitt BC verschwindet, Abschnitt C erscheint.
	 * D...: plus = Tueren innerhalb von Abschnitt D. Einwegschalter!
	 */
	protected String befehl;
	/**
	 * Wird durch "Plusschalten"/"Minusschalten" veraendert und beeinflusst durch "ueberpruefung" (Funktionen) eine Tuer mit dem entsprechenden "befehl" (buchstaben/zahlenfolge 
	 * hinter dem "stand", so das eine Aenderung dieses Booleans die Tuer oeffnet(true) bzw schliesst (false).
	 */
	protected static boolean stand01, 
							 stand02, 
							 stand03, 
							 standd1, 
							 standd2, 
							 standd3, 
							 standd4, 
							 standd5 = false;

/**
 * 
 * @param name "befehl" des entsprechenden Objektes einer Unterklasse von Funktionen.
 * 
 * @return Wahrheitswert des diesem "befehl" zugeordneten static-boolean aus dieser Klasse.
 */
	public static boolean ueberpruefung(String name) //Bei jeder Ausfuehrung von Render-Loop fuehrt jedes Objekt "Tuer" eine Ueberpruefung durch.
	{                                                //Dabei wird der Status ("befehl") eines Objektes an den entsprechenden Boolean innerhalb dieser Klasse angepasst.
													 //Wird der Status dadurch geaendert, schliesst bzw oeffnet sich die Tuer.
		switch(name)								 //Die Booleans werden durch plusschalten/minusschalten geaendert.
		{
		case "01": return stand01;
		case "02": return stand02;
		case "03": return stand03;
		case "d1": return standd1;
		case "d2": return standd2;
		case "d21": return standd2;
		case "d3": return standd3;
		case "d31": return standd3;
		case "d4": return standd4;
		case "d5": return standd5;
		default:
			return false;
		}
	}
	/**
	 * Erstmalige Bedienung eines Hebels ist "plusschalten", beide Befehle wechseln sich bei Ingame-Interaktion mit einem Schalter in ihrer Ausfuehrung ab.
	 * @param call "Befehl" des Schalters. Damit kann jedem Schalter eine individuelle Aktion zugeordnet werden.
	 */
	public static void plusschalten(String call)
	{
		switch(call)
		{
		    case "BB": stand01 = true;
		        break;
		    	
		    case "B_BB": Spawner.abschnittB.hidden = true;
		    			 Spawner.abschnittBB.hidden = false;
		    			 stand01 = false;
		    			 stand02 = true;
		    		break;
		  
			case "BB_BC": Spawner.abschnittBB.hidden = true;
						  Spawner.abschnittBC.hidden = false;
			    break;
			
			case "BC_C": Spawner.abschnittBC.hidden = true;
						 Spawner.abschnittC.hidden = false;
				break;
				
			case "D1": standd1 = true;
			 	break;
			 case "D2": standd2 = true;
			 break;
			 case "D3": standd3 = true;
			 break;
			 case "D4": standd4 = true;
			 break;
			 case "D5": standd5 = true;
			 break;
				
			default:
				break;
		}
			return;
	}
	
	/**
	 * Erstmalige Bedienung eines Hebels ist "plusschalten", beide Befehle wechseln sich bei Ingame-Interaktion mit einem Schalter in ihrer Ausfuehrung ab.
	 * @param call "Befehl" des Schalters. Damit kann jedem Schalter eine individuelle Aktion zugeordnet werden.
	 */
	public static void minusschalten(String call)
	{
		switch(call)
		{
			case "B_BB": Spawner.abschnittB.hidden = false;
						 Spawner.abschnittBB.hidden = true;
						 stand01 = true;
						 stand02 = false;
				break;
		
			case "BB_BC": Spawner.abschnittBB.hidden = false;
						  Spawner.abschnittBC.hidden = true;
			    break;
			    
			case "BC_C": Spawner.abschnittBC.hidden = false;
						 Spawner.abschnittC.hidden = true;
			    break;
			    
			default:
				break;
		}
			return;
	}
	/**
	 * Stellt alle statischen DisplayLists, die Labyrinthabschnitte auf unsichtbar (werden nicht mehr gezeichnet) mithilfe des Booleans hidden aus "Spawner".
	 */
	public static void allHide()
	{
		Spawner.abschnittB.hidden = true;
		Spawner.abschnittBB.hidden = true;
	    Spawner.abschnittBC.hidden = true;
	    Spawner.abschnittC.hidden = true;
	    Spawner.abschnittD.hidden = true;
	}

	@Override
	public void step() {                            		//Abstrakte Methoden aus "Objekt" finden hier keine Anwendung.
															//Nur bei den entsprechenden Unterklassen "Tuer" und "Schalter".
		
	}

	@Override
	public void collision() {
		
		
	}

	@Override
	public void draw() {
		
		
	}

	@Override
	public void drawGUI() {
		
		
	}

}
