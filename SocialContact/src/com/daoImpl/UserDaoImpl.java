package com.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.beans.Address;
import com.beans.User;
import com.dao.UserDao;
import com.exceptions.UserNotFoundException;

public class UserDaoImpl implements UserDao {

	private final static String conURL = "jdbc:derby:C:\\Users\\Fiona\\Documents\\workspace-sts-3.9.9.RELEASE\\derby\\mydb;create = true";
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement=null;
	private static PreparedStatement preparedStatement_2=null;

	private static ResultSet resultSet = null;
	private static ResultSet resultSet_2 = null;	
    
	public UserDaoImpl() {
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

	
	

	@Override
	public boolean userLogin(String userName, String password) throws SQLException {
		preparedStatement = connection.prepareStatement("SELECT * FROM USER_CREDENTIALS WHERE USERNAME = ? AND PASSWORD = ?");
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, password);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
			return true;
		return false;
		
	}

	@Override
	public User getUser(int userId) throws UserNotFoundException, SQLException {
		preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");
		preparedStatement.setInt(1, userId);
		resultSet_2 = preparedStatement.executeQuery();
		if(resultSet_2.next())
		{
			return new User(resultSet_2.getInt("USER_ID"),
					resultSet_2.getString("FULL_NAME"), 
					resultSet_2.getString("EMAIL"), 
					resultSet_2.getLong("PHONE_NUMBER"),
					(resultSet_2.getString("GENDER").charAt(0)),
					resultSet_2.getDate("DOB"),
					getAdress(resultSet_2.getInt("USER_ID")), 
					resultSet_2.getString("COMPANY"), 
					resultSet_2.getString("PROFILE_PICTURE"),
					resultSet_2.getInt("STATUS"),
					resultSet_2.getInt("BLOCK_COUNT"),
					resultSet_2.getDate("LAST_ACTIVE"));
		}
		return null;
		
	}
	private Address getAdress(int userId) throws SQLException
	{
		String sql="SELECT * FROM USERS_ADDRESS WHERE USER_ID = ?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,userId);
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			return new Address(resultSet.getInt("AID"), 
					resultSet.getString("CITY"),
					resultSet.getString("STATE"),
					resultSet.getString("COUNTRY"),
					resultSet.getInt("PINCODE"), 
					userId);
		}
		return null;
	}

	@Override
	public boolean checkBirthday(int userId) throws SQLException {
		Calendar todaysDate = Calendar.getInstance();
		Calendar bdayDate = Calendar.getInstance();
		String sql="SELECT DOB FROM USERS WHERE USER_ID = ?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,userId);
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			java.sql.Date currentDate  = new java.sql.Date(System.currentTimeMillis());
			todaysDate.setTime(currentDate);
			bdayDate.setTime(resultSet.getDate("DOB"));
			if((todaysDate.get(Calendar.MONTH) == bdayDate.get(Calendar.MONTH)) && ((todaysDate.get(Calendar.DAY_OF_MONTH)==bdayDate.get(Calendar.DAY_OF_MONTH))))
				return true;
		}
		return false;
	}

	@Override
	public List<User> showRequests(int userId) throws SQLException, UserNotFoundException {
		preparedStatement = connection.prepareStatement("SELECT * FROM FRIENDSHIP WHERE USER_ID = ? AND STATUS = ?");
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, 0);
		ArrayList<Integer> friendIds = new ArrayList<Integer>();
		List<User> friendList = new ArrayList<User>();
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			friendIds.add(resultSet.getInt("FRIEND_ID"));
		}
		preparedStatement = connection.prepareStatement("SELECT * FROM FRIENDSHIP WHERE FRIEND_ID = ? AND STATUS = ?");
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, 0);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			friendIds.add(resultSet.getInt("USER_ID"));
		}
		System.out.println(friendIds);
		preparedStatement_2 = connection.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");
		for(Integer id: friendIds) {
			friendList.add(getUser(id));
	}
		
		return friendList;
	}

}
