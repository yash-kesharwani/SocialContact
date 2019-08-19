package com.services;

import java.util.Date;

import com.exceptions.UserAlreadyExistsException;

public interface UserRegisterService
{
	public boolean userRegister(String fullName, String email, long phone, char gender,Date dob,String city,String state,String country,int pincode,String company,String picture, String userName, String password  );
	boolean validateAge(Date dob);
	boolean checkUnique(String email, String userName, long phone )throws UserAlreadyExistsException;
	boolean checkDisable(int status);
}
