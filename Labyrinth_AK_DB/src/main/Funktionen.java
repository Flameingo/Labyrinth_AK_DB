package main;

public class Funktionen extends Objekt{
	
	protected String befehl;

	public static void plusschalten(String call)
	{
		switch(call)
		{
			case "B_BC": Spawner.abschnittB.hidden = false;
//						 Spawner.abschnittBC.hidden = true;
			    break;
			
//			case "BC_C": Spawner.abschnittBC.hidden = false;
//						 Spawner.abschnittC.hidden = true;
			default:
				break;
		}
			return;
	}
	
	public static void minusschalten(String call)
	{
		switch(call)
		{
			case "B_BC":  Spawner.abschnittB.hidden = true;
//						  Spawner.abschnittBC.hidden = false;
			    break;
//			case "BC_C": Spawner.abschnittBC.hidden = true;
//						 Spawner.abschnittC.hidden = false;
		
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
