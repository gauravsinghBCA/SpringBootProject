package com.User.User.Management.System.service;

import com.User.User.Management.System.entity.userData;

public interface UserService {
	
	public userData createData(userData user);
	public boolean checkEmail(String email);

}
