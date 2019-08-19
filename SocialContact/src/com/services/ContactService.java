package com.services;

import java.util.Date;
import java.util.List;

import com.beans.Address;
import com.beans.Contact;
import com.exceptions.ContactAlreadyExistsException;
import com.exceptions.ContactNotFoundException;

public interface ContactService
{
	public boolean addContact(String fullName,String email,long phone, Address contactAddress, Date dob, char gender, String company );
	boolean checkEmail();
	boolean checkUser() throws ContactAlreadyExistsException;
	public List<Contact> searchContact(String fullName, String email, long phone)throws ContactNotFoundException;
	public Contact updateContact(Contact c);
	public boolean deleteContact(int cId);

}
