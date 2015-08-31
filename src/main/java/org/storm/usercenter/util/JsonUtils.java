package org.storm.usercenter.util;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class JsonUtils {


	public static String createJsonString(String key,Object value)
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}


	
}
