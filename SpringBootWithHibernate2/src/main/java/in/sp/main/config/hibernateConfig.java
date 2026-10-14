package in.sp.main.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateConfig {

	
	public static SessionFactory getSessionfactory() {//this will return Sessionfactory object
		Configuration cfg = new Configuration();
		cfg.configure("/in/sp/main/resources/hibernate.cfg.xml");
		
		
		return cfg.buildSessionFactory();
	}
}
