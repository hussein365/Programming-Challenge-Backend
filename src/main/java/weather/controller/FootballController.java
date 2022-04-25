package weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import weather.entity.Football;
import weather.service.FootballService;

/*
 * Diese Klasse stellt einen FootballController dar (@RestController Annotation)
 * In dieser Klasse werden die benötigten Apis erstellt.In unserem Fall nur zwei Apis(siehe unten)
 * Sie kann aber um andere Apis erweitert werden.Zum Beispiel : Apis zum Posten (@PostMapping),
 * Deleten (@DeleteMapping) oder zum Updaten (@UpdateMapping) der Football Entity
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FootballController {

	/*
	 * Hier wird das FootballService injeziert(@Autowired Annotation:
	 * Fieldinjection) um Methoden der FootballService aufrufen zu können bei der
	 * Implementierung der Apis.
	 */
	@Autowired
	private FootballService footballService;

	// Hier wird die Api "/footballs" implementiert um alle Football Objekte in
	// einer Page Format zurückzugeben.
	@GetMapping("/footballs")
	public Page<Football> uploadCSVFile(Pageable pageable) {

		return this.footballService.uploadCSVFile(pageable);

	}

	// Hier wird die Api "/minFootball" implementiert um das Football Objekt mit dem
	// minimalen Wert der absoluten Differenz zurückzugeben
	@GetMapping("/minFootball")
	public Football getMin() {
		return this.footballService.getMin();
	}

}
