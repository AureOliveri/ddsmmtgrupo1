package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import vuelos.Asiento;


public abstract class TipoUsuario {

	private String dni;
	protected abstract ArrayList<Asiento> getAsientosQueLeCorresponden
				(ArrayList<Asiento> asientos, BigDecimal impuesto);

	
	public abstract BigDecimal getRecargo();
	
	public String getDni(){
		return this.dni;
	}

}
