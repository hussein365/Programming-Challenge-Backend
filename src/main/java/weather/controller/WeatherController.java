package weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import weather.entity.Weather;
import weather.service.WeatherService;

/*
 * Diese Klasse stellt einen WeatherController dar (@RestController Annotation)
 * In dieser Klasse werden die benötigten Apis erstellt.In unserem Fall nur zwei Apis(siehe unten)
 * Sie kann aber um andere Apis erweitert werden.Zum Beispiel : Apis zum Posten (@PostMapping),
 * Deleten (@DeleteMapping) oder zum Updaten (@UpdateMapping) der Weather Entity
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WeatherController {

	/*
	 * Hier wird das WeatherService injeziert(@Autowired Annotation: Fieldinjection)
	 * um Methoden der WeatherService aufrufen zu können bei der Implementierung der
	 * Apis.
	 */
	@Autowired
	private WeatherService weatherService;

	// Hier wird die Api "/weathers" implementiert um alle Weather Objekte in einer
	// Page Format zurückzugeben.
	@GetMapping("/weathers")
	public Page<Weather> uploadCSVFile(Pageable pageable) {

		return this.weatherService.uploadCSVFile(pageable);

	}

	// Hier wird die Api "/minWeather" implementiert um das Weather Objekt mit dem
	// minimalen Wert der absoluten Differenz zurückzugeben
	@GetMapping("/minWeather")
	public Weather getMin() {
		return this.weatherService.getMin();
	}

}
