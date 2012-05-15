package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import claseUnica.Fecha;
import claseUnica.parserException;

public class TestPablo {

		Fecha fecha1,fecha2;
	
		@Before
		public void setUp() throws Exception {
		fecha1 = new Fecha("12 - 25 - 2012");
		fecha2 = new Fecha();
		}

		@Test
		public void esNorteamericano() {
			Assert.assertTrue(fecha1.getFormato().equals("Norteamericano") );
		}
		
		@Test
		public void añoBiciesto() {
			Assert.assertTrue(fecha1.esBiciesto());
		}

		@Test
		public void cadenaAFecha() {
			fecha2.convertirStringAFecha("2012", "12", "25", "Norteamericano");
			Assert.assertSame(fecha1.getFecha(),fecha2.getFecha());
		}
		
		@Test
		public void igualesOtroFormato() {
			fecha2.convertirStringAFecha("2012", "12", "25", "ISO8601");
			Assert.assertSame(fecha1.getFecha(),fecha2.getFecha());
		}
		
		@Test (expected=Exception.class)
		public void malIngresoFecha() {
			fecha2.convertirStringAFecha("wa", "e", "2", "no");
		}
		
}		
		