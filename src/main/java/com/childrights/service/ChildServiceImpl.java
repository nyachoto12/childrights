package com.childrights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.childrights.model.Child;
import com.childrights.repo.ChildRepository;



@Service
public class ChildServiceImpl implements ChildService{

	@Autowired
	private ChildRepository childRepo;
	@Override
	public List<Child> getAllChild() {
		// TODO Auto-generated method stub
		return childRepo.findAll();
	}
	@Override
	public void saveChild(Child child) {
		this.childRepo.save(child);	
	}
	@Override
	public void deleteChildById(Long id) {
		this.childRepo.deleteById(id);
	}
	@Override
	public Child findChildById(Long id) {
		 Optional<Child> optional = childRepo.findById(id);
	        Child Child = null;
	        if(optional.isPresent()){
	            Child= optional.get();
	        }else{
	            throw new RuntimeException("Child is not available with : " + id + " as ID");
	        }
	        return Child;
	}
	  

}
