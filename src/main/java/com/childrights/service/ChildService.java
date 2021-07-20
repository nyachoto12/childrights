package com.childrights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.childrights.model.Child;
import com.childrights.repo.ChildRepository;


public interface ChildService {
	
	public List<Child> getAllChild();
	void saveChild(Child child);
	void deleteChildById(Long id);

    Child findChildById(Long id);
	
}
