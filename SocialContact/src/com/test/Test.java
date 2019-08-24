package com.test;

import java.sql.SQLException;

import org.apache.derby.tools.sysinfo;

import com.beans.User;
import com.daoImpl.FriendDaoImpl;
import com.daoImpl.UserDaoImpl;
import com.exceptions.FriendNotFoundException;
import com.exceptions.UserNotFoundException;

public class Test {

	public static void main(String args[]) throws SQLException, FriendNotFoundException, UserNotFoundException {
		UserDaoImpl u=new UserDaoImpl();
		FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
		System.out.println(u.userLogin("Fiona", "1234567890"));
		System.out.println(u.getUser(4));
		
		System.out.println(u.showRequests(4));
		System.out.println(u.checkBirthday(4));
//		System.out.println(friendDaoImpl.getFriendList(3));
//		System.out.println(friendDaoImpl.getFriendInfo(3, 4));
//		System.out.println(friendDaoImpl.searchUserByName("Himanshi"));
//			System.out.println(friendDaoImpl.sendFriendRequest(4, 5));
//		System.out.println(friendDaoImpl.acceptFriendRequest(4, 5));
//		System.out.println(friendDaoImpl.blockFriend(4, 5));
//		System.out.println(friendDaoImpl.unblockFriend(4, 5));
//		System.out.println(friendDaoImpl.showBlockedFriends(4));
//		System.out.println(friendDaoImpl.checkBlocked(4, 5));
//		System.out.println(friendDaoImpl.checkRequested(3, 5));
	}
}
