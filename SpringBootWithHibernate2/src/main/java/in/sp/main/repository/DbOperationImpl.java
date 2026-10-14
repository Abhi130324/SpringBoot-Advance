package in.sp.main.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import in.sp.main.config.hibernateConfig;
import in.sp.main.entities.User;
@Repository
public class DbOperationImpl implements DbOperation{

	@Override
	public User getUserDetails(Long id) {
		
		User user = null; 
		
		
		try(
			Session session = 	hibernateConfig.getSessionfactory().openSession();//this will return value in session
				) {
			user = session.get(User.class, id);//since it return user
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

}
