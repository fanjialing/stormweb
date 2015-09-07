package org.storm.usercenter.service;

import java.util.List;

import org.storm.usercenter.entity.UserManagement;

public interface UserManagementService {
		public List<UserManagement> init(String page,String pageSize,String filter);
		
		public UserManagement getUserIDAndPwd(String key);

		public int QueryCount(String page, String pageSize,String filter);
		
		
}
