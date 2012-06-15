package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import vuelos.Asiento;


public class UsuarioVIP extends TipoUsuario {


	public ArrayList<Asiento> getAsientosQueLeCorresponden(ArrayList<Asiento> asientos,
			BigDecimal impuesto) {
		return asientos;
	}

	@Override
	public BigDecimal getRecargo() {
		return new BigDecimal(0);
	}

	public void comprarAsiento(Asiento unAsiento) {
		// TODO Auto-generated method stub
		
	}
	
}
