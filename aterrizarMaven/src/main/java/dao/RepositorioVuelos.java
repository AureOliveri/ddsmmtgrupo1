package main.java.dao;

import java.io.Serializable;

import main.java.vuelos.Vuelo;

import org.uqbar.commons.utils.Observable;

import uqbar.arena.persistence.PersistentHome;

@Observable
public class RepositorioVuelos extends PersistentHome<Vuelo> implements Serializable{

	@Override
	public Vuelo createExample() {
		return new Vuelo();
	}

	@Override
	public Class<Vuelo> getEntityType() {
		return Vuelo.class;
	}

}
