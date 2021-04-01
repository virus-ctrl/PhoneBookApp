package com.ait.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ait.entity.Contact;
import com.ait.service.IContactService;

@Controller
public class ContactInfoController {
	
	private IContactService service;
	
	public ContactInfoController(IContactService service) {
		this.service = service; 
	}
	
	@GetMapping("/load-form")
	public String loadForm(Model model) {
		Contact cobj=new Contact();
		
		//sending data from controller to UI
		model.addAttribute("contact", cobj);
		
		//returning logical view name
		return "contact";
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitBtn(Contact contact, Model model) {
		boolean isSaved = service.saveOrUpdateContact(contact);
		
		if(isSaved) {
			model.addAttribute("succMsg","Contact Saved");
		}else {
			model.addAttribute("failMsg","Failed to Save Contact");
		}
		return "contact"; 
	}
	
	@GetMapping("/view-contacts")
	public String handleViewsContactHyperLink(Model model) {
		
		List<Contact> allContacts = service.getAllContacts();
		
		model.addAttribute("contacts", allContacts);
		
		return "contacts-display";
	}
}
