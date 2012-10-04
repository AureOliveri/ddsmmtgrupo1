package main.java.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.enumeraciones.Ciudad;

import org.uqbar.commons.utils.Observable;

@Observable
public class RepositorioDestinos implements Serializable {
	private static RepositorioDestinos instance;
	private List<Ciudad> data = new ArrayList<Ciudad>();		


	public static RepositorioDestinos getInstance() {
		if (instance == null) {
			instance = new RepositorioDestinos();
		}
		return instance;
	}

	private RepositorioDestinos() {
		this.data.add(Ciudad.ESTADOS_UNIDOS);
		this.data.add(Ciudad.USHUAIA);
		this.data.add(Ciudad.BUENOS_AIRES);
		this.data.add(Ciudad.PERU);
		this.data.add(Ciudad.NUEVA_YORK);
		this.data.add(Ciudad.LOS_ANGELES);
	}

	public List<Ciudad> getCiudades() {
		return this.data;
	}
}
