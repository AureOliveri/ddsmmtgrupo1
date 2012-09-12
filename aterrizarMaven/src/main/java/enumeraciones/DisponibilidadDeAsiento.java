package enumeraciones;

public enum DisponibilidadDeAsiento {
	DISPONIBLE {
		@Override
		public String getCodigo() {
			return "D";
		}
	}, 
	RESERVADO {
		@Override
		public String getCodigo() {
			return "R";
		}
	}, 
	COMPRADO {
		@Override
		public String getCodigo() {
			return "C";
		}
	};
	
	public abstract String getCodigo();
	
	public static DisponibilidadDeAsiento obtenerDisponibilidad(String s) {
		for(DisponibilidadDeAsiento d : DisponibilidadDeAsiento.values()) {
			if(d.getCodigo().equals(s))
				return d;
		}
		return null;
	}
}
