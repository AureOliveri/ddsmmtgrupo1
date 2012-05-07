package tp;

public class Fecha {
	int dia;
	int mes;
	int anio;
	String formato;

	public boolean esAnteriorQue(Fecha otraFecha){
		return(this.menorAnio(otraFecha.anio) || this.menorMes(otraFecha) || this.menorDia(otraFecha));
	}
	
	public boolean menorAnio(int otroAnio){
		return(this.anio < otroAnio);
	}
	
	public boolean menorMes(Fecha otraFecha){
		return(this.anio == otraFecha.anio && this.mes < otraFecha.mes);
	}
	
	public boolean menorDia(Fecha otraFecha){
		return(this.anio == otraFecha.anio && this.mes == otraFecha.mes && this.dia < otraFecha.dia);
	}
	

	
}

