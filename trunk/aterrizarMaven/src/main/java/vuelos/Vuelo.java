package main.java.vuelos;

import java.util.ArrayList;



import main.java.enumeraciones.Ciudad;
import main.java.enumeraciones.DisponibilidadDeAsiento;
import main.java.fechas.Fecha;
import main.java.fechas.Hora;
import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioEstandar;

import main.java.aerolineas.Aerolinea;
import main.java.aerolineas.Aerolineas;
import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;

public class Vuelo {
	protected Hora horaLlegada;
	protected Hora horaSalida;
	protected Ciudad origen;
	protected Ciudad destino;
	protected Fecha fechaLlegada;
	protected Fecha fechaSalida;
	protected String numeroDeVuelo;
	private Aerolinea aerolinea;
	protected TiempoDeVuelo tiempoDeVuelo;
	private int popularidad;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	protected String tipoVuelo;
	
	public Vuelo() {}
	
	public Vuelo(String horaLlegada, String horaSalida, String origen,
			String destino, String fechaSalida, String fechaLlegada,
			String numeroDeVuelo, Aerolinea aerolinea) {
		super();
		setHoraLlegada(new Hora(horaLlegada));
		setHoraSalida(new Hora(horaSalida));
		setOrigen(Ciudad.obtenerCiudad(origen));
		setDestino(Ciudad.obtenerCiudad(destino));
		setFechaLlegada(new Fecha(fechaLlegada));
		setFechaSalida(new Fecha(fechaSalida));
		setNumeroDeVuelo(numeroDeVuelo);
		setAerolinea(aerolinea);
		setTiempoDeVuelo(new TiempoDeVuelo(this.fechaSalida, this.fechaLlegada,
								        this.horaSalida, this.horaLlegada));
		setTipoVuelo("Directo");
	}

	public boolean yaNoEstasDisponible(Asiento unAsiento) {
		return (unAsiento.getDisponibilidad() == DisponibilidadDeAsiento.RESERVADO);
	}
	
	public void addAsiento(Asiento a) {
		this.asientos.add(a);
	}
	
	 /* SETTERS*/
	 
	 public void setOrigen(Ciudad origenASetear){
	  this.origen = origenASetear;
	 }
	 
	 public void setDestino(Ciudad destinoAsetear){
	  this.destino = destinoAsetear;
	 } 
	 
	 public void setNumeroDeVuelo(String numeroDeVuelo) {
			this.numeroDeVuelo = numeroDeVuelo;
	}
	 

	 /*GETTERS*/
	 public Ciudad getOrigen(){
	  return this.origen;
	 }
	 
	 public Ciudad getDestino(){
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

	public boolean esVueloConEscala(Ciudad origenInicial, Ciudad destinoFinal) {
		
		for (Vuelo unVuelo : Aerolineas.getVuelosAerolineas()) {
			if( 
			this.origen == origenInicial &&
			unVuelo.origen != this.origen && 
			unVuelo.origen == this.destino &&
			unVuelo.destino == destinoFinal){
				return true;
				
			}
		}
		return false;
	}
	public Vuelo getVueloQueHaceEscalaConVos(){
		
		for (Vuelo unVuelo : Aerolineas.getVuelosAerolineas()) {
			if( 
			unVuelo.origen != this.origen && 
			unVuelo.origen == this.destino){
				return unVuelo;
			}
		}
		return null;
	}
	
	public ArrayList<Escala> obtenerEscala(Ciudad origen, Ciudad destino ){
		ArrayList<Vuelo> vueloOrigen = new ArrayList<Vuelo>();
		ArrayList<Escala> escalasObtenidas = new ArrayList<Escala>();
		for(Vuelo vuelo : Aerolineas.getVuelosAerolineas()){
			if(vuelo.origen.equals(origen)) vueloOrigen.add(vuelo);
		}
		Buscador buscador = new Buscador();
		for(Vuelo vuelo: vueloOrigen){
			Busqueda busqueda = new Busqueda(vuelo.getDestino(), null, destino, null);
			ArrayList<Asiento> asientoDestino = buscador.buscarAsientos(busqueda, new Usuario("Nombre", "30000000", new UsuarioEstandar()));
			ArrayList<Vuelo> vueloDestino = new ArrayList<Vuelo>();
			for(Asiento asiento : asientoDestino){
				vueloDestino.add(asiento.getVuelo());
			}
			for(Vuelo vueloFinal : vueloDestino){
				Escala escala = new Escala(vuelo, vueloFinal);
				escalasObtenidas.add(escala);
			}
		}
		return escalasObtenidas;		
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}
}
