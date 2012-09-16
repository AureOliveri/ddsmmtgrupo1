package main.java.criterios;

import java.util.ArrayList;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public abstract class CriterioBusqueda {
	
	abstract public ArrayList<Asiento> armarListaBusqueda(ArrayList<Asiento> asientos, Usuario usuario);
	
	
}
