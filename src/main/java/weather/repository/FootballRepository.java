package weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import weather.entity.Football;

/*
 * Repository für die Entity Football (@Repository Annotation) mit dem Primarykey vom Typ String 
 * analog zum WeatherRepository
 */

@Repository
public interface FootballRepository extends JpaRepository<Football, String> {

}
