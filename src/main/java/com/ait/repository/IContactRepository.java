package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.Contact;

public interface IContactRepository extends JpaRepository<Contact, Serializable> {

}
