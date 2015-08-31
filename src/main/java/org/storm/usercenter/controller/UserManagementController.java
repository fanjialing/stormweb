package org.storm.usercenter.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.storm.usercenter.cache.MemcachedCacheManager;
import org.storm.usercenter.entity.UserManagement;
import org.storm.usercenter.service.UserManagementService;
import org.storm.usercenter.util.CommonUtil;
import org.storm.usercenter.util.IpUtil;
import org.storm.usercenter.util.JsonUtils;
import org.storm.usercenter.util.TheKey;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;

@Controller
@RequestMapping(value="/users")
public class UserManagementController {
	private Logger logger = Logger.getLogger(UserManagementController.class);
	
	@Autowired
	private UserManagementService userManagementService;
	@Autowired
	private MemcachedCacheManager cacheManager;
	
	
	//byte >> 
	
	@RequestMapping(value="/queryUser" , method = RequestMethod.GET) 
	public void queryData(HttpServletResponse response,HttpServletRequest request){
		String ip = IpUtil.getIpAddr(request);
		System.out.println(ip);
//	   cacheManager.getCache("test666").put("abcde", "我说过的一句话");
//	   String s = (String) cacheManager.getMemCache("test666").getValue("abcde");
		List<UserManagement> temps =userManagementService.init(request.getParameter("page"), request.getParameter("pagesize"));
		int count = userManagementService.QueryCount(request.getParameter("page"), request.getParameter("pagesize"));
		String josnString = JsonUtils.createJsonString("Rows", temps);
//		renderData(response, JSON.toJSONString(userManagementService.init() ,true));
		renderData(response, josnString.substring(0,josnString.length()-1)+",\"Total\":\""+count+"\"}");	

	}
	
	
	@RequestMapping(value="/login")
	public void login(HttpServletResponse response,HttpServletRequest request){
			String key  =  request.getParameter("key");
			if(CommonUtil.isNotNull(key)){
				TheKey thekey = new TheKey();
				thekey.getKey("123456");//生成密匙   
		        String   strEnc   =   thekey.getEncString(key);//加密字符串,返回String的密文   
		        System.out.println("加密后：：" + strEnc);
			}
//		renderData(response, JSON.toJSONString(userManagementService.init() ,true));
	}
	
	
	@RequestMapping(value="/main")
	public String main(HttpServletRequest request){
//		UserManagement userManagement  =  (UserManagement) request.getSession().getAttribute(BaseSession.USER_CODE);
//		logger.info("欢迎["+userManagement.getUserCode()+"]进入后台管理系统");
//		request.setAttribute("userManagement", userManagement);
		return "admin/index";
	}
	
	  /**
	   * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	   * 
	   * @param response
	   * @param data 
	   */
	public void renderData(HttpServletResponse response, String data) {
	    PrintWriter printWriter = null;
	    try {
	      response.setContentType("text/html;charset=utf-8");
	      printWriter = response.getWriter();
	      printWriter.print(data);
	    } catch (IOException ex) {
	    } finally {
	      if (null != printWriter) {
	        printWriter.flush();
	        printWriter.close();
	      }
	    }
	  }
	
	
    /**
     * Class<T> beanClass可以接受任何类型的javaBean,使用泛型调用者不用进行强转
     * @param <T>
     * @param request
     * @param beanClass
     * @return
     */
    protected  <T> T requestBean(HttpServletRequest request, Class<T> beanClass) {
        try {
            /**创建封装数据的bean**/
            T bean = beanClass.newInstance();
            Map map = request.getParameterMap();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
