package com.tedu.cloudnotes.service;

import com.tedu.cloudnotes.util.NoteResult;

public interface UserService {
	public NoteResult addUser(String name,String password,String nick);
	
	public NoteResult checkLogin(String name,String password);

}
