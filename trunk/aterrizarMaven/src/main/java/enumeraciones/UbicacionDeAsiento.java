package main.java.enumeraciones;

public enum UbicacionDeAsiento {
	VENTANA {
		@Override
		public String getCodigo() {
			return "V";
		}
	}, 
	PASILLO {
		@Override
		public String getCodigo() {
			return "P";
		}
	}, 
	CENTRO {
		@Override
		public String getCodigo() {
			return "C";
		}
	};
	
	public abstract String getCodigo();
	
	public static UbicacionDeAsiento obtenerUbicacion(String s) {
		for(UbicacionDeAsiento u : UbicacionDeAsiento.values()) {
			if(u.getCodigo().equals(s))
				return u;
		}
		return null;
	}
}
