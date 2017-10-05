package sprindata.data.Jugador;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

	// a
	List<Jugador> findByNombre(String nombre);
	//b
	List<Jugador> findByNumCanastasGreaterThanEqual(Integer numCanastas);
	// c
	List<Jugador> findByNumCanastasBetween(Integer min, Integer max);
	//d
	List<Jugador> findByPosicion(String pos);
	//e
	List<Jugador> findByFechaNacimientoBefore(LocalDate fecha);
	// f

	List<Jugador> findByEquipoNombreEquipo(String nombreEquipo);

	List<Jugador> findByEquipoNombreEquipoAndPosicionEquals(String nombreEquipo, String pos);


	@Query("SELECT AVG (numCanastas), AVG(numAsistencias), AVG(numRebotes), posicion FROM Jugador GROUP BY posicion")
	List<Object[]> findMediaAgrupados ();


	@Query("SELECT posicion, concat('Max num canastas : ', max(numCanastas), ' ---- Min num canastas: ', min(numCanastas)), concat('Max num asistencias: ', max(numAsistencias), ' ---- Min num asistencias: ', min(numAsistencias)), concat('Max num rebotes: ', max(numRebotes), ' ---- Min num rebotes: ', min(numRebotes)) from Jugador group by posicion")
	List<Object[]> findMaximoMinimoStats ();


	// Jugador de los LAKERS  que tiene más CANASTAS
	@Query("SELECT j from Jugador j WHERE j.equipo.nombreEquipo = :nom ORDER BY j.numCanastas DESC")
	List<Jugador> findJugadorByEquipoAndMaxCanastas(
					@Param("nom") String nom, Pageable page
	);

}
