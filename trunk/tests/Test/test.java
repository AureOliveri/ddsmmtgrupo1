package Test;

import tp.Fecha;
import tp.FormatoInvalido;

public class test {
	
	public static void main (String [ ] args) throws FormatoInvalido{
		Fecha fecha = new Fecha ("2006-03-29");
		System.out.println(fecha.getFecha());
		Fecha otraFecha = new Fecha("26/03/2005");
		System.out.println(otraFecha.getFecha());
		Fecha fecha2 = new Fecha ("1991-03-27");
		System.out.println(fecha2.getFecha());
		Fecha otraFecha2 = new Fecha("26/03/1991");
		System.out.println(otraFecha2.getFecha());
		
		System.out.println(otraFecha.esAnteriorQue(fecha));
		System.out.println(otraFecha.cantidadDiasEntreFechas(fecha));
		System.out.println(otraFecha2.esAnteriorQue(fecha2));
		
		return;
	}
	
}
