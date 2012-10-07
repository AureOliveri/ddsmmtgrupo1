package main.java.busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.java.enumeraciones.ClaseDeAsiento;
import main.java.enumeraciones.DisponibilidadDeAsiento;
import main.java.enumeraciones.UbicacionDeAsiento;

public class Opcionales {
	private List<ClaseDeAsiento> clases;
	private List<UbicacionDeAsiento> ubicaciones;
	private List<DisponibilidadDeAsiento> disponibilidades;
	private BigDecimal precioMin;
	private BigDecimal precioMax;

	public void setOpcionales(ArrayList<ClaseDeAsiento> clases,
			ArrayList<UbicacionDeAsiento> ubicaciones,
			ArrayList<DisponibilidadDeAsiento> disponibilidades,
			BigDecimal precioMin, BigDecimal precioMax) {

		setClases(clases);
		setUbicaciones(ubicaciones);
		setDisponibilidades(disponibilidades);
		setPrecioMin(precioMin);
		setPrecioMax(precioMax);
	}

	public void setPrecioMin(BigDecimal precioMin) {
		this.precioMin = precioMin;
	}

	public BigDecimal getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMax(BigDecimal precioMax) {
		this.precioMax = precioMax;
	}

	public BigDecimal getPrecioMax() {
		return precioMax;
	}

	public void setClases(List<ClaseDeAsiento> clases) {
		this.clases = clases;
	}

	public List<ClaseDeAsiento> getClases() {
		return clases;
	}

	public void setUbicaciones(List<UbicacionDeAsiento> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<UbicacionDeAsiento> getUbicaciones() {
		return ubicaciones;
	}

	public void setDisponibilidades(
			List<DisponibilidadDeAsiento> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

	public List<DisponibilidadDeAsiento> getDisponibilidades() {
		return disponibilidades;
	}

}
