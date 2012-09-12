package enumeraciones;

public enum ClaseDeAsiento {
	PRIMERA {
		@Override
		public String getCodigo() {
			return "P";
		}
	}, 
	EJECUTIVA {
		@Override
		public String getCodigo() {
			return "E";
		}
	}, 
	TURISTA {
		@Override
		public String getCodigo() {
			return "T";
		}
	};
	
	public abstract String getCodigo();
	
	public static ClaseDeAsiento obtenerClase(String s) {
		for(ClaseDeAsiento c : ClaseDeAsiento.values()) {
			if(c.getCodigo().equals(s))
				return c;
		}
		return null;
	}
}
