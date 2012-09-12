package mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.lanchita.excepciones.CodigoErroneoException;
import com.lanchita.excepciones.EstadoErroneoException;

public class LanchitaMock {
	
	private static final LanchitaMock INSTANCE = new LanchitaMock();

	private String[][] asientos;

	// ****************************************************************
	// ** STATICS
	// ****************************************************************

	public static LanchitaMock getInstance() {
		return INSTANCE;
	}

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	private LanchitaMock() {
		this.setAsientos(new String[][] {
				{ "01202022220202-3", "159.90", "P", "V", "D", "" },
				{ "01202022220123-3", "205.10", "E", "P", "D", "" },
				{ "01202012315523-8", "154.08", "E", "P", "D", "" },
				{ "01202022267867-7", "255.98", "E", "P", "D", "" },
				{ "01202022227897-3", "236.10", "P", "C", "D", "" },
				{ "01202022998988-6", "148.23", "P", "V", "D", "" },
				{ "01202022220008-3", "383.22", "T", "V", "D", "" },
				{ "01202022256565-3", "282.19", "T", "C", "D", "" },
				{ "01202022323423-5", "431.28", "T", "C", "D", "" },
				{ "01202022220298-2", "528.81", "P", "V", "D", "" } });
	}

	// ****************************************************************
	// ** QUERIES
	// ****************************************************************

	/**
	 * 
	 * Retorna el conjunto de los asientos disponibles para ir del origen al
	 * destino en la fecha solicitada. Los asientos devueltos estan
	 * representados por un array de Strings con la siguiente distribución: <br>
	 * [0]: Codigo identificador del asiento. <br>
	 * [1]: Precio base del asiento. <br>
	 * [2]: Clase del asiento. Los valores pueden ser "P" para Primera, "E" para
	 * Ejecutivo y "C" para Turista. <br>
	 * [3]: Ubicación del asiento. Los valores pueden ser "V" para Ventana, "C"
	 * para Centro y "P" para Pasillo. <br>
	 * [4]: Estado del asiento. Los valores pueden ser "D" para Disponible, "R"
	 * para Reservado y "C" para Comprado. En esta consulta solo se devolveran
	 * asientos "D". <br>
	 * [5]: DNI del cliente que reservó o compró el asiento. En esta consulta
	 * vendrá siempre vacío. <br>
	 * 
	 * @param origen
	 *            Identificador del lugar de origen
	 * @param destino
	 *            Identificador del lugar de destino
	 * @param fecha
	 *            Fecha en la que se realizara el viaje
	 * 
	 * @return Array con asientos disponibles para ser reservados o comprados.
	 */
	public String[][] asientosDisponibles(String origen, String destino,
			String fechaSalida, String horaSalida, String fechaLlegada,
			String horaLlegada) {

		List<String[]> disponibles = Arrays.asList(this.getAsientos());
		List<String[]> retVal = new ArrayList<String[]>();
		Iterator<String[]> iterator = disponibles.iterator();

		while (iterator.hasNext()) {
			String[] element = iterator.next();
			if (element[4].equals("D")) {
				retVal.add(element);
			}
		}

		return retVal.toArray(new String[][] {});
	}

	protected int getIndiceDeAsiento(String codigo) {
		for (int i = 0; i < this.getAsientos().length; i++) {
			if (this.getAsientos()[i][0].equals(codigo)) {
				return i;
			}
		}

		throw new CodigoErroneoException(codigo);
	}

	// ****************************************************************
	// ** OPERATIONS
	// ****************************************************************

	/**
	 * Realiza la compra del asiento con el código especificado.
	 * 
	 * @param codigo
	 *            Código identificador del asiento a comprar.
	 * 
	 * @throws CodigoErroneoException
	 *             si el código recibido no existe.
	 * @throws EstadoErroneoException
	 *             si se intenta comprar un asiento ya comprado o reservado por
	 *             otra persona.
	 * 
	 */
	public void comprar(String codigo) {
		String[] asiento = this.getAsientos()[this.getIndiceDeAsiento(codigo)];

		if (asiento[4].equals("C") || asiento[4].equals("R")) {
			throw new EstadoErroneoException();
		}

		asiento[4] = "C";
	}

	/**
	 * Realiza la reserva del asiento con el código especificado y lo vincula al
	 * dni recibido.
	 * 
	 * @param codigo
	 *            Código identificador del asiento a reservar.
	 * @param dni
	 *            DNI del comprador.
	 * 
	 * @throws CodigoErroneoException
	 *             si el código recibido no existe.
	 * @throws EstadoErroneoException
	 *             si se intenta reservar un asiento que no está disponible.
	 * 
	 */
	public void reservar(String codigo, String dni) {
		String[] asiento = this.getAsientos()[this.getIndiceDeAsiento(codigo)];

		if (!asiento[4].equals("D")) {
			throw new EstadoErroneoException();
		}

		asiento[4] = "R";
	}

	// ****************************************************************
	// ** ACCESSORS
	// ****************************************************************

	protected String[][] getAsientos() {
		return this.asientos;
	}

	protected void setAsientos(String[][] asientos) {
		this.asientos = asientos;
	}

}
