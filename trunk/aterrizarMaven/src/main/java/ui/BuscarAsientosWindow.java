package main.java.ui;

import main.java.busquedas.Busqueda;

import org.uqbar.arena.windows.WindowOwner;

public class BuscarAsientosWindow extends CrearBusquedaWindow {

	public BuscarAsientosWindow(WindowOwner owner) {
		super(owner, new Busqueda());
	}

	@Override
	protected void executeTask() {
//		RepositorioCelulares.getInstance().create(this.getModelObject());
		super.executeTask();
	}
}
