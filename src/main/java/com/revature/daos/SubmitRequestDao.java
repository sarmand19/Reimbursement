package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.bean.Request;
import com.revature.util.ConnectionUtil;

public class SubmitRequestDao {
	
	public List<Request> getRequests(int userId, int roleId ){
			
			List<Request> requests = new ArrayList<Request>();
			String sql1 = "select * from ers_reimbursement where reimb_author =?";
			String sql2 = "select * from ers_reimbursement";
			try(Connection conn =ConnectionUtil.getConnection())
			{
				PreparedStatement ps;
				if(roleId==2)
				{
					ps = conn.prepareStatement(sql1);
					ps.setInt(1, userId);
				}
				else
				{
					ps = conn.prepareStatement(sql2);
				}
				
				ResultSet res= ps.executeQuery();
				while(res.next())
				{
					int requestId = res.getInt("reimb_id");
					float amount= res.getFloat("reimb_amount");
					Timestamp submitted=res.getTimestamp("reimb_submitted");
					Timestamp resolved=res.getTimestamp("reimb_resolved");
					String description=res.getString("reimb_description");
					String receipt=res.getString("reimb_receipt");
					int authorId= res.getInt("reimb_author");
					int resolverId= res.getInt("reimb_resolver");
					int statusId = res.getInt("reimb_status_id");
					int typeId = res.getInt("reimb_type_id");
							
					Request request = new Request(requestId,amount,submitted,resolved,description,receipt,authorId,resolverId,statusId,typeId);
					
					requests.add(request);
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return requests;
	
	}



public void insertRequest(int userId, double amount, String description, String receipt, int typeId) {
	
	Date date=new Date() ;
	long time = date.getTime();
	try(Connection conn = ConnectionUtil.getConnection())
	{
		
		String sql = "insert into ers_reimbursement (reimb_author, reimb_amount, reimb_description, reimb_status_id, reimb_type_id,reimb_submitted ) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setDouble(2, amount);
		ps.setString(3, description);
		ps.setInt(4, 1);
		ps.setInt(5,typeId);
		ps.setTimestamp(6, new Timestamp(time));
		ps.executeUpdate();
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
	

	}
}