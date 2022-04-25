package weather.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Diese Klasse Football entspricht der Tabelle Football(@Entity Annotation).
 * das heisst jeden Eintrag in der Tabelle wird in einem Objekt dieser Klasse
 * abgebildet wobei die Spalten der Tabelle den Datenfelder der Klasse entsprechen.
 * Erbt von der SuperKlasse Object und die Methode hasCode() wird in dieser Klasse überschrieben
 * um den absoluten Differenz vom Football zu berechnen.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Football extends Object {

	@Id
	@CsvBindByName(column = "Team")
	private String team;

	@CsvBindByName(column = "Games")
	private int games;

	@CsvBindByName(column = "Wins")
	private int wins;

	@CsvBindByName(column = "Losses")
	private int losses;

	@CsvBindByName(column = "Draws")
	private int draws;

	@CsvBindByName(column = "Goals")
	private int goals;

	@CsvBindByName(column = "Goals Allowed")
	private int goalsAllowed;

	@CsvBindByName(column = "Points")
	private int points;

	// Hier wird die hashCode() Methoder der SuperKlasse Object überschieben
	// Diese Methoder gibt den Wert der absoluten Differenz vom Football
	// zurück( absolute Differenz zwischen erzielte und kassierte Tore)
	public int hashCode() {
		return Math.abs(this.goals - this.goalsAllowed);
	}

}
