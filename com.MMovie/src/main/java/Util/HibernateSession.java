package Util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
	private static HibernateSession instance=null;
	private static Session session;
	protected HibernateSession(){
		this.session=new Configuration().configure().buildSessionFactory().openSession();
	}
	public static HibernateSession getInstance() {
		if (HibernateSession.getInstance()==null) {
			HibernateSession hs=new HibernateSession();
			HibernateSession.setInstance(hs);;
			return hs;
		};
		return instance;
	}
	public boolean save(Object o) {
		this.session.beginTransaction();
		this.session.save(o);
		this.session.getTransaction().commit();
		return true;
	}
	public static void setInstance(HibernateSession instance) {
		HibernateSession.instance = instance;
	}
}
