package main.java.ui;

import main.java.busquedas.Buscador;

import org.uqbar.arena.windows.WindowOwner;

public class BuscarAsientosWindow extends CrearBusquedaWindow {

	public BuscarAsientosWindow(WindowOwner owner) {
		super(owner, new Buscador());
	}

	@Override
	protected void executeTask() {
//		RepositorioCelulares.getInstance().create(this.getModelObject());
		super.executeTask();
	}
}
