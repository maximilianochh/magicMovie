package Factory;
import interfaces.IAsignacionMExtras;
import model.AsignacionClientesActualizados;
import model.AsignacionUnder;
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
