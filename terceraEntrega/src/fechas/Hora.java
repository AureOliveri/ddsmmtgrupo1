package fechas;

public class Hora {
	
	private int hora;
	private int minutos;
	
	public Hora(String horaString) {
		convertirStringAHora(horaString.substring(0, 2), horaString.substring(3, 5));
	}

	private void convertirStringAHora(String hora, String minutos) {
		this.hora = Integer.parseInt(hora);
		this.minutos = Integer.parseInt(minutos);
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

}
