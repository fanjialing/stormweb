package org.storm.usercenter.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.storm.usercenter.base.UsercenterCommon;
import org.storm.usercenter.entity.UserManagement;
import org.storm.usercenter.service.UserManagementService;
public class UserManagementServiceImpl extends SqlSessionDaoSupport implements UserManagementService{
	

	
	public List<UserManagement> init(String page,String pagesize) {
	 
//		SqlSession session = this.getSqlSession();
//		List<UserManagement> list =session.selectList("test");
//		return list;
		List<UserManagement>  userManagements  =  new ArrayList<UserManagement>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		StringBuffer sbf = new StringBuffer();
		int begin = (Integer.parseInt(page) * Integer.parseInt(pagesize)) -  Integer.parseInt(pagesize);
		sbf.append(" select users.userName,");
		sbf.append(" users.userCode,");
		sbf.append(" users.id,");
		sbf.append(" users.userPwd");
		sbf.append(" from userManagement  users");
		sbf.append(" limit ").append(begin).append(",").append(pagesize);
		try {
			connection = UsercenterCommon.getConnection();
			preparedStatement = connection.prepareStatement(sbf.toString());
			resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				UserManagement userManagement = new UserManagement();
				userManagement.setId(resultSet.getInt("id"));
				userManagement.setUserCode(resultSet.getString("usercode"));
				System.out.println(resultSet.getString("userpwd"));
				userManagement.setUserPwd(resultSet.getString("userpwd"));
				userManagements.add(userManagement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			UsercenterCommon.close(connection, preparedStatement, resultSet);
		}
		return userManagements;
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

	public int QueryCount(String page, String pagesize) {
//		SqlSession session = this.getSqlSession();
//		List<UserManagement> list =session.selectList("test");
//		return list;
		List<UserManagement>  userManagements  =  new ArrayList<UserManagement>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		StringBuffer sbf = new StringBuffer();
		sbf.append(" select users.userName,");
		sbf.append(" users.userCode,");
		sbf.append(" users.id,");
		sbf.append(" users.userPwd");
		sbf.append(" from userManagement  users");
		try {
			connection = UsercenterCommon.getConnection();
			preparedStatement = connection.prepareStatement(sbf.toString());
			resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				UserManagement userManagement = new UserManagement();
				userManagement.setId(resultSet.getInt("id"));
				userManagement.setUserCode(resultSet.getString("usercode"));
				userManagement.setUserPwd(resultSet.getString("userpwd"));
				userManagements.add(userManagement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			UsercenterCommon.close(connection, preparedStatement, resultSet);
		}
		return userManagements.size();
	}
	
	
	
}
