package Usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import Vuelos.Asiento;


public class UsuarioEstandar extends TipoUsuario {

	@Override
	protected ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos, BigDecimal impuesto) {
		ArrayList<Asiento> asientosNoVip = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {

			if (!asiento.esSuperOferta(impuesto, this))
				asientosNoVip.add(asiento);
		}
		return asientosNoVip;

	}

	@Override
	public BigDecimal getRecargo() {
		return new BigDecimal(0);
	}

	public void comprarAsiento(Asiento unAsiento) {
		// TODO Auto-generated method stub
		
	}


}
