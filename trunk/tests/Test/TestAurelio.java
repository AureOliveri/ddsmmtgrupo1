package Test;

import tp.Fecha;


public class TestAurelio {
	
	public static void main (String [ ] args) {
		Fecha fecha = new Fecha ("2000-03-31");
		System.out.println(fecha.getFecha());
		Fecha otraFecha = new Fecha("01/04/2006");
		System.out.println(otraFecha.getFecha());
		Fecha fecha2 = new Fecha ("1991-03-27");
		System.out.println(fecha2.getFecha());
		Fecha otraFecha2 = new Fecha("28/03/1991");
		System.out.println(otraFecha2.getFecha());
		
		System.out.println(otraFecha.esAnteriorQue(fecha));
		System.out.println(otraFecha.cantidadDeDiasEntreFechas(fecha));
		System.out.println(otraFecha2.esAnteriorQue(fecha2));
		
		return;
	}
	
}
