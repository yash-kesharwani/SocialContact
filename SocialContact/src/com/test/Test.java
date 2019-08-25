package com.test;

import java.sql.SQLException;
import java.sql.Date;
import java.sql.DriverManager;

import org.apache.derby.tools.sysinfo;

import com.beans.Address;
import com.beans.Contact;
import com.beans.User;
import com.dao.ContactDao;
import com.daoImpl.AdminDaoImpl;
import com.daoImpl.ContactDaoImpl;
import com.daoImpl.FriendDaoImpl;
import com.daoImpl.UserDaoImpl;
import com.exceptions.FriendNotFoundException;
import com.exceptions.UserNotFoundException;

public class Test {

	public static void main(String args[]) throws SQLException, FriendNotFoundException, UserNotFoundException {
		UserDaoImpl u=new UserDaoImpl();
		FriendDaoImpl friendDaoImpl = new FriendDaoImpl();
//		System.out.println(friendDaoImpl.showBlockedFriends(1));
//		u.addUser("Fiona sS", "fisona7jovit.a9@gmail.com", 713381200280L, 'F', new Date(1997-02-06), "Mangalore", "Karnataka", "India", 575004, "HSBC", "picture", "fionsaovita", "1478152369");
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
		
		
		
		
//		ContactDaoImpl contactDao = new ContactDaoImpl();
//		contactDao.addContact("Fiona", "fi@gmail.com", 712128828L, new Address(2, "mlore", "ktaka", "india", 575004, 1), new Date(1997,06,02), 'f', "HSBC", 201, "picture");
//		System.out.println(contactDao.checkEmail("fiSDsoNDDaaA@gmail.com"));
//		System.out.println(contactDao.checkPhone(721258828L));
//		System.out.println(contactDao.searchContact("","fiSDsoNDDaaA@gmail.com ", 7128828L));
		
//		System.out.println(contactDao.updateContact(new Contact(901, "Foina", "fiSDoNDDaaA@gmail.com", 7121258828L, 'F', new Date(3897,07,02),new Address(201, "mlore", "ktaka", "india", 575004, 901), "HSBC", "picture", 201)));
//		System.out.println(contactDao.deleteContact(901));
		
		
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
//		System.out.println(adminDaoImpl.disableUser(301));
//		System.out.println(adminDaoImpl.getToDisable());
//		System.out.println(adminDaoImpl.getToDelete());
		System.out.println(adminDaoImpl.getSystemInfo()[0] + " "+ adminDaoImpl.getSystemInfo()[1]);
		
	}
}
