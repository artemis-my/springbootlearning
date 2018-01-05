package com.uproad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uproad.entity.Blog;
import com.uproad.entity.User;
import com.uproad.service.BlogService;
import com.uproad.util.JwtUtil;


@RestController
public class BlogRestController {
	@Autowired
	private BlogService blogService;
	private static JwtUtil jutil=new JwtUtil();
	@RequestMapping(value="/api/login",method=RequestMethod.POST)
	public Map<String, Object> login(@RequestBody User user){
		System.out.println(user.getUserAccount()+","+user.getUserPassword());
		String account=user.getUserAccount();
		String pwd=user.getUserPassword();
		Map<String, Object> resultMap=new HashMap<String, Object>();
		String secret="MmHnjSq1R3G";
		if("zmy".equals(account)&&"1234".equals(pwd)){
			String token=jutil.jwtBuilder(account, "user", secret, 100000);
			resultMap.put("status", "authok");
			resultMap.put("token",token);
		}else{
			resultMap.put("status", "autherr");
		}
		return resultMap;
	}
	@RequestMapping(value="/api/myblog",method=RequestMethod.GET)
	public List<Blog> getOwnBlog(@RequestHeader String Authorization,@RequestParam String id){
			User user=new User(1, "zmy", "1234", "artemis", 10, "男", "15250025534", "just for fun");
			return blogService.getBlogByUser(user);
	}
}
