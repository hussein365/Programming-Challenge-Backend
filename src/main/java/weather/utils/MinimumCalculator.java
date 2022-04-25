package weather.utils;

import java.util.List;

import lombok.NoArgsConstructor;
/*
 * Diese Klasse ist eine Hilfsklasse zum vergleichen von Objekten einer Liste
 * nach einer bestimmten Wert und das Zurükgeben des Objekts dieser Liste mit dem minimalen Wert.
 * Sie unterstützt auch generische Typen und kann verwendet werden für verschiedenen Typen.
 * Das heisst,sie kann in unserem Fall sowohl für die Klasse Weather als auch Football benutzt werden um 
 * den Tag bzw das Team herauszufinden mit dem minimalen Kriteriumswert(absolute Differenz)
 * für Weather: Differenz zwische maximale und minimale Temperatur
 * für Football: Absolute Differenz zwischen erzielte Tore und kassierte Tore.
 * Sie kann auch für andere Tabellen benutzt werden(andere Cases)
 */

@NoArgsConstructor
public class MinimumCalculator<Object> {

	/*
	 * Diese Methode gibt den Objekt aus der Liste mit dem minimalen Wert zurück. In
	 * dieser Methode wird die Methode hashCode der Klasse Objekt verwendet um den
	 * absoluten Differenz von den zu vergleichenden Objekten zu bekommen. Diese
	 * Methode hashCode() der Superklasse Object wird in jeder Subklasse
	 * (Weather,Football) anders überschrieben um den entsprechenden absoluten
	 * Differenz zu berechnen
	 */
	public Object getMinimum(List<Object> entities) {

		Object minimum = entities.get(0);
		for (Object entity : entities) {
			if (entity.hashCode() < minimum.hashCode()) {
				minimum = entity;
			}
		}

		return minimum;
	}
}
