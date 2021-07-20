package com.childrights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.childrights.model.Child;
import com.childrights.model.User;
import com.childrights.service.ChildService;



@Controller
public class ChildController {

	@Autowired
	private ChildService childService;
	
	@GetMapping("/admin/childAll")
	public String allChild(Model model) {
	 model.addAttribute("child", childService.getAllChild()); 
	 return "admin/childAll";
	}
	
	@GetMapping("/admin/addNewChild")
	public String addChild(Model mv) {
		Child child = new Child();
		mv.addAttribute("child", child);
		return "/admin/addNewChild";
	}
	
	@PostMapping("/saveChild")
	public String saveChild(@ModelAttribute("child") Child child) {
		childService.saveChild(child);
		return "redirect:/admin/childAll";
	}
	@GetMapping("/updateChild/{id}")
    public String updateChild(@PathVariable(value = "id") Long id , Model model, RedirectAttributes redirectAttributes){
		 Child child = childService.findChildById(id);
		 model.addAttribute("child", child);
    return "admin/updateChild";
}
@GetMapping("/deleteChild/{id}")
    public String deleteChild(@PathVariable(value = "id") Long id){
	this.childService.deleteChildById(id);
    return "redirect:/admin/childAll";
}
}
