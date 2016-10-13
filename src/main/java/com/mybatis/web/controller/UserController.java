package com.mybatis.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.mybatis.domain.User;
import com.mybatis.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String list(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize, Model model) {
		PageInfo<User> pageInfo = userService.getUserList(name, pageNo, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("actionName", "用户列表");
		return "list";
	}

	@GetMapping("/delete/{id}")
	@ResponseBody
	public Object delete(@PathVariable(value = "id") int id) {
		userService.deleteUser(id);
		return null;
	}

	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		model.addAttribute("action", "update");
		model.addAttribute("actionName", "更新用户");
		return "userForm";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("user") User user) {
		user.setCreatedAt(new Date());
		userService.updateUser(user);
		return "redirect:/list";
	}

	@GetMapping("/insert")
	public String insertForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("action", "insert");
		model.addAttribute("actionName", "添加用户");
		return "userForm";
	}

	@PostMapping("/insert")
	public Object insert(@ModelAttribute("user") User user) {
		user.setCreatedAt(new Date());
		userService.insertUser(user);
		return "redirect:/list";
	}
}
