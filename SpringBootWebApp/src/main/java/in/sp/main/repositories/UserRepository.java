package in.sp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {//we added user object and id and we can use crud operation

User  findByEmail(String email);//just remove list and keep the user so it will get the user details through email
	
}
