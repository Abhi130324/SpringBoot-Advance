package in.sp.main;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entities.User;
import in.sp.main.repository.DbOperation;

@SpringBootApplication
public class SpringBootWithHibernate1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootWithHibernate1Application.class, args);// get
																											// appcontext
																											// object
																											// here
		DbOperation dbop = context.getBean(DbOperation.class);
		User user = dbop.getUserDetails(2L);
		if (user != null) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
		} else {
			System.out.println("User Not Found");
		}
	}

}