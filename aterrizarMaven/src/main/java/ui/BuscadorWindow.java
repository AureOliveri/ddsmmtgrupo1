package main.java.ui;

import main.java.modelos.ModeloBuscador;
import main.java.usuarios.Usuario;

public class BuscadorWindow extends BuscarAsientosWindow {

	public BuscadorWindow(AterrizarWindow owner, Usuario usuario) {
		super(owner, new ModeloBuscador(usuario));
	}

}
