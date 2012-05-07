package tp;

public class Fecha {
	int dia;
	int mes;
	int anio;
	String formato;

	public boolean esMayorQue(Fecha otraFecha){
		return(this.mayorAnio(otraFecha.anio) || (this.mayorMes(otraFecha)) || (this.mayorDia(otraFecha)));
	}
	
	public boolean mayorAnio(int otroAnio){
		return(this.anio > otroAnio);
	}
	
	public boolean mayorMes(Fecha otraFecha){
		return(this.anio == otraFecha.anio && this.mes > otraFecha.mes);
	}
	
	public boolean mayorDia(Fecha otraFecha){
		return(this.anio == otraFecha.anio && this.mes == otraFecha.mes && this.dia > otraFecha.dia);
	}
}

