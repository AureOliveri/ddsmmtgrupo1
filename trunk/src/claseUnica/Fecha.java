package claseUnica;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	private int fechaFinal;
	private String formato;

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

	public Fecha(String fechaString) {
		try {
			String anioS = new String();
			String mesS = new String();
			String diaS = new String();
			String formatoS = new String();
			fechaString = fechaString.replaceAll(" ", "");
			if (esFormatoISO8601((String) fechaString)) {

				anioS = fechaString.substring(0, 4);
				mesS = fechaString.substring(5, 7);
				diaS = fechaString.substring(8, 10);
				formatoS = "ISO8601";
			} else if (esFormatoLatinoamericano(fechaString)) {
				diaS = fechaString.substring(0, 2);
				mesS = fechaString.substring(3, 5);
				anioS = fechaString.substring(6, 10);
				formatoS = "Latinoamericano";
			} else if (esFormatoNorteamericano(fechaString)) {
				mesS = fechaString.substring(0, 2);
				diaS = fechaString.substring(3, 5);
				anioS = fechaString.substring(6, 10);
				formatoS = "Norteamericano";
			}
			this.convertirStringAFecha(anioS, mesS, diaS, formatoS);
			if(mes > 12 || dia > this.diasDelMes(mes)){
				System.out.println("La fecha ingresada es invalida.");
			}
		} catch (Exception e) {
			System.out
					.println("La cadena ingresada no concuerda con ningun formato valido");
		}
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

	/*public int cantidadDiasEntreFechas(Fecha f2) {

		int cont = 1;

		int anioMayor = this.getAnio();
		int mesMayor = this.getMes();
		int diaMayor = this.getDia();
		int anioMenor = f2.getAnio();
		int mesMenor = f2.getMes();
		int diaMenor = f2.getDia();

		int FMayor = (anioMayor * 10000 + mesMayor * 100 + diaMayor);
		int Fmenor = (anioMenor * 10000 + mesMenor * 100 + diaMenor);
		if (FMayor >= Fmenor) {
			int mesMaux = mesMayor;
			int diaMaux = diaMayor;

			while (anioMenor <= anioMayor) {

				if (anioMenor < anioMayor) {
					mesMayor = 12;
					diaMayor = 31;
				} else {
					mesMayor = mesMaux;
					diaMayor = diaMaux;
				}

				while (mesMenor <= mesMayor) {
					int DiasDelMes = 0;
					if (mesMenor == mesMayor) {
						DiasDelMes = diaMayor;
					} else {
						DiasDelMes = DiasDelMes(anioMenor, mesMenor);
					}

					while (diaMenor <= DiasDelMes) {
						cont++;
						diaMenor++;
					}
					diaMenor = 1;
					mesMenor++;
				}
				mesMenor = 1;
				anioMenor++;
			}

		}
		return cont;
	}
	*/
	public int diasDelMes(int mes) {
		int ndias = 0;
		int f = 0;

		if (this.esBiciesto()) {
			f = 29;
		} else {
			f = 28;
		}
		switch (mes) {
		case 1:
			ndias = 31;
			break;
		case 2:
			ndias = f;
			break;
		case 3:
			ndias = 31;
			break;
		case 4:
			ndias = 30;
			break;
		case 5:
			ndias = 31;
			break;
		case 6:
			ndias = 30;
			break;
		case 7:
			ndias = 31;
			break;
		case 8:
			ndias = 31;
			break;
		case 9:
			ndias = 30;
			break;
		case 10:
			ndias = 31;
			break;
		case 11:
			ndias = 30;
			break;
		case 12:
			ndias = 31;
			break;
		}
		return ndias;
	}
	
	public int obtenerDias(){
		int dias = this.getDia() + this.getAnio()*365;
		for (int i = 0; (i < this.getMes()-1); i++) {
			dias += diasDelMes(i);
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
		   System.out.println("La cantidad de dias entre fechas es: ");
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
		  if(this.anio % 4 ==0){
		   return true;
		  }else{
		   return false;
		  }
	}
	
}
