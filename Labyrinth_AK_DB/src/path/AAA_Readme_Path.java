package path;

public class AAA_Readme_Path {

	
	/**
	Dieses Package wurde dafuer geschaffen, den Umgang mit den Wandklassen beim Erschaffen eines Labyrinthes zu erleichtern.
	Dabei muss die x,y - Ebene betrachtet werden.
	Die Koordinaten zweier Eckpunkte, die ein Quadrat aufspannen wird einer Klasse uebergeben (optional noch die Hoehe).
	Auf diesem quadratischen Feld wird dann der gewuenschte Abschnitt platziert.
	 
	Alternativ kann die Hilfsmethode Level ("Ebene", steht fuer die x,y-Ebene) benutzt werden, dabei wird die x,y-Ebene als ein Feld aus Quadraten
	mit 1.5f*1.5f Flaecheninhalt. Hier werden die Parameter a und b uebergeben. Damit wird der gewuenschte Abschnitt in einem Quadrat positioniert,
	dessen linke obere Ecke die Koordinaten von a * 1.5f und die von b * -1.5f entspricht.
	
	a wird groesser fuer groessere x, b wird groesser fuer KLEINERE y.
	
	Bei den Bezeichnungen der verschiedenen Abschnitte ist "o" als oben, "r" als rechts, "l" als links und "u" als unten zu verstehen, die Buchstaben 
	geben die Seiten an, die KEINE Wand haben. 
	rechts und oben entsprechen der Richtung des Zahlenstrahls von x, bzw y.
	LabEck_lo bezeichnet bsw eine Ecke, die nach links und nach oben geoeffnet ist.
	Sprich auf der rechten und der unteren Seite des Quadrates befinden sich Wandstuecke.
	
	Grossbuchstaben hingegen sagen aus, dass sich gerade auf dieser Seite ein Wandstueck befindet.
	Dies wird verwendet, wenn es drei Seiten ohne Wandstueck und nur eine Seite mit Wandstueck gibt.
	Sprich LabWeg_O zB erschafft nur ein Wandstueck, naemlich an der oberen Kante des Quadrates.
	
	Sackgasse wird ueber einen String bedient, der mit "oben","links","rechts","unten" oder den jeweiligen Kuerzeln eine Sackgasse erschafft, die in Richtung der
	im String benannten Seite geoeffnet.
	
	LabEck-Klassen besitzen einen Boolean
	Bei false werden nur zwei Waende erschaffen, die Eck an Eck liegen.
	Bei true wird zusaetzlich eine gebogene Wand erschaffen, die an der jeweils anderen Ecke beider Wandstuecke anliegt.
	
	
	*/
}
