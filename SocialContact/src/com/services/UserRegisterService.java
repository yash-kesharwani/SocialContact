package com.services;

import java.sql.SQLException;
import java.util.Date;

import com.exceptions.UserAlreadyExistsException;
import com.exceptions.UserNotFoundException;

public interface UserRegisterService
{
	public int userRegister(String fullName, String email, long phone, char gender,Date dob,String city,String state,String country,int pincode,String company,String picture, String userName, String password  );
	boolean validateAge(Date dob);
	boolean checkUnique(String email, String userName, long phone )throws UserAlreadyExistsException, UserNotFoundException, SQLException;
	boolean checkDisable(int status);
	int userRegister(String fullName, String email, long phone, char gender, java.sql.Date dob, String city,
			String state, String country, int pincode, String company, String picture, String userName,
			String password) throws UserNotFoundException, SQLException;
	boolean validateAge(java.sql.Date dob);
}
