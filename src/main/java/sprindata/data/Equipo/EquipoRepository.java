package sprindata.data.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {


	List<Equipo> findEquipoByLocalidad(String localidad);

}
