package com.childrights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.childrights.model.Child;
import com.childrights.model.User;
import com.childrights.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userRepo.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		this.userRepo.deleteById(id);
		
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> optional = userRepo.findById(id);
        User user = null;
        if(optional.isPresent()){
            user= optional.get();
        }else{
            throw new RuntimeException("User is not available with : " + id + " as ID");
        }
        return user;
	}
}
