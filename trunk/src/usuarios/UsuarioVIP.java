package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import vuelos.Asiento;


public class UsuarioVIP extends TipoUsuario {


	@Override
	public ArrayList<Asiento> getAsientosQueLeCorresponden(ArrayList<Asiento> asientos) {
		return asientos;
	}

	@Override
	public BigDecimal getRecargo() {
		return new BigDecimal(0);
	}

}
