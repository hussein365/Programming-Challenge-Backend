package weather.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Diese Klasse Weather entspricht der Tabelle Weather(@Entity Annotation).
 * das heisst jeden Eintrag in der Tabelle wird in einem Objekt dieser Klasse
 * abgebildet wobei die Spalten der Tabelle den Datenfelder der Klasse entsprechen.
 * Erbt von der SuperKlasse Object und die Methode hasCode() wird in dieser Klasse überschrieben
 * um den absoluten Differenz vom Weather zu berechnen.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Weather extends Object {

	@Id
	@CsvBindByName(column = "Day")
	private int day;

	@CsvBindByName(column = "MxT")
	private int mxt;

	@CsvBindByName(column = "MnT")
	private int mnt;

	@CsvBindByName(column = "AvT")
	private int avt;

	@CsvBindByName(column = "AvDP")
	private double avDP;

	@CsvBindByName(column = "1HrP TPcpn	")
	private int hrPTPcpn;

	@CsvBindByName(column = "PDir")
	private int pDir;

	@CsvBindByName(column = "AvSp")
	private double avSp;

	@CsvBindByName(column = "Dir")
	private int dir;

	@CsvBindByName(column = "MxS")
	private int mxS;

	@CsvBindByName(column = "SkyC")
	private double skyC;

	@CsvBindByName(column = "MxR")
	private int mxR;

	@CsvBindByName(column = "Mn")
	private int mn;

	@CsvBindByName(column = "R AvSLP")
	private double rAvSLP;

	// Hier wird die hashCode() Methoder der SuperKlasse Object überschieben
	// Diese Methoder gibt den Wert der absoluten Differenz vom Weather
	// zurück( Differenz zwischen maximale und minimale Temperatur)
	public int hashCode() {
		return this.mxt - this.mnt;
	}

}
