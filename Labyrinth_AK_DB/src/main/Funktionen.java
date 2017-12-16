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
													 //Der Status ist entweder true fuer Tuer sei offen oder false fuer Tuer sei geschlossen.
													 //Wird der Status dadurch geaendert, schliesst bzw oeffnet sich die Tuer.
		switch(name)								 //Die Booleans werden durch plusschalten/minusschalten geaendert.
		{
		case "01": return stand01;   //Tueren von AbschnittB, BB, BC und C. 
		case "02": return stand02;
		case "03": return stand03;
		case "d1": return standd1;   //standd1 - d5 sind die Tueren innerhalb von AbschnittD.
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
	 * Zumeist macht Minusschalten die Aktion von Plusschalten wieder rueckgaengig.
	 * Alle Ausfuerungen von "Befehlen", die ein "D" enthalten sind Einwegschalter, da Minusschalten die Konsequenzen von Plusschalten nicht rueckgaengig macht.
	 * @param call "Befehl" des Schalters. Damit kann jedem Schalter eine individuelle Aktion zugeordnet werden.
	 */
	public static void plusschalten(String call)
	{
		switch(call)
		{
		    case "BB": stand01 = true;
		        break;
		    	
		    case "B_BB": Spawner.abschnittB.hidden = true; //Abschnitt wird nicht mehr angezeigt
		    			 Spawner.abschnittBB.hidden = false; //Abschnitt wird nun angezeigt
		    			 stand01 = false;  	// schliesst Tuere
		    			 stand02 = true;    //oeffnet Tuere
		    		break;
		  
			case "BB_BC": Spawner.abschnittBB.hidden = true;
						  Spawner.abschnittBC.hidden = false;
			    break;
			
			case "BC_C": Spawner.abschnittBC.hidden = true;
						 Spawner.abschnittC.hidden = false;
				break;
				
			case "D1": standd1 = true;   // D1 - D5 ... Einwegschalter zum Tueren oeffnen innerhalb von AbschnittD. Chronolisch geordnet. D1 entspricht ebenso
					 Spawner.dD1.hidden = true;															// standd1, D2 standd2 usw ...
					 Spawner.dD2.hidden = false; //DD1 unsichtbar, DD2 sichtbar : Waende scheinen sich gedreht zu haben
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
	 * Zumeist macht Minusschalten die Konsequenzen von Plusschalten wieder rueckgaengig.
	 * @param call "Befehl" des Schalters. Damit kann jedem Schalter eine individuelle Aktion zugeordnet werden.
	 */
	public static void minusschalten(String call)
	{
		switch(call)
		{
			case "B_BB": Spawner.abschnittB.hidden = false; //saemtliche Aktionen rueckgaengig
						 Spawner.abschnittBB.hidden = true;
						 stand01 = true;
						 stand02 = false;
				break;
		
			case "BB_BC": Spawner.abschnittBB.hidden = false; //rueckgaengig
						  Spawner.abschnittBC.hidden = true;
			    break;
			    
			case "BC_C": Spawner.abschnittBC.hidden = false; //rueckgaengig
						 Spawner.abschnittC.hidden = true;
			    break;
			    
			case "D1": Spawner.dD1.hidden = false; //rueckgaengig
					   Spawner.dD2.hidden = true;
			    break;
			    
			default:
				break;
		}
			return;
	}
	/**
	 * Stellt alle statischen DisplayLists, die Labyrinthabschnitte auf unsichtbar (werden nicht mehr gezeichnet) mithilfe des Booleans hidden aus "Spawner".
	 */
	public static void allHide() //Funktion aktuell ungenutzt, scheint aber nicht falsch zu sein sie schon mal innerhalb des Spiels zu wissen.
	{
		Spawner.abschnittB.hidden = true;
		Spawner.abschnittBB.hidden = true;
	    Spawner.abschnittBC.hidden = true;
	    Spawner.abschnittC.hidden = true;
	    Spawner.abschnittD.hidden = true;
	    Spawner.dD1.hidden = true;
	    Spawner.dD2.hidden = true;
	}

															//Abstrakte Methoden aus "Objekt" finden hier keine Anwendung.
															//Nur bei den entsprechenden Unterklassen "Tuer" und "Schalter", diese machen von der
	@Override												//"Ur"-Oberklasse Objekt Gebrauch.
	public void step()
	{   
		
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
