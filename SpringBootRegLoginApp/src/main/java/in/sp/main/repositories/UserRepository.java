package in.sp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.User;



public interface UserRepository extends JpaRepository<User,Integer> {//since we have id in int
	
	User findByEmail(String email);//since one user is necessary
}
