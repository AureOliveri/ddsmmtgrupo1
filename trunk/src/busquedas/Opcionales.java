package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import enumeraciones.ClaseDeAsiento;
import enumeraciones.UbicacionDeAsiento;
public class Opcionales {
	
	private ClaseDeAsiento primera;
	private ClaseDeAsiento ejecutiva;
	private ClaseDeAsiento turista;
	private UbicacionDeAsiento ventana;
	private UbicacionDeAsiento pasillo;
	private UbicacionDeAsiento centro;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	
	public void setOpcionales(ArrayList<String> clases, ArrayList<String> ubicaciones,
			BigDecimal precioMin, BigDecimal precioMax) {
		for (int j = 0; j < clases.size(); j++) {
			String clase = clases.get(j);
			if (clase.equals(ClaseDeAsiento.PRIMERA.getCodigo()))
				setPrimera(ClaseDeAsiento.PRIMERA);
			if (clase.equals(ClaseDeAsiento.EJECUTIVA.getCodigo()))
				setEjecutiva(ClaseDeAsiento.EJECUTIVA);
			if (clase.equals(ClaseDeAsiento.TURISTA.getCodigo()))
				setTurista(ClaseDeAsiento.TURISTA);
		}
		for (int k = 0; k < ubicaciones.size(); k++) {
			String ubicacion = ubicaciones.get(k);
			if (ubicacion.equals(UbicacionDeAsiento.VENTANA.getCodigo()))
				setVentana(UbicacionDeAsiento.VENTANA);
			if (ubicacion.equals(UbicacionDeAsiento.PASILLO.getCodigo()))
				setPasillo(UbicacionDeAsiento.PASILLO);
			if (ubicacion.equals(UbicacionDeAsiento.CENTRO.getCodigo()))
				setCentro(UbicacionDeAsiento.CENTRO);
		}
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

	public void setPrimera(ClaseDeAsiento primera) {
		this.primera = primera;
	}

	public ClaseDeAsiento getPrimera() {
		return primera;
	}

	public void setEjecutiva(ClaseDeAsiento ejecutiva) {
		this.ejecutiva = ejecutiva;
	}

	public ClaseDeAsiento getEjecutiva() {
		return ejecutiva;
	}

	public void setTurista(ClaseDeAsiento turista) {
		this.turista = turista;
	}

	public ClaseDeAsiento getTurista() {
		return turista;
	}

	public void setVentana(UbicacionDeAsiento ventana) {
		this.ventana = ventana;
	}

	public UbicacionDeAsiento getVentana() {
		return ventana;
	}

	public void setPasillo(UbicacionDeAsiento pasillo) {
		this.pasillo = pasillo;
	}

	public UbicacionDeAsiento getPasillo() {
		return pasillo;
	}

	public void setCentro(UbicacionDeAsiento centro) {
		this.centro = centro;
	}

	public UbicacionDeAsiento getCentro() {
		return centro;
	}
	
	
	
}
