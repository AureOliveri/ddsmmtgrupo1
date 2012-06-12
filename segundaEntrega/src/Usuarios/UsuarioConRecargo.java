package Usuarios;

import java.math.BigDecimal;

public class UsuarioConRecargo extends Usuario {

	public UsuarioConRecargo(){
		tipoUsuario = "ConRecargo";
	}
	public void setRecargo(){
		this.recargo = new BigDecimal(20);
	}
}
