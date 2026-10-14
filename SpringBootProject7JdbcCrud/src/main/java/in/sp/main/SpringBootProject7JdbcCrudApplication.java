package in.sp.main;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.SystemPropertyUtils;

import com.sun.tools.javac.util.List;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootProject7JdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject7JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {//we need to call userdao method but since @repository springboo will create it object
		
		//-----------Insertion Crud Operation
	//User user1 = new User("Abhijeet","abhijeet@gmail.com","male","Mumbai");//took this from constructor
//		User user2 = new User("Rishil","rishil@gmail.com","male","MiraRoad");
//		
//		boolean status = userDao.insertUser(user2);
//		if(status = true) {
//			System.out.println("User Inserted Successfully");
//		}else {
//			System.out.println("User not Inserted due to some Error!!!!!");
//		}
		
//		///--------------Updation Crud 1
//		User user = new User("Vijay", "vijay@gmail.com", "male", "Delhi");//just change anything except email
//		boolean status = userDao.updateUser(user);
//		if(status = true) {
//			System.out.println("Updation Success");
//		}else {
//		System.out.println("Updation Failed!!!!");
//		}
		
		
		///--------------Updation Crud 2
		User user = userDao.getUserByEmail("abhijeet@gmail.com");
		user.setCity("New World");
		boolean status = userDao.updateUser(user);
		if(status = true) {
			System.out.println("Updation Success");
		}else {
		System.out.println("Updation Failed!!!!");
		}
		
		
		//---------Deletion Crud Operation
		
//		boolean status = userDao.deleteUserByEmail("vijay@gmail.com");
//		if(status ) {
//			System.out.println("Deletion Complete......");
//		}else {
//			System.out.println("Error!!!!!");
//		}
//		
//		
////		
//		//------Select One User
//		User user = userDao.getUserByEmail("kshitij@gmail.com");
//		System.out.println("Name : " +user.getName());
//		System.out.println("Email : " +user.getEmail());
//		System.out.println("Gender : " +user.getGender());
//		System.out.println("City : " +user.getCity());
		
		
		
		
		
		//Select All Users
		//Remember to write List using ctrl + space because it can later give errors
//       java.util.List<User> list =   userDao.getAllUsers(); //it is returning value in List
//		for(User user :list) {
//			System.out.println("Name : " +user.getName());
//			System.out.println("Email : " +user.getEmail());
//			System.out.println("Gender : " +user.getGender());
//			System.out.println("City : " +user.getCity());
//			
//		     System.out.println("--------------------------------");
//		
//		}
//		
		
	}

}
