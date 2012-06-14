package Usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import Vuelos.Asiento;

public class UsuarioConRecargo extends TipoUsuario {

	public BigDecimal getRecargo() {
		return new BigDecimal(20);
	}

	protected ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos, BigDecimal impuesto) {
		ArrayList<Asiento> asientosNoVip = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {

			if (!asiento.esSuperOferta(impuesto, this))
				asientosNoVip.add(asiento);
		}
		return asientosNoVip;

	}

	public void comprarAsiento(Asiento unAsiento) {
		// TODO Auto-generated method stub
		
	}

}
