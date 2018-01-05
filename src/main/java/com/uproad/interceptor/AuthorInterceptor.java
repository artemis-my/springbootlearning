package com.uproad.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.uproad.util.JwtUtil;

public class AuthorInterceptor implements HandlerInterceptor {
	private static JwtUtil jutil=new JwtUtil();

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		if(arg0.getRequestURI().indexOf("/api/myblog")==-1){
			return true;
		}else if("options".equalsIgnoreCase(arg0.getMethod())){
			return true;
		}else{
			/*Enumeration<String> headers=arg0.getHeaderNames();
			while(headers.hasMoreElements()){
				String key=headers.nextElement();
				String value=arg0.getHeader(key);
				System.out.println(key+"||||"+value);
			}*/
			if(arg0.getHeader("Authorization")!=null){
				String token=arg0.getHeader("Authorization");
				System.out.println(token);
				String result=jutil.jwtVerify(token, "MmHnjSq1R3G");
				if("token pass".equals(result)){
					return true;
				}else{
					arg1.setStatus(402);
					arg1.setHeader("token err", "token verify fail");
					return false;
				}
			}else{
				System.out.println("111");
				arg1.setStatus(401);
				return false;
			}
		}
	}

}
