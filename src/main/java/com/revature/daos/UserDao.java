package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.User;
import com.revature.bean.Request;
import com.revature.util.ConnectionUtil;

public class UserDao {
	

	public User getUser(String username, String password) {
		try(Connection conn=ConnectionUtil.getConnection()){
			
			String sql ="select * from ers_users where ers_username=? and ers_password=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2, password);
			ResultSet res= ps.executeQuery();
			if(res.next()) {
				int userId = res.getInt("ers_users_id");
				String myusername= res.getString("ers_username");
				String mypassword=res.getString("ers_password");
				String firstName=res.getString("user_first_name");
				String lastName=res.getString("user_last_name");
				String email=res.getString("user_email");
				int roleId= res.getInt("user_role_id");
				
				User user = new User(userId,myusername,mypassword,firstName,lastName,email,roleId);
				return user;
				
				
			}
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		return null;	
	}

}
