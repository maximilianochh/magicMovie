package Test.model;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.AsignacionClientesActualizados;
import model.AsignacionUnder;
import model.Cuenta;
import model.Pelicula;
public class AsignacionUnderTest {
	private AsignacionUnder asig=new AsignacionUnder(); 
	private Cuenta cuenta=new Cuenta();
	private Pelicula peli1=new Pelicula();
	private Pelicula peli2=new Pelicula();
	@Before
	public void before() {
		Date tiempoAtras=new Date();
		tiempoAtras.setMonth(1);
		peli1.setFechaEstreno(tiempoAtras);
	}
	@Test
	public void getMinutosExtras() {
		// TODO Auto-generated method stub
		assertEquals(asig.getMinutosExtras(peli1)!=0,true);
		assertEquals(asig.getMinutosExtras(peli2)!=0,false);
	}
	
}
