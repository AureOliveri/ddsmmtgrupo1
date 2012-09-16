package main.java.fechas;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	private int fechaFinal;
	private String fechaActual;
	private String fechaS;
	private String formato;
	private Map<Integer, Integer> diasPorMes = new HashMap<Integer, Integer>();

	public Fecha(String fechaString) {

		setFechaS(fechaString);
		fechaString = fechaString.replaceAll(" ", "");

		if (esFormatoISO8601(fechaString)) {
			this.crearFecha(fechaString.substring(0, 4),
					fechaString.substring(5, 7), fechaString.substring(8, 10),
					"ISO8601");
		} else if (esFormatoLatinoamericano(fechaString)) {
			this.crearFecha(fechaString.substring(6, 10),
					fechaString.substring(3, 5), fechaString.substring(0, 2),
					"Latinoamericano");
		} else if (esFormatoNorteamericano(fechaString)) {
			this.crearFecha(fechaString.substring(6, 10),
					fechaString.substring(0, 2), fechaString.substring(3, 5),
					"Norteamericano");
		} else {
			throw new parserException(
					"La cadena ingresada no concuerda con ningun formato valido");
		}

		diasPorMes.put(1, 31);
		if (esBiciesto()) {
			diasPorMes.put(2, 29);
		} else {
			diasPorMes.put(2, 28);
		}
		diasPorMes.put(3, 31);
		diasPorMes.put(4, 30);
		diasPorMes.put(5, 31);
		diasPorMes.put(6, 30);
		diasPorMes.put(7, 31);
		diasPorMes.put(8, 31);
		diasPorMes.put(9, 30);
		diasPorMes.put(10, 31);
		diasPorMes.put(11, 30);
		diasPorMes.put(12, 31);

		if (mes > 12 || dia > this.diasPorMes.get(mes)) {
			throw new RuntimeException();
		}

	}

	private void crearFecha(String anio, String mes, String dia, String formato) {
		this.convertirStringAFecha(anio, mes, dia, formato);
		this.formato = formato;
	}

	public boolean esAnteriorQue(Fecha otraFecha) {
		return this.obtenerDias() < otraFecha.obtenerDias();
	}

	public boolean esMenorIgualQue(Fecha otraFecha) {
		return this.obtenerDias() <= otraFecha.obtenerDias();
	}

	public boolean esMayorIgualQue(Fecha otraFecha) {
		return this.obtenerDias() >= otraFecha.obtenerDias();
	}

	public void convertirStringAFecha(String anio, String mes, String dia,
			String formato) {
		this.anio = Integer.parseInt(anio);
		this.mes = Integer.parseInt(mes);
		this.dia = Integer.parseInt(dia);
		this.setFormato(formato);
		return;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	}

	public int getAnio() {
		return anio;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int getFecha() {
		return fechaFinal;
	}

	public Fecha() {
		Calendar fechaActual = Calendar.getInstance();
		String fechaS = Integer.toString(fechaActual.get(Calendar.DATE)) + "/"
				+ Integer.toString(fechaActual.get(Calendar.MONTH) + 1) + "/"
				+ Integer.toString(fechaActual.get(Calendar.YEAR));
		Fecha fecha = new Fecha(fechaS);
	}

	public boolean esFormatoISO8601(String fechaS) {
		return (fechaS.substring(4, 5).equals("-"))
				&& (fechaS.substring(7, 8).equals("-"));
	}

	public boolean esFormatoLatinoamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("/"))
				&& ((fechaS.substring(5, 6).equals("/")));
	}

	public boolean esFormatoNorteamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("-"))
				&& ((fechaS.substring(5, 6).equals("-")));
	}

	public int obtenerDias() {
		int dias = this.getDia() + this.getAnio() * 365;
		dias += ((this.getAnio() - 1) % 4);
		for (int i = 1; (i < this.getMes() - 1); i++) {
			dias += diasPorMes.get(i);
		}
		return dias;
	}

	public int diferenciaDeDiasCon(Fecha otraFecha) {
		int totalDiasFecha;
		int totalDiasOtraFecha;
		int difDias;
		totalDiasFecha = this.obtenerDias();
		totalDiasOtraFecha = otraFecha.obtenerDias();
		difDias = totalDiasFecha - totalDiasOtraFecha;
		if (this.esAnteriorQue(otraFecha)) {
			System.out.println("La cantidad de dias entre fechas es: "
					+ (difDias * -1));
			return (difDias * -1);

		} else if (!this.esAnteriorQue(otraFecha)) {
			System.out.println("La cantidad de dias entre fechas es: "
					+ difDias);
			return (difDias);
		} else {
			System.out.println("Las fechas son iguales.");
			return 0;
		}
	}

	public boolean esBiciesto() {
		return (this.anio % 4 == 0);
	}

	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}

	public String getFechaS() {
		return fechaS;
	}

	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getFechaActual() {
		return fechaActual;
	}

}
