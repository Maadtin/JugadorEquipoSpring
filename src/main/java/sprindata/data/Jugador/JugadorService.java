package sprindata.data.Jugador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sprindata.data.Equipo.EquipoRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class JugadorService {

	@Autowired
	private JugadorRepository jugadorRepository;

	@Autowired
	private EquipoRepository equipoRepository;

	public void crearJugadores () {

		Jugador martin  = new Jugador("Martin", LocalDate.of(1995,7,28), 30, 8, 8, "delantero");
		Jugador angelo  = new Jugador( "Angelo", LocalDate.of(2005,7,28), 10, 8, 30, "medio central" );
		Jugador rusty  = new Jugador( "Rusty", LocalDate.of(1990,7,28), 10, 8, 20, "portero" );
		Jugador albert  = new Jugador( "Albert", LocalDate.of(2001,7,28), 40, 55, 8, "lateral" );
		Jugador lol  = new Jugador( "lol", LocalDate.of(2003,7,2), 10, 55, 8, "portero");

		Jugador pedro  = new Jugador( "Pedro", LocalDate.of(2003,7,2), 10, 55, 8, "portero");
		Jugador manuel  = new Jugador( "Manuel", LocalDate.of(2003,7,2), 10, 55, 8, "medio central");
		Jugador pepe  = new Jugador( "Pepe", LocalDate.of(2003,7,2), 10, 55, 8, "lateral");
		Jugador armando  = new Jugador( "Armando", LocalDate.of(2003,7,2), 10, 55, 8, "lateral");
		Jugador carlos  = new Jugador( "Carlos", LocalDate.of(2003,7,2), 10, 55, 8, "medio central");

		Jugador diego  = new Jugador( "Diego", LocalDate.of(1995,7,28), 10, 5, 8, "defensa" );
		Jugador borja  = new Jugador( "Borja", LocalDate.of(1995,7,28), 10, 5, 8, "defensa" );
		Jugador bryan  = new Jugador( "Bryan", LocalDate.of(1995,7,28), 10, 5, 8, "lateral" );
		Jugador felipe  = new Jugador( "Felipe", LocalDate.of(1995,7,28), 10, 5, 8, "portero" );
		Jugador tomas  = new Jugador( "Tomas", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );


		Jugador alberto  = new Jugador( "Alberto", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );
		Jugador yaoming  = new Jugador( "Yaoming", LocalDate.of(1995,7,28), 10, 5, 8, "portero" );
		Jugador junior  = new Jugador( "Junior", LocalDate.of(1995,7,28), 10, 5, 8, "lateral" );
		Jugador cesar  = new Jugador( "Cesar", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );
		Jugador huni  = new Jugador( "Huni", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );

		Jugador eric  = new Jugador( "Eric", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );
		Jugador jose  = new Jugador( "Jose", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );
		Jugador miguel  = new Jugador( "Miguel", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );
		Jugador jaime  = new Jugador( "Jaime", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );
		Jugador alexander  = new Jugador( "Alexander", LocalDate.of(1995,7,28), 10, 5, 8, "animadora" );

		Jugador[] jugadores  = {
						martin, angelo, rusty, albert, lol,
						pedro, manuel, pepe, armando, carlos,
						diego, borja, bryan, felipe, tomas,
						alberto, yaoming, junior, cesar, huni,
						eric, jose, miguel, jaime, alexander
		};

		for (int i = 0; i < jugadores.length; i++) {
			if (i < 5)
				jugadores[i].setEquipo(equipoRepository.findOne(1L));
			else if (i >= 5 && i <10)
				jugadores[i].setEquipo(equipoRepository.findOne(2L));
			else if (i >=10 && i < 15)
				jugadores[i].setEquipo(equipoRepository.findOne(3L));
			else if (i >= 15 && i <20)
				jugadores[i].setEquipo(equipoRepository.findOne(4L));
			else if (i >=20 && i <25)
				jugadores[i].setEquipo(equipoRepository.findOne(5L));
		}

		jugadorRepository.save(Arrays.asList(jugadores));

	}

	public void consultasJugadores () {

		System.out.println("Jugadores con el nombre Martin");
		for (Jugador jugador: jugadorRepository.findByNombre("Martin")) {
			System.out.println(jugador);
		}

		System.out.println("Jugadores con el número de canastas mayor o iguales que 5");
		for (Jugador jugador: jugadorRepository.findByNumCanastasGreaterThanEqual(5)) {
			System.out.println(jugador);
		}

		System.out.println("Jugador con número de canastas entre 5 y 8");
		for (Jugador jugador: jugadorRepository.findByNumCanastasBetween(5, 8)) {
			System.out.println(jugador);
		}

		System.out.println("Jugadores cuya posición es Delantero");
		for (Jugador jugador: jugadorRepository.findByPosicion("delantero")) {
			System.out.println(jugador);
		}

		System.out.println("Jugadores que nacieron antes del 1995/07/28");
		for (Jugador jugador: jugadorRepository.findByFechaNacimientoBefore(LocalDate.of(1995, 7, 28))) {
			System.out.println(jugador);
		}

		List<Object[]> aaa = jugadorRepository.findMediaAgrupados();

		System.out.println("Media de posiciones agrupados por posicion: ");
		for (Object[] stat: aaa) {
			System.out.println("Posición: "+ stat[3]);
			System.out.println("Número asistencias Media: "+ stat[0]);
			System.out.println("Número canastas Media: "+ stat[1]);
			System.out.println("Número rebotes Media: "+ stat[2]);
		}

		System.out.println("Maximo y minimo de estadisticas: ");
		List<Object[]> lista = jugadorRepository.findMaximoMinimoStats();

		for(Object[] minmax: lista) {
			for(Object minmaxx: minmax) {
				System.out.println(minmaxx);
			}
		}

		System.out.println("Lista de jugadores de lakers");
		for(Jugador aa: jugadorRepository.findByEquipoNombreEquipo("Lakers")) {
			System.out.println(aa);
		}
		
		
		System.out.println("Lista de jugadores de Los Lakers que son PORTEROS");
		for (Jugador jugador : jugadorRepository.findByEquipoNombreEquipoAndPosicionEquals("Lakers", "portero")) {
			System.out.println(jugador);
		}

		
		System.out.println("**************** JUGADOR CON MÁS CANASTAS DEL EQUIPO LAKERS ****************");
		System.out.println(jugadorRepository.findJugadorByEquipoAndMaxCanastas("Lakers", new PageRequest(0, 1))); ;
		System.out.println("****************************************************");













	}

}
