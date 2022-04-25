package weather.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import weather.entity.Football;

/*
 * Dies ist die Interface FootballService ,Sie enthält zwei abstrakte
 * Methoden,die bei FootballServiceImpl implementiert werden.
 */

public interface FootballService {

	// Eine abstrakte Methode (für die Implementierung bzw die Kommentierung siehe
	// die FootballServiceImpl)
	public Page<Football> uploadCSVFile(Pageable pageable);

	// Eine abstrakte Methode (für die Implementierung bzw die Kommentierung siehe
	// die FootballServiceImpl)
	public Football getMin();

}
