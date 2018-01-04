package com.tedu.cloudnotes.service;

import com.tedu.cloudnotes.util.NoteResult;

public interface UserService {
	
	public NoteResult checkLogin(String name,String password);

}
