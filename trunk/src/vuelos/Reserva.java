package vuelos;

public class Reserva {

	private String codigo;
	private String dni;

	public Reserva(String codigo, String dni) {
		this.codigo = codigo;
		this.dni = dni;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getDni() {
		return this.dni;
	}
}
