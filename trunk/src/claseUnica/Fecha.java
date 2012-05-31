package claseUnica;

import java.util.HashMap;
import java.util.Map;


public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	private int fechaFinal;
	private String formato;
	private Map<Integer, Integer> diasPorMes = new HashMap<Integer, Integer>();

	public Fecha(String fechaString) {
		String anioS = new String();
		String mesS = new String();
		String diaS = new String();
		String formatoS = new String();
		fechaString = fechaString.replaceAll(" ", "");

		if (esFormatoISO8601(fechaString)) {
			this.crearFecha(fechaString.substring(0, 4),
					fechaString.substring(5, 7), fechaString.substring(8, 10),
					"ISO8601");
		} else if (esFormatoLatinoamericano(fechaString)) {
			this.crearFecha(fechaString.substring(6, 10),
					fechaString.substring(3, 5), fechaString.substring(0, 2),
					"Latinoamericano");
		} else if (esFormatoNorteamericano(fechaString)) {
			mesS = fechaString.substring(0, 2);
			diaS = fechaString.substring(3, 5);
			anioS = fechaString.substring(6, 10);
			formatoS = "Norteamericano";
		} else {
			throw new parserException(
					"La cadena ingresada no concuerda con ningun formato valido");
		}
		if (mes > 12 || dia > this.diasPorMes.get(mes)) {
			throw new RuntimeException();
		}
		
		diasPorMes.put(1, 31);
		diasPorMes.put(2, 28);
		diasPorMes.put(3, 31);
		diasPorMes.put(4, 30);
		diasPorMes.put(5, 31);
		diasPorMes.put(6, 30);
		diasPorMes.put(7, 31);
		diasPorMes.put(8, 31);
		diasPorMes.put(9, 30);
		diasPorMes.put(10, 31);
		diasPorMes.put(11, 30);
		diasPorMes.put(12, 31);
		
		
	}
	
	private void crearFecha(String anio, String mes, String dia, String formato) {
		this.convertirStringAFecha(anio, mes, dia, formato);
		this.formato = formato;
	}

	public boolean esAnteriorQue(Fecha otraFecha) {
		return (this.obtenerDias() < otraFecha.obtenerDias());
	}


	public void convertirStringAFecha(String anio, String mes, String dia,
			String formato) {
		this.anio = Integer.parseInt(anio);
		this.mes = Integer.parseInt(mes);
		this.dia = Integer.parseInt(dia);
		this.setFormato(formato);
		return ;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	}

	public int getAnio() {
		return anio;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int getFecha() {
		return fechaFinal;
	}

	public Fecha() {
	}


	public static boolean esFormatoISO8601(String fechaS) {
		return (fechaS.substring(4, 5).equals("-"))
				&& (fechaS.substring(7, 8).equals("-"));
	}

	public static boolean esFormatoLatinoamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("/"))
				&& ((fechaS.substring(5, 6).equals("/")));
	}

	public static boolean esFormatoNorteamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("-"))
				&& ((fechaS.substring(5, 6).equals("-")));
	}

	

	public int obtenerDias(){
		int dias = this.getDia() + this.getAnio()*365;
		dias += ((this.getAnio()-1) % 4);
		for (int i = 0; (i < this.getMes()-1); i++) {
			dias += diasPorMes.get(i);
			if(i == 2 && esBiciesto()){
				dias += 1;
			}
		}
		return dias;
	}

	public int diferenciaDeDiasCon(Fecha otraFecha){
		  int totalDiasFecha;
		  int totalDiasOtraFecha;
		  int difDias;
		  totalDiasFecha = this.obtenerDias();
		  totalDiasOtraFecha = otraFecha.obtenerDias();
		  difDias = totalDiasFecha - totalDiasOtraFecha;		  
		  if(this.esAnteriorQue(otraFecha)){
		   System.out.println("La cantidad de dias entre fechas es: "+ (difDias * -1));
		   return (difDias * -1);
		   
		  }else if(!this.esAnteriorQue(otraFecha)){
		   System.out.println("La cantidad de dias entre fechas es: " + difDias);
		   return (difDias);
		  }else{
			  System.out.println("Las fechas son iguales.");
		      return 0;
		  }
	}
	
	public boolean esBiciesto(){
		   return (this.anio % 4 ==0);
	}	
	
}
