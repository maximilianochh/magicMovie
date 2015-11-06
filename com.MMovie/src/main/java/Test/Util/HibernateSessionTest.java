package Test.Util;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import Util.HibernateSession;
import model.Cliente;
public class HibernateSessionTest {
	HibernateSession hs=HibernateSession.getInstance();
	@Before
	public void before() {
		
	}
	@Test
	public void save() {
		Cliente c=new Cliente();
		assertEquals(hs.save(c),true);
	}
	@Test(expected=Exception.class)
	public void save1() {
		hs.save(hs);
	}
	@Test
	public void getAll() {
		List<Object> list=hs.getAll("CLIENTE");
		assertEquals(list.isEmpty(),true);
	}
}
