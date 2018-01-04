package com.tedu.cloudnotes.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloudnotes.service.UserService;
import com.tedu.cloudnotes.util.NoteResult;
@Controller
public class UserLoginController {
	@Resource
	private UserService userService;
	@RequestMapping("/user/login.do")
	@ResponseBody
	public NoteResult execute(String name,String password){
		NoteResult result =
				userService.checkLogin(name, password);
		return result;
		
	}
}
