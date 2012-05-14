package tp;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	private int fechaFinal;
	private String formato;
	
	public boolean esAnteriorQue(Fecha otraFecha){
		return(this.menorAnio(otraFecha.anio) || this.menorMes(otraFecha) 
				|| this.menorDia(otraFecha));
	}
	
	public boolean menorAnio(int otroAnio){
		return(this.anio < otroAnio);
	}
	
	public boolean menorMes(Fecha otraFecha){
		return(this.anio == otraFecha.anio && this.mes < otraFecha.mes);
	}
	
	public boolean menorDia(Fecha otraFecha){
		return(this.anio == otraFecha.anio && this.mes == otraFecha.mes 
				&& this.dia < otraFecha.dia);
	}
	
	public int convertirStringAFecha(String anio, String mes, String dia, String formato) {
		this.anio = Integer.parseInt(anio);
		this.mes = Integer.parseInt(mes);
		this.dia = Integer.parseInt(dia);
		this.setFormato(formato);
		this.fechaFinal = this.anio*10000+this.mes*100+this.dia;
		return fechaFinal;
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
	
	
	public Fecha (String fechaString) {
		String anio = new String();
		String mes = new String();
		String dia = new String();
		String formato = new String();
		
		fechaString.replaceAll(" ", "");
		if(esFormatoISO8601((String)fechaString)){
			
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
		
		convertirStringAFecha(anio, mes, dia, formato);
		return;		
	}
	
	public static boolean esFormatoISO8601(String fechaS) {
		return (fechaS.substring(4,5).equals("-")) && (fechaS.substring(7, 8).equals("-"));
	}
	
	public static boolean esFormatoLatinoamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("/")) && ((fechaS.substring(5, 6).equals("/")));
	}
	
	public static boolean esFormatoNorteamericano(String fechaS) {
		return (fechaS.substring(2, 3).equals("-")) && ((fechaS.substring(5, 6).equals("-")));
	}	
	
	
	public int cantidadDias(Fecha f2) {
		
		int cont = 0;
		
		int anioMayor = this.getAnio();
		int mesMayor  = this.getMes();
		int diaMayor  = this.getDia();
		int anioMenor = f2.getAnio();
		int mesMenor  = f2.getMes();
		int diaMenor  = f2.getDia();
		
		
		
		int FMayor = (anioMayor*10000+mesMayor*100+diaMayor); 
		int Fmenor = (anioMenor*10000+mesMenor*100+diaMenor);
		if (FMayor >= Fmenor) {
			int mesMaux = mesMayor;
			int diaMaux = diaMayor;
			
			
			while(anioMenor<=anioMayor){

				if(anioMenor<anioMayor){
					mesMayor = 12;
					diaMayor = 31;
				}else{
					mesMayor = mesMaux;
					diaMayor = diaMaux;
				}

				while(mesMenor <= mesMayor){
					int DiasDelMes = 0;
					if(mesMenor == mesMayor){
						DiasDelMes = diaMayor;
					}else{
						DiasDelMes = DiasDelMes(anioMenor,mesMenor);
					} 

					while(diaMenor <= DiasDelMes){
						cont++;
						diaMenor++;
					}
					diaMenor = 1;
					mesMenor ++;
				}   
				mesMenor = 1;
				anioMenor++;
			}
			
		}
		return cont;	
	}
	
	public int cantidadDeDiasEntreFechas(Fecha f) {
		int cDias;
		if (this.esAnteriorQue(f)) {
			cDias = f.cantidadDias(this);
		} else {
			cDias = this.cantidadDias(f);
		}
		return cDias;
	}
	
	
	public static int DiasDelMes(int anio, int mes){
		int ndias = 0;
		int f = 0;

		int an = anio;

		if(an % 4 == 0){
			f = 29;
		}else{
			f = 28;
		}
		switch (mes) {
		case 1:   ndias = 31;  break;
		case 2:   ndias = f;   break;
		case 3:   ndias = 31;  break;
		case 4:   ndias = 30;  break;
		case 5:   ndias = 31;  break;
		case 6:   ndias = 30;  break;
		case 7:   ndias = 31;  break;
		case 8:   ndias = 31;  break;
		case 9:   ndias = 30;  break;
		case 10:  ndias = 31;  break;
		case 11:  ndias = 30;  break;
		case 12:  ndias = 31;  break;
		}
		return ndias;
   }
	

}

