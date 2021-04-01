package com.ait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.entity.Contact;
import com.ait.service.IContactService;

@Controller
public class ContactOperationController {
	private IContactService service;
	
	public ContactOperationController(IContactService service) {
		
		this.service = service;
	}

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		
		Contact contactObj =service.getContactById(contactId);
		model.addAttribute("contact", contactObj);
		return "contact";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model) {
		boolean isDeleted = service.deleteContactById(contactId);
		
		if (isDeleted) {
			model.addAttribute("succMsg", "Contact Deleted Successfully");
		}else {
			model.addAttribute("failMsg","Failed to Delete Contact");
		}
		
		return "redirect:view-contacts";
	}
}
