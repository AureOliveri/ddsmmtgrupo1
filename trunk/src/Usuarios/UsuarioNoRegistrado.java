package Usuarios;

public class UsuarioNoRegistrado implements Usuario {

	@Override
	public String getTipoUsuario() {
		
		return "No Registrado";
	}

}
