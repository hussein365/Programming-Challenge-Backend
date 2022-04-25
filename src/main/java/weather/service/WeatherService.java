package weather.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import weather.entity.Weather;

/*
 * Dies ist die Interface WeatherService ,Sie enthält zwei abstrakte
 * Methoden,die bei WeatherServiceImpl implementiert werden.
 */

public interface WeatherService {

	// Eine abstrakte Methode (für die Implementierung bzw die Kommentierung siehe
	// die WeatherServiceImpl)
	public Page<Weather> uploadCSVFile(Pageable pageable);

	// Eine abstrakte Methode (für die Implementierung bzw die Kommentierung siehe
	// die WeatherServiceImpl)
	public Weather getMin();

}
