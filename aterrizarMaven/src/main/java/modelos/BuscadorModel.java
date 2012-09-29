package main.java.modelos;

import java.util.ArrayList;

import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;


@Observable
public class BuscadorModel {
	private Buscador buscador = Buscador.getInstance();
	private Usuario usuario ;
	private Busqueda busqueda = new Busqueda();
	private String fecha;
	private Asiento asientoSeleccionado;
	private Boolean habilitado = false;
	
	public BuscadorModel(Usuario usuario) {
		this.usuario = usuario;
	}

	public void search() {
		validar();
		ArrayList<Asiento> asientos = buscador.buscarAsientos(this.busqueda, this.usuario);
		this.busqueda.setResultado(asientos);
		buscador.mostrarAsientos(busqueda.getResultado(), usuario.getTipoUsuario());
	}
	
	private void validar() {
		if (!this.ingresoOrigen())
			throw new UserException("Falta ingresar origen");
		if (!this.ingresoDestino())
			throw new UserException("Falta ingresar destino");
		if (!this.ingresoFecha())
			throw new UserException("Falta ingresar fecha");
		if (!this.cumpleFormatoFecha())
			throw new UserException("El formato correcto es dd/mm/aaaa");
	}
	
	private void validarFechaString(String fecha) {
		if (fecha.length() < 10)
			throw new UserException("La cadena ingresada es muy corta");
	}

	private boolean ingresoOrigen() {
		return this.busqueda.getOrigen() != null;
	}
	
	private boolean ingresoDestino() {
		return this.busqueda.getDestino() != null;
	}
	
	private boolean ingresoFecha() {
		return this.busqueda.getFechaV() != null;
	}
	
	private boolean cumpleFormatoFecha() {
		return this.busqueda.getFechaV().esFormatoLatinoamericano(this.busqueda.getFechaV().getFechaS());
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

	public void setFecha(String fecha) {
		validarFechaString(fecha);
		this.busqueda.setFecha(fecha);
	}

	public String getFecha() {
		return fecha;
	}
	
 
}
