package com.mybatis.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.domain.User;
import com.mybatis.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
		User user = new User();
		user.setName(name);
		List<User> users = userService.getUserList(user);
		model.addAttribute("users", users);
		return "list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object delete(@PathVariable(value = "id") int id) {
		userService.deleteUser(id);
		return null;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		model.addAttribute("action", "update");
		model.addAttribute("actionName", "更新用户");
		return "userForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("user") User user) {
		user.setCreateAt(new Date());
		userService.updateUser(user);
		return "redirect:/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("action", "insert");
		model.addAttribute("actionName", "添加用户");
		return "userForm";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Object insert(@ModelAttribute("user") User user) {
		user.setCreateAt(new Date());
		userService.insertUser(user);
		return "redirect:/list";
	}
}
