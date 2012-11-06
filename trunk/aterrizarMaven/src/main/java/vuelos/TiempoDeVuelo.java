package main.java.vuelos;

import java.util.Calendar;

import main.java.fechas.Fecha;
import main.java.fechas.Hora;

public class TiempoDeVuelo {

	private long enDias;
	private long enHoras;
	private long enMinutos;
	private long enSegundos;
	private long enMilisegundos;

	public TiempoDeVuelo(Fecha fechaSalida, Fecha fechaLlegada,
			Hora horaSalida, Hora horaLlegada) {
		calcularTiempoDeVuelo(fechaSalida, fechaLlegada, horaSalida,
				horaLlegada);
	}

	private void calcularTiempoDeVuelo(Fecha fechaSalida, Fecha fechaLlegada,
			Hora horaSalida, Hora horaLlegada) {
		Calendar tiempoSalida = Calendar.getInstance();
		Calendar tiempoLlegada = Calendar.getInstance();

		tiempoSalida.set(fechaSalida.getAnio(), fechaSalida.getMes(),
				fechaSalida.getDia(), horaSalida.getHora(),
				horaSalida.getMinutos());
		tiempoLlegada.set(fechaLlegada.getAnio(), fechaLlegada.getMes(),
				fechaLlegada.getDia(), horaLlegada.getHora(),
				horaLlegada.getMinutos());

		long milisecSalida = tiempoSalida.getTimeInMillis();
		long milisecLlegada = tiempoLlegada.getTimeInMillis();
		long tiempoEnMilisegundos = Math.abs(milisecLlegada - milisecSalida);
		setEnMilisegundos(tiempoEnMilisegundos);
		setEnSegundos(tiempoEnMilisegundos / 1000);
		setEnMinutos(tiempoEnMilisegundos / (60 * 1000));
		setEnHoras(tiempoEnMilisegundos / (60 * 60 * 1000));
		setEnDias(tiempoEnMilisegundos / (24 * 60 * 60 * 1000));
	}

	public long getEnDias() {
		return enDias;
	}

	public void setEnDias(long enDias) {
		this.enDias = enDias;
	}

	public long getEnHoras() {
		return enHoras;
	}

	public void setEnHoras(long enHoras) {
		this.enHoras = enHoras;
	}

	public long getEnMinutos() {
		return enMinutos;
	}

	public void setEnMinutos(long enMinutos) {
		this.enMinutos = enMinutos;
	}

	public long getEnSegundos() {
		return enSegundos;
	}

	public void setEnSegundos(long enSegundos) {
		this.enSegundos = enSegundos;
	}

	public long getEnMilisegundos() {
		return enMilisegundos;
	}

	public void setEnMilisegundos(long enMilisegundos) {
		this.enMilisegundos = enMilisegundos;
	}
	
}
