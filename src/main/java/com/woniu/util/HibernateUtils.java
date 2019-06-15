package com.woniu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		sf = cfg.buildSessionFactory();
	}
	
	public static Session openSession() {
		return sf.openSession();
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
