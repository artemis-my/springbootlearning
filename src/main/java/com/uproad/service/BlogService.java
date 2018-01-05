package com.uproad.service;

import java.util.List;

import com.uproad.entity.Blog;
import com.uproad.entity.User;

public interface BlogService {
	List<Blog> getBlogByUser(User user);
}
