package com.magicMovie.Factory;
import com.magicMovie.interfaces.IAsignacionMExtras;
import com.magicMovie.model.AsignacionClientesActualizados;
import com.magicMovie.model.AsignacionUnder;
public class FactoryAsignacion {
	public static IAsignacionMExtras getInstance(String EstrategyType) {
		IAsignacionMExtras asignacion=new AsignacionClientesActualizados();
		if (EstrategyType==null) {
			return asignacion;
		}
		if (EstrategyType.equalsIgnoreCase("Actualizados")) {
			return asignacion;
		}
		if (EstrategyType.equalsIgnoreCase("Under")) {
			asignacion=new AsignacionUnder();
			return asignacion;
		}
		return asignacion;
	}
}
