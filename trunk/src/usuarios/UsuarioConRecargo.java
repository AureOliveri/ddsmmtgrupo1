package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import vuelos.Asiento;


public class UsuarioConRecargo extends TipoUsuario {

	public BigDecimal getRecargo() {
		return new BigDecimal(20);
	}

	@Override
	protected ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos) {
		ArrayList<Asiento> asientosNoVip = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {
			BigDecimal impuesto = asiento.getVuelo().getAerolinea().getImpuesto();
			if (!asiento.esSuperOferta(impuesto, this))
				asientosNoVip.add(asiento);
		}
		return asientosNoVip;

	}

	public void comprarAsiento(Asiento unAsiento) {
		// TODO Auto-generated method stub
		
	}

}
