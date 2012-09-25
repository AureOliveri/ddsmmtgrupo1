package main.java.ui;

import main.java.modelos.BuscadorModel;

public class BuscarAsientosWindow extends CrearBusquedaWindow {

	public BuscarAsientosWindow(AterrizarWindow owner) {
		super(owner, new BuscadorModel(AterrizarWindow.getUsuario()));
	}

	@Override
	protected void executeTask() {
//		RepositorioCelulares.getInstance().create(this.getModelObject());
		super.executeTask();
	}
}
