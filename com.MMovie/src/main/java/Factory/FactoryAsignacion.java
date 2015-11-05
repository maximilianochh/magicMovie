package Factory;
import interfaces.IAsignacionMExtras;
import model.AsignacionClientesActualizados;
import model.AsignacionMainStream;
public class FactoryAsignacion {
	public IAsignacionMExtras getInstance(String EstrategyType) {
		if (EstrategyType.equalsIgnoreCase("Actualizados")) {
			IAsignacionMExtras asignacion=new AsignacionClientesActualizados();
			return asignacion;
		}
		if (EstrategyType.equalsIgnoreCase("Actualizados")) {
			IAsignacionMExtras asignacion=new AsignacionClientesActualizados();
			return asignacion;
		}
		IAsignacionMExtras asignacion=new AsignacionMainStream();
		return asignacion;
	}
}
