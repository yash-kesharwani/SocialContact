package com.servicesImpl;

import java.util.Date;
import java.util.List;

import com.beans.User;
import com.exceptions.UserNotFoundException;
import com.services.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public boolean adminLogin(String username, String password)
	{
		
		return false;
	}

	@Override
	public void getSystemInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getToDisable() throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getToDelete() throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean disableUser(int userId, int status, int blockCount) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId, Date lastActive) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
