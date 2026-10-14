package in.sp.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import in.sp.main.entity.User;
import in.sp.main.mapper.UserRowMapper;

@Repository
public class UserDao {

	@Autowired // spring will automatically configure everything
	private JdbcTemplate jdbcTemplate;// just gave reference to jdbcTemplate

	
	//insertion code
	public boolean insertUser(User user) {// boolean would be easy to use
		boolean status = false;

		
		try {
			String insert_sql_query = "INSERT INTO users(name, email, gender, city) VALUES(?,?,?,?)";
			int count = jdbcTemplate.update(insert_sql_query, user.getName(), user.getEmail(), user.getGender(),
					user.getCity());// since we already have user we get name from them and also update is returning
									// value in INt;
			if (count > 0) {
				status = true;
			} else {
				status = false;
			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;

	}

	//Updation Code
	public boolean updateUser(User user) {
		boolean status = false;

		try {

			String update_sql_query = "UPDATE users SET name = ? ,gender =?, city = ? WHERE email =?";
			int count = jdbcTemplate.update(update_sql_query, user.getName(), user.getGender(), user.getCity(),
					user.getEmail());// remember to keep the sequence in which you are providing psoitional parmeter
									// ?
			if (count > 0) {
				status = true;
			}else {
				status = false;
			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;//now we have to call this method on main so go to main
	}
		
		//Deletion Code
		public boolean deleteUserByEmail(String email) {//remember to change it to String if you want you can use user as well but no need to add full object
			boolean status = false;

			try {

				String delete_sql_query = " DELETE FROM  users WHERE email =?";
				int count = jdbcTemplate.update(delete_sql_query, email);// you just need email to delete the data
										// ?
				if (count > 0) {
					status = true;
				}else {
					status = false;
				}

			} catch (Exception e) {
				status = false;
				e.printStackTrace();
			}

			return status;//now we have to call this method on main so go to main
		}
			
		
		
		
			//-------------Select Crud Operation
			
			public User getUserByEmail(String email) {
				
				String select_sql_query ="SELECT * FROM users WHERE email = ?";
				//we need to create a custom rowMapper Class  and returns values in USer
				return jdbcTemplate.queryForObject(select_sql_query, new UserRowMapper(),email);//all 3 field need to be passed
			}
			
			
			//Remember to write List using ctrl + space because it can later give errors
			public List<User> getAllUsers(){//if we want to get all the User
				String select_sql_query = "SELECT * FROM users";
				return jdbcTemplate.query(select_sql_query, new UserRowMapper());
			}
			
			
			//ctrl + 1 to click on the error
//			public static final class UserRowMapper implements RowMapper<User>{
//
//				@Override
//				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//					
//					
//					//so all the values get from database and set in User
//					User user = new User();//need empty constructor so we need one in User
//					user.setName(rs.getString("name"));//we will get name from resultset and set it in user. name should match the sql table
//					user.setEmail(rs.getString("email"));
//					user.setGender(rs.getString("gender"));
//					user.setCity(rs.getString("city"));
//					
//					return user;
//				}
				
			
			
			
			
		
	//}
}
