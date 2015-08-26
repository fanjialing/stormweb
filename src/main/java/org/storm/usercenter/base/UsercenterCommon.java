package org.storm.usercenter.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.storm.usercenter.util.CommonUtil;

public class UsercenterCommon  {
	private static Logger logger =  Logger.getLogger(UsercenterCommon.class);
	
	public static JdbcTemplate usercenterJdbcTemplate;

	//11
	
	public JdbcTemplate getUsercenterJdbcTemplate() {
		return usercenterJdbcTemplate;
	}


	public static void setUsercenterJdbcTemplate(JdbcTemplate usercenterJdbcTemplate) {
		System.out.println(usercenterJdbcTemplate);
		UsercenterCommon.usercenterJdbcTemplate = usercenterJdbcTemplate;
	}

	
	
	public static Connection getConnection() throws SQLException{
		return usercenterJdbcTemplate.getDataSource().getConnection();
	}
	

	/**
	 * 关闭连接
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
		if(ps != null){
			ps.close();
		}
		if(rs != null){
			rs.close();
		}
		if(conn != null){
			conn.close();
		}
		} catch (SQLException e) {
			logger.error(CommonUtil.getStackTrace(e));
		}
	}
	
	
	/**
	 * 关闭连接
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement ps){
		try {
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			conn.close();
		}
		} catch (SQLException e) {
			logger.error(CommonUtil.getStackTrace(e));
		}
	}
}
