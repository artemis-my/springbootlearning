package com.uproad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.uproad.entity.Blog;

@Mapper
public interface BlogDao {
	@Select("select * from blog where authorId=#{authorId}")
	@Results({
		@Result(property="blogId",column="blogId"),
		@Result(property="blogTitle",column="blogTitle"),
		@Result(property="blogContent",column="blogContent"),
		@Result(property="authorId",column="authorId"),
		@Result(property="blogFirstTime",column="blogFirstTime"),
		@Result(property="blogLastTime",column="blogLastTime")
	})
	List<Blog> getBlogByAuthor(int authorId);
}
