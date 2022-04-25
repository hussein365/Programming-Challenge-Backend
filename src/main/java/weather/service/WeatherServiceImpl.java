package weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import weather.entity.Weather;
import weather.repository.WeatherRepository;
import weather.utils.CsvFileReader;
import weather.utils.MinimumCalculator;

/*
 * Diese ServiceKlasse (@Service Annotation) implementiert die Interface WeatherService,
 * das heisst es werden in dieser Klasse die abstrakten Methoden implementiert.Diese Klasse kann in
 * der Zukunft um andere Methoden erweitert werden um eine bestimmte Funktionalität
 * zu implementieren.Wenn die App zum beispiel mit einer Datenbank erweitert wird,
 * könnte man Methoden implementieren um Daten aus der Datenbank zu holen bzw in die
 * Datenbank zu speichern.Dafür wird hier die WeatherRepository injeziert um Methoden der
 * JpaRepository<Weather,Integer> aufrufen zu können.
 */

@Service
public class WeatherServiceImpl implements WeatherService {

	// Anhand der @Autowired Annotation wird hier die WeatherRepository
	// injeziert(FieldInjection).
	@Autowired
	private WeatherRepository weatherRepo;

	String fileName = "src/main/resources/weather.csv";

	CsvFileReader<Weather> weatherfilereader = new CsvFileReader(fileName, Weather.class);

	MinimumCalculator<Weather> calculator = new MinimumCalculator<Weather>();

	/*
	 * Diese Methode implementiert die abstrakte Methode uploadCSVFile(Pageable
	 * pageable) der Interfae WeatherService Sie ist dafür da um alle Weather
	 * Obkjekten von der weather.csv Datei in der Form einer Page zurückzugeben.
	 * Rückgabewert wird vom Type Page sein damit man im FrontendApp eine Paginaton
	 * der Daten gewährleisten kann.
	 */
	@Override
	public Page<Weather> uploadCSVFile(Pageable pageable) {

		List<Weather> weathers = this.weatherfilereader.getEntities();

		final int toIndex = Math.min((pageable.getPageNumber() + 1) * pageable.getPageSize(), weathers.size());
		final int fromIndex = Math.max(toIndex - pageable.getPageSize(), 0);

		Page<Weather> page = new PageImpl<Weather>(weathers.subList(fromIndex, toIndex), pageable, weathers.size());

		return page;
	}

	/*
	 * Diese Methode implementiert die abstrakte Methode getMin() der Interface
	 * WeatherService Sie gibt das Weather Objekt mit dem minimalen Wert der
	 * absoluten Differenz (MaxTemp-MinTemp) zurück.
	 */
	@Override
	public Weather getMin() {

		List<Weather> weathers = this.weatherfilereader.getEntities();

		return this.calculator.getMinimum(weathers);

	}

}
