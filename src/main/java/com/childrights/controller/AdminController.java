package com.childrights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.childrights.model.Role;
import com.childrights.model.User;
import com.childrights.repo.RoleRepository;
import com.childrights.repo.UserRepository;
import com.childrights.service.RoleService;
import com.childrights.service.UserService;
@Controller
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encodePasword;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;;
	
	@GetMapping("admin/allUser")
	public ModelAndView allUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/allUser");
		List<User> users = userService.getAllUser();
		List<Role> roles = roleService.getAllRole();
		
		mv.addObject("user", users);
		mv.addObject("role", roles);
		return mv;
	}
	@GetMapping("/admin/userAdd")
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView();
		List<Role> roles = roleService.getAllRole();
		mv.addObject("role", roles);
		
		mv.setViewName("/admin/userAdd");
		return mv;
	}
	
    
	@PostMapping("/admin/add")
	public String addNewUser(@ModelAttribute User  user) {
		String pwd = user.getPassword();
		String encryPass = encodePasword.encode(pwd);
		user.setPassword(encryPass);
	    userService.saveUser(user);
		return "redirect:/admin/allUser";
	}
	
	@GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable(value = "id") Long id , Model model, RedirectAttributes redirectAttributes){
		 User user = userService.findUserById(id);
		 model.addAttribute("user", user);
    return "admin/updateUser";
}
@GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
	this.userService.deleteUserById(id);
    return "redirect:/admin/allUser";
 }
}
