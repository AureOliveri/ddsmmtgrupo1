package main.java.enumeraciones;

import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public enum Ciudad {
	EZEIZA {
		@Override
		public String getCodigo() {
			return "EZE";
		}
	}, 
	PERU {
		@Override
		public String getCodigo() {
			return "PER";
		}
	}, 
	USHUAIA {
		@Override
		public String getCodigo() {
			return "USH";
		}
	},
	AEROPARQUE {
		@Override
		public String getCodigo() {
			return "AEO";
		}
	}, 
	BUENOS_AIRES {
		@Override
		public String getCodigo() {
			return "_BS";
		}
	}, 
	NUEVA_YORK {
		@Override
		public String getCodigo() {
			return "_NY";
		}
	}, 
	LOS_ANGELES {
		@Override
		public String getCodigo() {
			return "SLA";
		}
	}, 		
	ESTADOS_UNIDOS {
		@Override
		public String getCodigo() {
			return "USA";
		}
	};

	public abstract String getCodigo();
	
	public static Ciudad obtenerCiudad(String s) {
		for(Ciudad c : Ciudad.values()) {
			if(c.getCodigo().equals(s))
				return c;
		}
		return null;
	}
}
