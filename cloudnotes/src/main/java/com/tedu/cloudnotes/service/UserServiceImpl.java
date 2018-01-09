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
		//�û���������
		if(user==null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		//�������
		//���û���������ļ���
		String md5_pwd;
		try {
			md5_pwd = NoteUtil.md5(password);
			if(!user.getCn_user_password().equals(md5_pwd)){
					result.setStatus(2);
					result.setMsg("�������");
					return result;
			}
		} catch (Exception e) {
			throw new NoteException("��������쳣",e);
		}
		
		
		//��½�ɹ�
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		return result;
	}

}
