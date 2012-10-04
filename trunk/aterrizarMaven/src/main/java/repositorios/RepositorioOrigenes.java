package main.java.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.enumeraciones.Ciudad;

import org.uqbar.commons.utils.Observable;

@Observable
public class RepositorioOrigenes implements Serializable {
	private static RepositorioOrigenes instance;
	private List<Ciudad> data = new ArrayList<Ciudad>();		


	public static RepositorioOrigenes getInstance() {
		if (instance == null) {
			instance = new RepositorioOrigenes();
		}
		return instance;
	}

	private RepositorioOrigenes() {
		this.data.add(Ciudad.EZEIZA);
		this.data.add(Ciudad.AEROPARQUE);
		this.data.add(Ciudad.PERU);
		this.data.add(Ciudad.BUENOS_AIRES);
		this.data.add(Ciudad.NUEVA_YORK);
		this.data.add(Ciudad.LOS_ANGELES);
	}

	public List<Ciudad> getCiudades() {
		return this.data;
	}
}
