package tp;

public class Fecha {
	int dia;
	int mes;
	int anio;
	String formato;

	public boolean esMayorQue(Fecha otraFecha){
		
		if(this.mayorAnio(otraFecha.anio) || (this.mayorMes(otraFecha)) || (this.mayorDia(otraFecha))){
			return true;
		}
		return false;
	}
	
	public boolean mayorAnio(int otroAnio){
		if(this.anio > otroAnio){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean mayorMes(Fecha otraFecha){
		if(this.anio == otraFecha.anio && this.mes > otraFecha.mes){
			return true;
		} else {
			return false;
		}
	}
	public boolean mayorDia(Fecha otraFecha){
		if(this.anio == otraFecha.anio && this.mes == otraFecha.mes && this.dia > otraFecha.dia){
			return true;
		} else {
			return false;
		}
	}
}

