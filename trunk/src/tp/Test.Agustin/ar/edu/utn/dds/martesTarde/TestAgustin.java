package ar.edu.utn.dds.martesTarde;
import tp.Fecha;

public class TestAgustin {

	public static void main (String [ ] args) 
    { 	Fecha fecha = new Fecha();
		fecha = parsearFecha("1991-03-27");
		Fecha otraFecha = new Fecha();
		otraFecha = parsearFecha("27/03/1991");
		System.out.println(otraFecha.esAnteriorQue(fecha));
		
		return;
		
		
     } 
}
