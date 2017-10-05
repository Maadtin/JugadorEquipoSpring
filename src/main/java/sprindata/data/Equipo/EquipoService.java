package sprindata.data.Equipo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EquipoService {

	@Autowired
	private EquipoRepository equipoRepository;

	public void crearEquipo () {

		Equipo lakers = new Equipo("Lakers", "Los angeles", LocalDate.of(1995, 8, 8));
		Equipo baskonia = new Equipo("Baskonia", "Los angeles", LocalDate.of(1995, 8, 8));
		Equipo bulls = new Equipo("Bulls", "San Francisco", LocalDate.of(1995, 8, 8));
		Equipo tornado = new Equipo("Tornado", "Miami", LocalDate.of(1995, 8, 8));
		Equipo huracan = new Equipo("Huracán", "Florida", LocalDate.of(1995, 8, 8));

		equipoRepository.save(lakers);
		equipoRepository.save(baskonia);
		equipoRepository.save(bulls);
		equipoRepository.save(tornado);
		equipoRepository.save(huracan);

	}

	public void consultasEquipos () {

			System.out.println("Lista de equipos de Los angeles");
			for (Equipo listaEquipos : equipoRepository.findEquipoByLocalidad("Los angeles")) {
				System.out.println(listaEquipos);
			}

//			System.out.println("Lista de jugadores de Los lakers");
//
//			for (Equipo listaJugadores : equipoRepository.findByNombreEquipo("Lakers")) {
//				System.out.println(listaJugadores);
//			}


	}

}
