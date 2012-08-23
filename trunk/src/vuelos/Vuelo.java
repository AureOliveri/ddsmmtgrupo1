package vuelos;

import java.util.ArrayList;

import enumeraciones.DisponibilidadDeAsiento;
import fechas.Fecha;
import fechas.Hora;

import aerolineas.Aerolinea;


public class Vuelo {

	private Hora horaLlegada;
	private Hora horaSalida;
	private String origen;
	private String destino;
	private Fecha fechaLlegada;
	private Fecha fechaSalida;
	private String numeroDeVuelo;
	private Aerolinea aerolinea;
	private TiempoDeVuelo tiempoDeVuelo;
	private int popularidad;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	
	public Vuelo() {}
	
	public Vuelo(String horaLlegada, String horaSalida, String origen,
			String destino, String fechaSalida, String fechaLlegada,
			String numeroDeVuelo, Aerolinea aerolinea) {
		super();
		this.setHoraLlegada(new Hora(horaLlegada));
		this.setHoraSalida(new Hora(horaSalida));
		this.origen = origen;
		this.destino = destino;
		this.setFechaLlegada(new Fecha(fechaLlegada));
		this.setFechaSalida(new Fecha(fechaSalida));
		this.numeroDeVuelo = numeroDeVuelo;
		this.aerolinea = aerolinea;
		this.setTiempoDeVuelo(new TiempoDeVuelo(this.fechaSalida, this.fechaLlegada, this.horaSalida, this.horaLlegada));
		
	}

	public boolean yaNoEstasDisponible(Asiento unAsiento) {
		return (unAsiento.getDisponibilidad() == DisponibilidadDeAsiento.RESERVADO);
	}
	
	public void addAsiento(Asiento a) {
		this.asientos.add(a);
	}
	 
	 /* SETTERS*/
	 
	 public void setOrigen(String origenASetear){
	  this.origen = origenASetear;
	 }
	 
	 public void setDestino(String destinoAsetear){
	  this.destino = destinoAsetear;
	 } 
	 
	 public void setNumeroDeVuelo(String numeroDeVuelo) {
			this.numeroDeVuelo = numeroDeVuelo;
	}
	 

	 /*GETTERS*/
	 public String getOrigen(){
	  return this.origen;
	 }
	 
	 public String getDestino(){
	  return this.destino;
	 } 
	 
	 public String getNumeroDeVuelo() {
		 return numeroDeVuelo;
	 }

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void setFechaLlegada(Fecha fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Fecha getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaSalida(Fecha fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Fecha getFechaSalida() {
		return fechaSalida;
	}

	public void setHoraLlegada(Hora horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Hora getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraSalida(Hora horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Hora getHoraSalida() {
		return horaSalida;
	}

	public void setTiempoDeVuelo(TiempoDeVuelo tiempoDeVuelo) {
		this.tiempoDeVuelo = tiempoDeVuelo;
	}

	public TiempoDeVuelo getTiempoDeVuelo() {
		return tiempoDeVuelo;
	}

	public void setPopularidad(int popularidad) {
		this.popularidad = popularidad;
	}

	public int getPopularidad() {
		return popularidad;
	}

}
