package com.uproad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uproad.dao.BlogDao;
import com.uproad.entity.Blog;
import com.uproad.entity.User;
import com.uproad.service.BlogService;
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogDao;
	@Override
	public List<Blog> getBlogByUser(User user) {
		int authorId=user.getUserId();
		return blogDao.getBlogByAuthor(authorId);
	}

}
