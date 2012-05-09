package tp;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
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
	
	public void convertirStringAFecha(String anio, String mes, String dia, String formato) {
		this.anio = Integer.parseInt(anio);
		this.mes = Integer.parseInt(mes);
		this.dia = Integer.parseInt(dia);
		this.setFormato(formato);
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
	
}

