package main.java.fechas;

public class parserException extends RuntimeException {

	public parserException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}

	public parserException(String mensaje) {
		super(mensaje);
		
	}
}