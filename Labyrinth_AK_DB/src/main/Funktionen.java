package main;

import basics.Point;
import basics.Text;

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
							 standd5,
							 standd6, 
							 standdplus = false;

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
		case "d6": return standd6;
		case "dplus": return standdplus; //Alle Tueren, die sich oeffnen, wenn der letzte Schalter bedient wurde ausser die finale Tuer am Ausgangspunkt.
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
		    case "B1": stand01 = true;
		        break;
		    	
		    case "B2": 
		    			    			
		    		  stand02 = true;    //oeffnet Tuere
		    	break;
		  
			case "BB_BC": Spawner.abschnittBB.hidden = true; //Erschafft den Abschnitt BC und stellt alle kollidierenden Abschnitte auf unsichtbar.
						  Spawner.abschnittBC.hidden = false;
						  Spawner.abschnittC.hidden = true;
			    break;
			
			case "BC_C": Spawner.abschnittBC.hidden = true;
						 Spawner.abschnittC.hidden = false;
						 Spawner.abschnittBB.hidden = false;
				break;
				
			case "D1":   standd1 = true;   			 
					 	 Spawner.dD1.hidden = true;															
					 	 Spawner.dD2.hidden = false; //DD1 unsichtbar, DD2 sichtbar : Waende scheinen sich gedreht zu haben
			 	break;                         
			case "D2": standd2 = true;		// D2 - D5 ... Einwegschalter zum Tueren oeffnen innerhalb von AbschnittD. Chronolisch geordnet. 2 entspricht ebenso
				break;						// standd2, D3 standd3 usw ...
			case "D3": standd3 = true;
				break;
			case "D4": standd4 = true;
				break;
			case "D5": standd5 = true;
				break;
			case "D6":  standd6 = true; //Stellt die finale Tuer auf "offen"
			 	    	standd1 = false; //Stellt alle bisher geoeffneten Tueren auf "geschlossen"
			 			standd2 = false; 
			 			standd3 = false;
			 			standd4 = false;
			 			standd5 = false;
			 			standdplus = true;  //Oeffnet neue Tueren, die einen alternativen Weg bieten.
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
	public static void minusschalten(String call) //macht entsprechende Aktionen von Plusschalten rueckgaenig
	{
		switch(call)
		{
		
			case "BB_BC": Spawner.abschnittBB.hidden = false; //rueckgaengig
						  Spawner.abschnittBC.hidden = true;
						  Spawner.abschnittC.hidden = false;
			    break;
			    
			 case "BC_C": Spawner.abschnittBC.hidden = false; //rueckgaengig
						 Spawner.abschnittC.hidden = true;
						 Spawner.abschnittBB.hidden = true;
			    break;
			    
			case "D1": Spawner.dD1.hidden = false; //rueckgaengig
					   Spawner.dD2.hidden = true;
			    break;
			case "D6":  standd6 = false; //rueckgaengig
 	    				standd1 = true;
 	    				standd2 = true;
 	    				standd3 = true;
 	    				standd4 = true;
 	    				standd5 = true;
 	    				standdplus = false;
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
//		Spawner.abschnittB.hidden = true;
//		Spawner.abschnittBB.hidden = true;
//	    Spawner.abschnittBC.hidden = true;
//	    Spawner.abschnittC.hidden = true;
//	    Spawner.abschnittD.hidden = true;
	    Spawner.abschnittE.hidden = true;
	    Spawner.dD1.hidden = true;
	    Spawner.dD2.hidden = true;
	    
	    Spawner.boden.hidden = true; //Alle Böden werden unsichtbar.
	    Spawner.bodenBC.hidden = true;
	    
	}
	

	/**
	 * Positionsabfrage die von Player.step() in jeder Iteration durchgefuehrt wird. Ist der Spieler auf einem "bestimmten" Feld, aktiviert diese Methode
	 * dann einen bestimmten Effekt im Spiel. 
	 */
	public static void koordinatenabfrage() 
	{
		try
		{
			if(!Spawner.abschnittD.hidden)
			{
				if (Text.anleitung)	
					if(Kompass.getLvlX() == 3 && Kompass.getLvlY() == 14)   // Auf dem dritten Feld wird die anfangs sichtbare Anleitung verschwinden. Dieses Feld muss immer ueberlaufen werden.
						Text.anleitung = false;								//Abfrage kann eventuell in andere Klasse verlegt werden.
			
				if(Kompass.getLvlX() == -2 && Kompass.getLvlY() == 14)
					levelup();
				}
		}
		catch(Exception e)
		{
			return;
		}
		
	}
	/**
	 * Exekutive fuer den Stufenaufstieg, befoerdert bei jeder Ausfuehrung den Spieler in die vollstaendige Ausgangssituation des naechsten (Spiel-)Levels.
	 */
	public static void levelup()
	{
		
		allHide();
		if (Player.myLevel == 1) //Erste Stufe abgeschlossen, zweite erreicht.
		{
			Labyrinth.player.pos = new Point (10,-4,0);
			Spawner.abschnittE.hidden = false;
			Spawner.bodenBC.hidden = false;
		}
		else 
		{
			Spawner.boden.hidden = false;
		}
		Player.myLevel++;
	}
	

	//Abstrakte Methoden aus Oberklasse "Objekt" finden hier keine Anwendung.
	//Nur bei den Unterklassen "Tuer" und "Schalter" dieser Klasse "Funktionen", diese machen von der
	//"Ur"-Oberklasse Objekt Gebrauch.

	
	
	@Override
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
