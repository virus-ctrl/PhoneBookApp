package com.ait.service;

import java.util.List;

import com.ait.entity.Contact;

public interface IContactService {
	
	public boolean saveOrUpdateContact(Contact contact);
	
	public Contact getContactById(Integer contactId); 
	
	public boolean deleteContactById(Integer contactId); 
	
	public List<Contact> getAllContacts();
}
