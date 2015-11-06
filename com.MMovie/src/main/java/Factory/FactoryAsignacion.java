package Factory;
import interfaces.IAsignacionMExtras;
import model.AsignacionClientesActualizados;
import model.AsignacionUnderground;

public class FactoryAsignacion {
	public static IAsignacionMExtras getInstance(String EstrategyType) {
		IAsignacionMExtras asignacion=new AsignacionClientesActualizados();
		if (EstrategyType.equalsIgnoreCase("Actualizados")) {
			return asignacion;
		}
		if (EstrategyType.equalsIgnoreCase("Actualizados")) {
			asignacion=new AsignacionUnderground();
			return asignacion;
		}
		return asignacion;
	}
}
