package weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import weather.entity.Weather;

/*
 * Repository der Entity Weathe (@Repository Annotation),erbt von JpaRepository mit den entsprechenden generischen Typen
 * <Weather,Integer> : Weather: für den Typ der Entity, Integer: für den Typ der primarykey des Entitys
 * Diese Repository wird verwendet wenn man das Projekt zum Beispiel erweitert sodass die Daten nicht nur aus CSV Dateien
 * gelesen werden sondern auch aus einer Datenbank.Dann wird jeder Tabelle in einer Entitiy abgebildet und anhand dieser Repo
 * kann man Methoden wie zum Beispiel findAll(),findById(),save(),deleteById() usw.. für die Entity Weather aufrufen
 * um danach zum Beispiel Rest Apis zu erstellen 
*/
@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
