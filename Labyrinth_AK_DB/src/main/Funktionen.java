package main;

public class Funktionen extends Objekt{
	/**
	 * In diesen String koennen bestimmte Begriffe eingetragen werden, die bei Ausfuehren einer Interaktion eine bestimmte Handlung durchfuehren.
	 * B_BB: plus - Abschnitt B verschwindet, Abschnitt BB erscheint - minus umgekehrt
	 * BB_BC: plus - Abschnitt BB verschwindet, Abschnitt BC erscheint, - minus umgekehrt. 
	 * BC_C:: minus - Abschnitt BC verschwindet, Abschnitt C erscheint.
	 */
	protected String befehl;
	protected static boolean stand01 = false;
	protected static boolean stand02 = false;
	protected static boolean stand03 = false;

	public static boolean ueberpruefung(String name)
	{
		switch(name)
		{
		case "01": return stand01;
		case "02": return stand02;
		case "03": return stand03;
		default:
			return false;
		}
	}
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
				
			default:
				break;
		}
			return;
	}
	
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
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawGUI() {
		// TODO Auto-generated method stub
		
	}

}
