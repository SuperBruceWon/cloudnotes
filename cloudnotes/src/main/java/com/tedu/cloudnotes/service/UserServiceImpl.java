package com.tedu.cloudnotes.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tedu.cloudnotes.dao.UserDao;
import com.tedu.cloudnotes.entity.User;
import com.tedu.cloudnotes.util.NoteException;
import com.tedu.cloudnotes.util.NoteResult;
import com.tedu.cloudnotes.util.NoteUtil;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public NoteResult checkLogin(String name, String password) {
		User user =
			userDao.findByName(name);
        NoteResult result = new NoteResult();
		//用户名不存在
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//密码错误
		//将用户输入的明文加密
		String md5_pwd;
		try {
			md5_pwd = NoteUtil.md5(password);
			if(!user.getCn_user_password().equals(md5_pwd)){
					result.setStatus(2);
					result.setMsg("密码错误");
					return result;
			}
		} catch (Exception e) {
			throw new NoteException("密码加密异常",e);
		}
		
		
		//登陆成功
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}

	public NoteResult addUser(String name, String password, String nick) {
	try{
		NoteResult result = new NoteResult();
        //检查是否重名
		User user_name = userDao.findByName(name);	
		if(user_name !=null){
			result.setStatus(1);
			result.setMsg("用户名被占用");
			return result;
		}
		//执行用户注册	
		User user = new User();
		user.setCn_user_name(name);
		user.setCn_user_nick(nick);
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);
		userDao.save(user);
		//创建返回结果
		result.setStatus(0);
		result.setMsg("注册成功");
		result.setData(user);
		return result;
		}catch(Exception e){
			throw new RuntimeException("用户注册异常",e);
		}
		
	}

}
