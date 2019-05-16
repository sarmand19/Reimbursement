package com.revature.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bean.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.HttpException;

public class LoginDao {

	public User getPasswordByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "Select * FROM ers_users WHERE ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String password = rs.getString("ers_password");
				int id = rs.getInt("ers_users_id");
				int roleId = rs.getInt("user_role_id");
				String fname = rs.getString("user_ers_first_name"); 
				String lname = rs.getString("uer_ers_last_name");
				String email = rs.getString("user_email");
				
				
				
				return new User(id,username,password,fname,lname,email,roleId);
				
			} else {
				throw new HttpException(400);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

}
