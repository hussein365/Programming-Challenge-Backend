package weather.utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.Getter;
import lombok.Setter;

/*
 * Diese Klasse stellt eine Implementierung der Interface FileReader
 * zum lesen von CSV Dateien dar.
 * Sie unterstützt generische Typen und kann benutzt werden um
 * verschiedenen CSV Dateien zu lesen.Man braucht nur eine Klasse(Entity)
 * für jeden CSV Datei(Tabelle) zu erstellen um jede Tabelle in einer Entity abzubilden
 * wobei die Spalten der Tabelle der Datenfelder der Entity entsprechen.
 * Dann wird jeweils ein Objekt aus dieser Klasse erstellt mit den entsprechenden Klassentyp
 * (zum Beispiel: Weather,Football) um den CSV Datei zu lesen und die Daten der Tabelle in einer
 * Liste von Objekten zu speichern( Beispiel: List<Weather>)
 */

@Getter
@Setter
public class CsvFileReader<T> implements Filereader<String> {

	private Reader reader;

	private List<T> entities;

	/*
	 * Konstruktor zum erzeugen eines Objekts dieser Klasse,erwartet als Parameter
	 * ein String fileName(der path der CSV Datei) und den Klassentyp der jeweiligen
	 * Entity. Initialisiert der Datenfelder der Klasse mit den entsprechenden
	 * Werten Anhand @Getter @Setter von Lombook könnte man auf diesen Datenfelder
	 * zugreifen bzw die ändern.
	 */
	public CsvFileReader(String fileName, Class<T> target) {

		try (Reader reader = new FileReader(fileName)) {

			this.reader = reader;

			// Erzeugen eines csv bean reader
			CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader).withType(target).withIgnoreLeadingWhiteSpace(true)
					.build();

			// Umwandeln der `CsvToBean` Objekt zu einer Liste von T.Diese Liste wird dem
			// Datenfeld entities zugewiesen.
			entities = csvToBean.parse();

		} catch (Exception ex) {
		}

	}

}
