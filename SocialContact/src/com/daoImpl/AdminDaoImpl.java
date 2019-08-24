package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.dao.AdminDao;

public class AdminDaoImpl implements AdminDao
{
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	 void connect() throws SQLException
	 {
		 con=DriverManager.getConnection("");
		 ((AdminDaoImpl) con).connect();
	 }
	 
	 public boolean deleteUser(int userId)throws SQLException
	 {
		 String sql="delete from users where user_id=?";
		 con.prepareStatement(sql);
		 pstmt.setInt(1, userId);
		 int a=pstmt.executeUpdate();
		 if(a==1) {
		 String sql1="delete from user_credentials where user_id=?";
		 con.prepareStatement(sql1);
		 pstmt.setInt(1, userId);
		 int b=pstmt.executeUpdate();
		 String sql2="delete from friendship where user_id=?";
		 con.prepareStatement(sql2);
		 pstmt.setInt(1, userId);
		 int c=pstmt.executeUpdate();
		 String sql3="delete from contacts where user_id=?";
		 con.prepareStatement(sql3);
		 pstmt.setInt(1, userId);
		 int d=pstmt.executeUpdate();
		 String sql4="delete from user_address where user_id=?";
		 con.prepareStatement(sql4);
		 pstmt.setInt(1, userId);
		 int e=pstmt.executeUpdate();
		 if(b==1 && e==1)return true;
		 return false;
	 }return false;
	 }
	 
	 public boolean disableUser(int userId)throws SQLException
	 {
		 String sql="update users set status=0 where user_id=?";
		 con.prepareStatement(sql);
		 pstmt.setInt(1, userId);
		 int a=pstmt.executeUpdate();
		 if(a==1)return true;
		 return false;
	 }
	 
	 public Map<Integer,String> getToDisable() throws SQLException
	 {
		 
		 String sql="select user_id,full_name from users where status=1 and ";
		 con.prepareStatement(sql);
		 rs=pstmt.executeQuery();
		 Map<Integer,String> toDisable = null;
		 while(rs.next())
		 {
			 toDisable.put(rs.getInt("user_id"), rs.getString("full_name"));
		 }
		 
		 return toDisable;
	 }
	 private Date getLastActive(int userId) throws SQLException
	 {
		 String sql="select last_active from users where user_id=?";
		 con.prepareStatement(sql);
		 pstmt.setInt(1,userId);
		 rs=pstmt.executeQuery();
		 if(rs.next())
			 return (Date) rs;
		 return null;
	 }
	 
	 public Map<Integer,String> getToDelete() throws SQLException
	 {
		 String sql="select user_id,full_name from users where block_count>3";
		 con.prepareStatement(sql);
		 rs=pstmt.executeQuery();
		 Map<Integer,String> toDelete = null;
		 while(rs.next())
		 {
			 toDelete.put(rs.getInt("user_id"), rs.getString("full_name"));
		 }
		 return toDelete;
	 }
	 public int[] getSystemInfo() throws SQLException
	 {
		 String sql="select * from users";
		 con.prepareStatement(sql);
		 rs=pstmt.executeQuery();
		 int totalUsers=0,activeUsers=0;
		 int arr[]=new int[2];
		 while(rs.next())
		 {
			 totalUsers++;
			 if(rs.getInt("status")==1)activeUsers++;
		 }
		 arr[0]=totalUsers;arr[1]=activeUsers;
		 return arr;
	 }

	
}
