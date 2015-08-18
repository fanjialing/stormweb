package org.storm.usercenter.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class CommonUtil {
    /**
     * 取当前系统日期  时间格式：YYYY-MM-DD
     * @return String
     */
    public static String getCurrDate(){
    	 Date date = new Date();
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	return  sdf.format(date);
    }
    
    
    /**
     * 取当前系统日期  时间格式：
     * @return String
     */
    public static String getCurrDate2(){
    	 Date date = new Date();
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	 return  sdf.format(date);
    }
    
    
	/**
	 *  判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		if (str == null || str.length()<=0) {
			return false;
		}
		return true;
	}

	public static boolean isNotNull(Long str) {
		if (str == null) {
			return false;
		}
		return true;
	}
   
	
	   /**
     * 将异常堆栈转换为字符串
     * @param aThrowable 异常
     * @return String
     */
    public static String getStackTrace(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
      }
    
    
    /**
     * 
     * 获取外网IP
     * @return
     */
    public static String getIp(){
    	InputStream in = null;
        OutputStream out = null;
        String inputLine2 = "";
        try {
            // 检查命令行参数
            if (false)
                throw new IllegalArgumentException("Wrong number of args");
            URL url = new URL("http://www.3322.org/dyndns/getip"); // 创建 URL
            in = url.openStream(); // 打开到这个URL的流
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String inputLine;
            while ((inputLine = reader.readLine()) != null)   
             {
            	inputLine2 += inputLine;
             }
        }catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java GetURL <URL> [<filename>]");
        } finally { // 无论如何都要关闭流
            try {
                in.close();
                out.close();
            } catch (Exception e) {
            }
        }
        
        return inputLine2;
    }
    
    
    /**
     * 防止SQL注入
     * @param str
     * @return
     */
    public static String TransactSQLInjection(String str)
    {
          return str.replaceAll(".*([';]+|(--)+).*", " ");

    }
    
    
    public static int getRomdow(){
    	Random ran=new Random();
    	int r=0;
    	m1:while(true){
    	    int n=ran.nextInt(10000);
    	    r=n;
    	    int[] bs=new int[4];
    	    for(int i=0;i<bs.length;i++){
    	        bs[i]=n%10;
    	        n/=10;
    	    }
    	    Arrays.sort(bs);
    	    for(int i=1;i<bs.length;i++){
    	        if(bs[i-1]==bs[i]){
    	            continue m1;
    	        }
    	    }
    	    break;
    	}
    	return r;  
    }
}
