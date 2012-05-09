package tp;

public class ManejarFechas {

	public static boolean esFormatoISO8601(String fechaS) {
		return (fechaS.substring(4,5).equals("-")) && (fechaS.substring(7, 8).equals("-"));
	}
	
	public static boolean esFormatoLatinoamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("/")) && ((fechaS.substring(5, 6).equals("/")));
	}
	
	public static boolean esFormatoNorteamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("-")) && ((fechaS.substring(5, 6).equals("-")));
	}	
	
	public static Fecha parsearFecha(String fechaString) {
		Fecha fecha = new Fecha();
		String anio = new String();
		String mes = new String();
		String dia = new String();
		String formato = new String();
		fechaString = fechaString.replaceAll(" ", "");
		if(esFormatoISO8601(fechaString)){
		
			anio = fechaString.substring(0, 4);
			mes = fechaString.substring(5, 7);
			dia = fechaString.substring(8,10);
			formato = "ISO8601";
		} else if(esFormatoLatinoamericano(fechaString)){
			dia = fechaString.substring(0, 2);
			mes = fechaString.substring(3, 5);
			anio = fechaString.substring(6, 10);
			formato = "Latinoamericano";
		} else if(esFormatoNorteamericano(fechaString)){
			mes = fechaString.substring(0, 2);
			dia = fechaString.substring(3, 5);
			anio = fechaString.substring(6, 10);
			formato = "Norteamericano";
		}
		
		fecha.convertirStringAFecha(anio, mes, dia, formato);
		
		return fecha;
	}
	
	public static void main (String [ ] args) 
    { 	Fecha fecha = new Fecha();
		fecha = parsearFecha("1991-03-27");
		Fecha otraFecha = new Fecha();
		otraFecha = parsearFecha("27/03/1991");
		System.out.println(otraFecha.esAnteriorQue(fecha));
		
		return;
		
		
     } 
	
	
}


