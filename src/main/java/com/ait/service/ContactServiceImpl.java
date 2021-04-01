package com.ait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ait.entity.Contact;
import com.ait.repository.IContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	private IContactRepository repository; 	
	
	public ContactServiceImpl(IContactRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public boolean saveOrUpdateContact(Contact contact) {
		Contact savedObj=repository.save(contact);
		
		//return  savedObj.getContactId()!=null? true:false;
		
		return  savedObj.getContactId()!=null;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repository.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		boolean isDeleted = false;
		try {
			repository.deleteById(contactId);
			isDeleted =true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	@Override
	public List<Contact> getAllContacts() {
		/*List<Contact> findAll=repository.findAll();
		return findAll;*/
		
		return repository.findAll();
	}

}
