package com.services;

import java.util.List;

import com.beans.Address;
import com.beans.User;
import com.exceptions.FriendNotFoundException;
import com.exceptions.UserNotFoundException;

public interface FriendService 
{
	public User getFriendInfo(int friendId) throws FriendNotFoundException;
	public User searchUser(String fullName, Address address, String company)throws UserNotFoundException;
	public boolean sendFriendRequest();
	public boolean acceptFriendRequest();
	public boolean blockFriend();
	public boolean unblockFriend();
	public boolean deleteFriend();
	public List<User> showBlockedFriends(int userId);
	boolean checkBlocked();
	boolean checkRequested();
	
	
}
