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
		public void anioBiciesto() {
			Assert.assertTrue(fecha1.esBiciesto());
		}

		@Test
		public void igualesOtroFormato() {
			fecha2.convertirStringAFecha("2012", "12", "25", "ISO8601");
			Assert.assertSame(0,fecha2.diferenciaDeDiasCon(fecha1));
		}
		
		@Test (expected=Exception.class) // error de parseInt("wa") 
		public void malIngresoFecha() {
			fecha2.convertirStringAFecha("wa", "e", "2", "no");
		}
		
		@Test (expected=parserException.class) // formato de fecha mal
		public void malIngresoFecha2() throws parserException {
			fecha2 = new Fecha("31 - 12 / 1999");
		}		
}		
}// esta de mas para q no corra y de rojo =)