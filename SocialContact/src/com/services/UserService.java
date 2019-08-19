package com.services;

import java.util.Date;
import java.util.List;

import com.beans.User;
import com.exceptions.UserNotFoundException;

public interface UserService
{
	public boolean userLogin(String userName,String password);
	public User getUser(int userId)throws UserNotFoundException;
	public boolean chechBirthday(Date dob);
	public List<User> showRequests();
}
