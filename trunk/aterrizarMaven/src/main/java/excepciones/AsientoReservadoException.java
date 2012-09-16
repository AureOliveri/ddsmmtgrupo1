package main.java.excepciones;

public class AsientoReservadoException extends RuntimeException {
	
	public AsientoReservadoException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}
	
	public AsientoReservadoException(String mensaje){
		super(mensaje);
	}
}
