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
		//�ж��û���
		User user = userDao.findByName(name);
		if(user==null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		//�ж�����
		if(!user.getCn_user_password().equals(password)){
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		//��¼�ɹ�
		result.setStatus(0);
		result.setMsg("��½�ɹ�");
		result.setData(user);
		return result;
	}

}
