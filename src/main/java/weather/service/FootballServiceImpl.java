package weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import weather.entity.Football;
import weather.repository.FootballRepository;
import weather.utils.CsvFileReader;
import weather.utils.MinimumCalculator;

/*
 * Diese ServiceKlasse (@Service Annotation) implementiert die Interface FootballService,
 * das heisst es werden in dieser Klasse die abstrakten Methoden implementiert.Diese Klasse kann in
 * der Zukunft um andere Methoden erweitert werden um eine bestimmte Funktionalität
 * zu implementieren.Wenn die App zum beispiel mit einer Datenbank erweitert wird,
 * könnte man Methoden implementieren um Daten aus der Datenbank zu holen bzw in die
 * Datenbank zu speichern.Dafür wird hier die FootballRepository injeziert um Methoden der
 * JpaRepository<Football,String> aufrufen zu können.
 */

@Service
public class FootballServiceImpl implements FootballService {

	// Anhand der @Autowired Annotation wird hier die FootballRepository
	// injeziert(FieldInjection).
	@Autowired
	private FootballRepository footballRepo;

	String fileName = "src/main/resources/football.csv";

	CsvFileReader<Football> footballfilereader = new CsvFileReader(fileName, Football.class);

	MinimumCalculator<Football> calculator = new MinimumCalculator<Football>();

	/*
	 * Diese Methode implementiert die abstrakte Methode uploadCSVFile(Pageable
	 * pageable) der Interfae FootballService Sie ist dafür da um alle Football
	 * Obkjekten von der football.csv Datei in der Form einer Page zurückzugeben.
	 * Rückgabewert wird vom Type Page sein damit man im FrontendApp eine Paginaton
	 * der Daten gewährleisten kann.
	 */
	@Override
	public Page<Football> uploadCSVFile(Pageable pageable) {

		List<Football> footballs = this.footballfilereader.getEntities();

		final int toIndex = Math.min((pageable.getPageNumber() + 1) * pageable.getPageSize(), footballs.size());
		final int fromIndex = Math.max(toIndex - pageable.getPageSize(), 0);

		Page<Football> page = new PageImpl<Football>(footballs.subList(fromIndex, toIndex), pageable, footballs.size());

		return page;
	}

	/*
	 * Diese Methode implementiert die abstrakte Methode getMin() der Interface
	 * FootballService Sie gibt das Football Objekt mit dem minimalen Wert der
	 * absoluten Differenz (Goals-GoalsAllowed) zurück.
	 */
	@Override
	public Football getMin() {

		List<Football> footballs = this.footballfilereader.getEntities();

		return this.calculator.getMinimum(footballs);

	}

}
