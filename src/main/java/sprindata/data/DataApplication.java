package sprindata.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sprindata.data.Equipo.EquipoService;
import sprindata.data.Jugador.JugadorService;

@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(DataApplication.class, args);

		context.getBean(EquipoService.class).crearEquipo();
		context.getBean(JugadorService.class).crearJugadores();

		context.getBean(JugadorService.class).consultasJugadores();

		context.getBean(EquipoService.class).consultasEquipos();

	}
}
