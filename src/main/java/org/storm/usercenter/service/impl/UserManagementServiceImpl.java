package org.storm.usercenter.service.impl;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.storm.usercenter.entity.UserManagement;
import org.storm.usercenter.service.UserManagementService;
public class UserManagementServiceImpl extends SqlSessionDaoSupport implements UserManagementService{
	

	
	public List<UserManagement> init() {
	 
		SqlSession session = this.getSqlSession();
		List<UserManagement> list =session.selectList("test");
		return list;
	}

	public UserManagement getUserIDAndPwd(String key) {
		SqlSession session = this.getSqlSession();
		UserManagement  userManagement =  session.selectOne("checklogin",key);
		if(userManagement != null){
			
		}else{
			UserManagement management = new UserManagement();
			management.setUserCode(key);
			management.setUserNum("10000");
//			management.setUserPwd(userPwd);
			session.insert("insertUserManagement",management);
		}
		
		return null;
	}
	
	
	
}
