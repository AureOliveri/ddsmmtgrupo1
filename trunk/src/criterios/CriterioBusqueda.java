package criterios;

import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;

public abstract class CriterioBusqueda {
	
	abstract public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario);
	
	
}
