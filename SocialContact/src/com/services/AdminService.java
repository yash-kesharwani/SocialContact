package com.services;

import java.util.Date;
import java.util.List;

import com.beans.User;
import com.exceptions.UserNotFoundException;

public interface AdminService
{
	public boolean adminLogin(String username, String password);
	public void getSystemInfo();
	public List<User> getToDisable()throws UserNotFoundException;
	public List<User> getToDelete()throws UserNotFoundException;
	public boolean disableUser(int userId, int status, int blockCount)throws UserNotFoundException;
	public boolean deleteUser(int userId, Date lastActive)throws UserNotFoundException;
}
