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
	private final static String conURL = "jdbc:derby:C:\\Users\\Fiona\\Documents\\workspace-sts-3.9.9.RELEASE\\derby\\mydb;create = true";
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	 void connect() throws SQLException
	 {
		 connection=DriverManager.getConnection("");
		 ((AdminDaoImpl) connection).connect();
	 }
	 public AdminDaoImpl() {
		
			
			try {
				connection = DriverManager.getConnection(conURL);
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				System.out.println("++DB Driver Loaded++");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}

	 public boolean deleteUser(int userId)throws SQLException
	 {
		 String sql="delete from users where user_id=?";
		 connection.prepareStatement(sql);
		 preparedStatement.setInt(1, userId);
		 int a=preparedStatement.executeUpdate();
		 if(a==1) {
		 String sql1="delete from user_credentials where user_id=?";
		 connection.prepareStatement(sql1);
		 preparedStatement.setInt(1, userId);
		 int b=preparedStatement.executeUpdate();
		 String sql2="delete from friendship where user_id=?";
		 connection.prepareStatement(sql2);
		 preparedStatement.setInt(1, userId);
		 int c=preparedStatement.executeUpdate();
		 String sql3="delete from contacts where user_id=?";
		 connection.prepareStatement(sql3);
		 preparedStatement.setInt(1, userId);
		 int d=preparedStatement.executeUpdate();
		 String sql4="delete from user_address where user_id=?";
		 connection.prepareStatement(sql4);
		 preparedStatement.setInt(1, userId);
		 int e=preparedStatement.executeUpdate();
		 if(b==1 && e==1)return true;
		 return false;
	 }return false;
	 }
	 
	 public boolean disableUser(int userId)throws SQLException
	 {
		 String sql="update users set status=0 where user_id=?";
		 connection.prepareStatement(sql);
		 preparedStatement.setInt(1, userId);
		 int a=preparedStatement.executeUpdate();
		 if(a==1)return true;
		 return false;
	 }
	 
	 public Map<Integer,String> getToDisable() throws SQLException
	 {
		 
		 String sql="select user_id,full_name from users where status=1 and ";
		 connection.prepareStatement(sql);
		 resultSet=preparedStatement.executeQuery();
		 Map<Integer,String> toDisable = null;
		 while(resultSet.next())
		 {
			 toDisable.put(resultSet.getInt("user_id"), resultSet.getString("full_name"));
		 }
		 
		 return toDisable;
	 }
	 private Date getLastActive(int userId) throws SQLException
	 {
		 String sql="select last_active from users where user_id=?";
		 connection.prepareStatement(sql);
		 preparedStatement.setInt(1,userId);
		 resultSet=preparedStatement.executeQuery();
		 if(resultSet.next())
			 return (Date) resultSet;
		 return null;
	 }
	 
	 public Map<Integer,String> getToDelete() throws SQLException
	 {
		 String sql="select user_id,full_name from users where block_count>3";
		 connection.prepareStatement(sql);
		 resultSet=preparedStatement.executeQuery();
		 Map<Integer,String> toDelete = null;
		 while(resultSet.next())
		 {
			 toDelete.put(resultSet.getInt("user_id"), resultSet.getString("full_name"));
		 }
		 return toDelete;
	 }
	 public int[] getSystemInfo() throws SQLException
	 {
		 String sql="select * from users";
		 connection.prepareStatement(sql);
		 resultSet=preparedStatement.executeQuery();
		 int totalUsers=0,activeUsers=0;
		 int arr[]=new int[2];
		 while(resultSet.next())
		 {
			 totalUsers++;
			 if(resultSet.getInt("status")==1)activeUsers++;
		 }
		 arr[0]=totalUsers;arr[1]=activeUsers;
		 return arr;
	 }

	
}
