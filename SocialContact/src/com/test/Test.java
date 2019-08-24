package com.test;

import java.sql.SQLException;
import java.sql.Date;

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
		System.out.println(friendDaoImpl.showBlockedFriends(1));
//		u.addUser("Fiona", "fionajovita9@gmail.com", 733800280L, 'F', new Date(1997-02-06), "Mangalore", "Karnataka", "India", 575004, "HSBC", "picture", "fionaovita", "147852369");
//		System.out.println(u.getUser(733800280L));
//		System.out.println(u.getUser(201));
//		System.out.println(u.getUser("Fiona"));
//		System.out.println(u.getUser("fionajovita9@gmail.com"));
//		
		//		System.out.println(u.userLogin("Fiona", "1234567890"));
//		System.out.println(u.getUser(4));
//		
//		System.out.println(u.showRequests(4));
//		System.out.println(u.checkBirthday(4));
//		System.out.println(friendDaoImpl.getFriendList(5));
//		System.out.println(friendDaoImpl.getFriendInfo(5, 4));
//		System.out.println(friendDaoImpl.searchUserByName("Himanshi"));
//		System.out.println(friendDaoImpl.sendFriendRequest(4, 5));
//		System.out.println(friendDaoImpl.acceptFriendRequest(3, 4));
//		System.out.println(friendDaoImpl.blockFriend(5, 4));
//		System.out.println(friendDaoImpl.unblockFriend(3, 4));
//		System.out.println(friendDaoImpl.showBlockedFriends(4));
//		System.out.println(friendDaoImpl.checkBlocked(4, 5));
//		System.out.println(friendDaoImpl.checkRequested(3, 5));
//		System.out.println(friendDaoImpl.deleteFriend(3, 4));
	}
}
