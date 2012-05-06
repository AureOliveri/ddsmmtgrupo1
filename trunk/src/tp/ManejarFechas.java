package tp;


public class ManejarFechas {
	public static Fecha parsearFecha(String cadena){
		Fecha fecha = new Fecha();
		String anio = new String();
		String mes = new String();
		String dia = new String();
		String formato = new String();
		cadena = cadena.replaceAll(" ", "");
		if((cadena.substring(4,5).equals("-")) && (cadena.substring(7, 8).equals("-")) ){
			anio = cadena.substring(0, 4);
			mes = cadena.substring(5, 7);
			dia = cadena.substring(8,10);
			formato = "ISO8601";
			
		} else if((cadena.substring(2, 3).equals("/")) && ((cadena.substring(5, 6).equals("/")))){
			dia = cadena.substring(0, 2);
			mes = cadena.substring(3, 5);
			anio = cadena.substring(6, 10);
			formato = "Latinoamericano";
			System.out.println("latino");
		} else if((cadena.substring(2, 3).equals("-")) && ((cadena.substring(5, 6).equals("-")))){
			mes = cadena.substring(0, 2);
			dia = cadena.substring(3, 5);
			anio = cadena.substring(6, 10);
			formato = "Norteamericano";
		}
		fecha.anio = Integer.parseInt(anio);
		fecha.mes = Integer.parseInt(mes);
		fecha.dia = Integer.parseInt(dia);
		fecha.formato = formato;
		return fecha;
	}
	
	public static void main (String [ ] args) 
    { 	Fecha fecha = new Fecha();
		fecha = parsearFecha("1991-03-27");
		Fecha otraFecha = new Fecha();
		otraFecha = parsearFecha("12/07/2001");
		System.out.println(otraFecha.esMayorQue(fecha));
        return;
     } 
	
	
}


