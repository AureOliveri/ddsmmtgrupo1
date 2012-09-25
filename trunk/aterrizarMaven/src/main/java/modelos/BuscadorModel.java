package main.java.modelos;

import java.util.ArrayList;

import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;
import main.java.fechas.Fecha;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

import org.uqbar.commons.utils.Observable;


@Observable
public class BuscadorModel {
	private Buscador buscador = Buscador.getInstance();
	private Usuario usuario ;
	private Busqueda busqueda = new Busqueda();
	private Asiento asientoSeleccionado;
	private Boolean habilitado = false;
	
	public BuscadorModel(Usuario usuario) {
		this.usuario = usuario;
	}

	public void search() {
//		ArrayList<Asiento> asientos = buscador.getAerolineas().getAsientosAerolineas();
		ArrayList<Asiento> asientos = buscador.buscarAsientos(this.busqueda, this.usuario);
		this.busqueda.setResultado(asientos);
		buscador.mostrarAsientos(busqueda.getResultado(), usuario.getTipoUsuario());
	}
	
	public void setOrigen(String origenASetear) {
		this.busqueda.setOrigen(origenASetear);
	}
	
	public String getOrigen(){
		return this.busqueda.getOrigen();
	}
	
	public void setDestino(String destinoASetear) {
		this.busqueda.setDestino(destinoASetear);
	}
	
	public String getDestino(){
		return this.busqueda.getDestino();
	}
	public void setFecha(Fecha fechaV) {
		this.busqueda.setFechaV(fechaV);
	}
	
	public Fecha getFecha(){
		return this.busqueda.getFechaV();
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}
	
	public Busqueda getBusqueda() {
		return busqueda;
	}
	
	public void setAsientoSeleccionado(Asiento asientoSeleccionado) {
		this.asientoSeleccionado = asientoSeleccionado;
	}
	
	public Asiento getAsientoSeleccionado() {
		return asientoSeleccionado;
	}
	
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Boolean getHabilitado() {
		return habilitado;
	}
}
