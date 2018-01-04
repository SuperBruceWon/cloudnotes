package com.tedu.cloudnotes.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tedu.cloudnotes.dao.UserDao;
import com.tedu.cloudnotes.entity.User;
import com.tedu.cloudnotes.util.NoteResult;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public NoteResult checkLogin(String name, String password) {
		NoteResult result = new NoteResult();
		//判断用户名
		User user = userDao.findByName(name);
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//判断密码
		if(!user.getCn_user_password().equals(password)){
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		//登录成功
		result.setStatus(0);
		result.setMsg("登陆成功");
		result.setData(user);
		return result;
	}

}
