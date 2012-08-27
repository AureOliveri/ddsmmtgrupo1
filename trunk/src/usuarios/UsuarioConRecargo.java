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
			ArrayList<Asiento> asientos, TipoUsuario tUsuario) {
		ArrayList<Asiento> asientosNoVip = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {
			asiento.agregarRecargo(tUsuario);
			if (!asiento.esSuperOferta()){
				asientosNoVip.add(asiento);
			}
		}
		return asientosNoVip;
	}
	
	public String getCodigo() {
		return "conRecargo";
	}

	public void comprarAsiento(Asiento unAsiento) {
		// TODO Auto-generated method stub
		
	}

}
