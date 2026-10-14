package in.sp.main;

import in.sp.main.repository.StudentRepository;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entities.Student;
import in.sp.main.services.StudentService;
import in.sp.main.services.StudentServiceImpl;

@SpringBootApplication
public class SpringBootWithDataJpa1Application {

	private final StudentRepository studentRepository;

	SpringBootWithDataJpa1Application(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootWithDataJpa1Application.class, args);//it retuns value in configurable
		
         StudentService stdService = context.getBean(StudentServiceImpl.class);
         
         
         
//         Insert operation
//         Student std = new Student();
//         std.setName("Rishil");
//         std.setRollno(102);
//         std.setMarks(67.5f);
//        
//         
//       boolean status =   stdService.addSTudentDetails(std);//now create student class object to add the details
//       if(status) {
//    	   System.out.println("Student Inserted Successfully.");
//       }else {
//    	   System.out.println("Student not inserted due to some erros.");
//       }
         
         
//         //-------------Select Operation 
//       List<Student> stdList =  stdService.getAllStudentDetails();		
//       for (Student std : stdList) {
//		System.out.println("Id : " +std.getId());
//		System.out.println("Name: " +std.getName());
//		System.out.println("Rollno : " +std.getRollno());
//		System.out.println("Marks : " +std.getMarks());
//		
//		
//		System.out.println("----------------------------");
//	}
//       
         //select operation 2 to get 1 value
//         Student std = stdService.getStdDetails(2L);
//        if(std != null) {//to handle nullPointer Exception
//        	System.out.println("Id : " +std.getId());
//     		System.out.println("Name: " +std.getName());
//     		System.out.println("Rollno : " +std.getRollno());
//     		System.out.println("Marks : " +std.getMarks());
//             
//        }else {
//        	System.out.println("Student not found");
//        }
        
         //-----------------Update Crud Operation
//        boolean status =  stdService.updateStdDetails(1L, 97.5f);
//         if(status) {
//       System.out.println("Student Details Updated Successfully");
//         }else {
//        	 System.out.println("Student Not Updated Due to some Error");
//         }
       
         
         //-----------------Delete Crud Operation
         
         
         boolean status =  stdService.deleteStdDetails(2L);
       if(status) {
     System.out.println("Student Details Deleted Successfully");
       }else {
      	 System.out.println("Student Not Deleted Due to some Error");
       }
     		
     	
     	
         
         
         
         
	}

}
