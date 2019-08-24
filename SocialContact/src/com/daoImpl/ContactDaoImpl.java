package com.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import com.beans.Address;
import com.beans.Contact;

public class ContactDaoImpl  {

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	 void connect() throws SQLException
	 {
		 con=DriverManager.getConnection("");
		 ((AdminDaoImpl) con).connect();
	 }

	public boolean addContact(String fullName, String email, long phone, Address contactAddress, Date dob, char gender,String company, int userId,String picture) throws SQLException
	{
		String sql="insert into contacts (full_name, email, phone_number, gender, dob, company, profile_picture, user_id) values(?,?,?,?,?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, fullName);
		pstmt.setString(2, email);
		pstmt.setLong(3, phone);
		if(gender=='m'||gender=='M')
			pstmt.setString(4, "M");
		else
			pstmt.setString(4, "F");
		pstmt.setDate(5, dob);
		pstmt.setString(6, company);
		pstmt.setString(7, picture);
		pstmt.setInt(8, userId);
		int a=pstmt.executeUpdate();
		if(a==1)return true;
		return false;
	}


	public boolean checkEmail(String email) throws SQLException 
	{
		String sql="select email from contacts where email=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,email);
		rs=pstmt.executeQuery();
		if(rs.next())return false;
		return true;
	}

	public boolean checkPhone(long phone) throws SQLException
	{
		String sql="select phone_number from contacts where phone_number=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setLong(1,phone);
		rs=pstmt.executeQuery();
		if(rs.next())return false;
		return true;
	}

	public List<Contact> searchContact(String fullName, String email, long phone) throws SQLException
	{
		String sql="select * from contacts where full_name=? or email=? or phone_number=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,fullName);
		pstmt.setString(2,email);
		pstmt.setLong(3,phone);
		rs=pstmt.executeQuery();
		 List<Contact> searched = null;
		 while(rs.next())
		 {
			 searched.add(new Contact(rs.getInt("c_id"), rs.getString("full_name"), rs.getString("email"), rs.getLong("phone_number"), (rs.getString("gender").charAt(0)), rs.getDate("dob"), getAdress(rs.getInt("c_id")), rs.getString("company"), rs.getString("profile_picture"), rs.getInt("user_id")));
		 }
		 return searched;
	}

	private Address getAdress(int c_id) throws SQLException
	{
		String sql="select * from contacts_adress where c_id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,c_id);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			return new Address(rs.getInt("a_id"), rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getInt("pincode"), c_id);
		}
		return null;
	}

	
	public boolean updateContact(Contact c) throws SQLException
	{
		String sql="update contacts set full_name =?, email=?, phone_number=?, gender=?, dob=?, company=?, profile_picture=? where c_id=?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, c.getFullName());
		pstmt.setString(2, c.getEmail());
		pstmt.setLong(3, c.getPhone());
		if(c.getGender()=='m'||c.getGender()=='M')
			pstmt.setString(4, "M");
		else
			pstmt.setString(4, "F");
		pstmt.setDate(5, c.getDob());
		pstmt.setString(6, c.getCompany());
		pstmt.setString(7, c.getPicture());
		pstmt.setInt(8, c.getcId());
		int a=pstmt.executeUpdate();
		boolean flag=updateAddress(c.getContactAddress().getaId(), c.getContactAddress().getCity(), c.getContactAddress().getState(), c.getContactAddress().getCountry(),c.getContactAddress().getPincode());
		if(a==1 && flag)return true;
		return false;
	}
	
	private boolean updateAddress(int aId, String city, String state,String country, int pincode)throws SQLException
	{
		String sql="update contacts_adress set city=?,state=?,country=?,pincode=? where a_id=? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, city);
		pstmt.setString(2, state);
		pstmt.setString(3, country);
		pstmt.setInt(4, pincode);
		pstmt.setInt(5, aId);
		int a=pstmt.executeUpdate();
		if(a==1)return true;
		return false;
	}

	
	public boolean deleteContact(int cId) throws SQLException
	{
		String sql="delete from contacts where c_id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, cId);
		int a=pstmt.executeUpdate();
		String sql1="delete from contacts_address where c_id=?";
		pstmt=con.prepareStatement(sql1);
		pstmt.setInt(1, cId);
		int b=pstmt.executeUpdate();
		if(a==1)return true;
		return false;
	}

}
