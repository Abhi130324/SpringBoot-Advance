package in.sp.main.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.sp.main.entity.User;

public class UserRowMapper  implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		//so all the values get from database and set in User
		User user = new User();//need empty constructor so we need one in User
		user.setName(rs.getString("name"));//we will get name from resultset and set it in user. name should match the sql table
		user.setEmail(rs.getString("email"));
		user.setGender(rs.getString("gender"));
		user.setCity(rs.getString("city"));
		
		return user;
	}
	
}