package weather.utils;

import java.io.Reader;

/*Interface zum lesen von Dateien,unterstützt generische Typen.
 * In Diesem Projekt wird diese Interface von der Klasse CsvFileReader implemetiert um CSV Dateien zu lesen.
 * Die Interface kann in der Zukunft von anderen Klassen implementiert werden um zum Beispiel anderen Formaten
 * zu lesen wie zum Beispiel JSON File, XML etc..

*/
public interface Filereader<T> {

	// Diese Methoder gibt den Reader der entsprechenden Klasse zurück.
	public Reader getReader();

}
