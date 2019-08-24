package com.dao;

import java.sql.SQLException;
import java.util.Map;

public interface AdminDao 
{
	 public boolean deleteUser(int userId)throws SQLException;
	 public boolean disableUser(int userId)throws SQLException;
	 public Map<Integer,String> getToDisable() throws SQLException;
	 public Map<Integer,String> getToDelete() throws SQLException;
	 public int[] getSystemInfo() throws SQLException;
	
}
