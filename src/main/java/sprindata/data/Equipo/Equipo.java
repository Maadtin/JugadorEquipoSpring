package sprindata.data.Equipo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Equipo {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String nombreEquipo;
	private String localidad;
	private LocalDate fechaCreacion;

	public Equipo () {

	}

	public Equipo(String nombreEquipo, String localidad, LocalDate fechaCreacion) {
	this.nombreEquipo = nombreEquipo;
	this.localidad = localidad;
	this.fechaCreacion = fechaCreacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Equipo equipo = (Equipo) o;

		if (id != equipo.id) return false;
		if (nombreEquipo != null ? !nombreEquipo.equals(equipo.nombreEquipo) : equipo.nombreEquipo != null) return false;
		if (localidad != null ? !localidad.equals(equipo.localidad) : equipo.localidad != null) return false;
		return fechaCreacion != null ? fechaCreacion.equals(equipo.fechaCreacion) : equipo.fechaCreacion == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (nombreEquipo != null ? nombreEquipo.hashCode() : 0);
		result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
		result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
		return result;
	}

	@Override
	public String toString () {

		String output = "Id: " + this.getId() + "\n";
		output += "Nombre Equpipo: " + this.getNombreEquipo() + "\n";
		output += "Localidad: " + this.getLocalidad() + "\n";
		output += "Fecha de creación: " + this.getFechaCreacion() + "\n";

		return output;

	}

}
