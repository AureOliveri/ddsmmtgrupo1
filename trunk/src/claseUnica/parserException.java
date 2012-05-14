package claseUnica;

public class parserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public parserException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}
}
