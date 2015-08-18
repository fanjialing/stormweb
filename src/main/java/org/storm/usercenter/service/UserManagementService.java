package org.storm.usercenter.service;

import java.util.List;

import org.storm.usercenter.entity.UserManagement;

public interface UserManagementService {
		public List<UserManagement> init();
		
		public UserManagement getUserIDAndPwd(String key);
		
		
}
