package com.magicMovie.Util.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.magicMovie.Util.HibernateSession;
import com.magicMovie.model.Cliente;
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
