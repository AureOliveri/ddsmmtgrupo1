package main.java.usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.vuelos.Asiento;

public class UsuarioVIP extends TipoUsuario {


	@Override
	public ArrayList<Asiento> getAsientosQueLeCorresponden(ArrayList<Asiento> asientos,TipoUsuario usuario) {
		return asientos;
	}

	@Override
	public BigDecimal getRecargo() {
		return new BigDecimal(0);
	}

	public String getCodigo() {
		return "vip";
	}
	
}
