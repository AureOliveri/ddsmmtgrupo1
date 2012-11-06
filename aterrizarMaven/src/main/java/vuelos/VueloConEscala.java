package main.java.vuelos;

import main.java.enumeraciones.Ciudad;

public class VueloConEscala extends Vuelo{
	private Ciudad escala;

	public VueloConEscala(Vuelo unVuelo, Vuelo vueloQueHaceEscalaConVos) {
		setFechaSalida(unVuelo.getFechaSalida()) ;
		setFechaLlegada(vueloQueHaceEscalaConVos.getFechaLlegada());
		setHoraSalida(unVuelo.getHoraSalida());
		setHoraLlegada(vueloQueHaceEscalaConVos.getHoraLlegada());
		setDestino(vueloQueHaceEscalaConVos.getDestino());
		setOrigen(unVuelo.getOrigen());
		setTipoVuelo("Con Escala");
		setEscala(unVuelo.getDestino());
		setTiempoDeVuelo(new TiempoDeVuelo(fechaSalida, fechaLlegada, horaSalida, horaLlegada));
	}

	public void setEscala(Ciudad escala) {
		this.escala = escala;
	}

	public Ciudad getEscala() {
		return escala;
	}
	
}
