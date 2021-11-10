package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.Contact;
import com.purn.fleetapp.repositories.ContactRepsitory;

@Service
public class ContactService {

	@Autowired
	private ContactRepsitory contactRepository;
	
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
	public void addContact(Contact contact) {
		contactRepository.save(contact);
	}
	public Optional<Contact> findById(Integer id){
		return contactRepository.findById(id);
	}
	public void deleteContact(Integer id) {
		contactRepository.deleteById(id);
	}
}
