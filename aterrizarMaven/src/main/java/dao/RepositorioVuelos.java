package main.java.dao;


import main.java.vuelos.Asiento;

import org.uqbar.commons.utils.Observable;

import uqbar.arena.persistence.PersistentHome;

@Observable
public class RepositorioVuelos extends PersistentHome<Asiento>{

	@Override
	public Asiento createExample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Asiento> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

}
