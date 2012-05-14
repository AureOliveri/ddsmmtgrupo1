package claseUnica;

import junit.framework.Assert;

import org.junit.Test;

public class TestEvar {
	@Test
	public void tieneFormatoLatinoamericano(){
		Fecha fecha = new Fecha("29  / 03/19  91");
		System.out.println("El formato es:"+fecha.getFormato());
		Assert.assertTrue(fecha.getFormato().equals("Latinoamericano"));
	}
}


