package com.uproad.entity;

import java.sql.Timestamp;

public class Blog {
	private int blogId;
	private String blogTitle;
	private String blogContent;
	private int authorId;
	private Timestamp blogFirstTime;
	private Timestamp blogLastTime;
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Timestamp getBlogFirstTime() {
		return blogFirstTime;
	}
	public void setBlogFirstTime(Timestamp blogFirstTime) {
		this.blogFirstTime = blogFirstTime;
	}
	public Timestamp getBlogLastTime() {
		return blogLastTime;
	}
	public void setBlogLastTime(Timestamp blogLastTime) {
		this.blogLastTime = blogLastTime;
	}
	public Blog(int blogId, String blogTitle, String blogContent, int authorId, Timestamp blogFirstTime,
			Timestamp blogLastTime) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
		this.authorId = authorId;
		this.blogFirstTime = blogFirstTime;
		this.blogLastTime = blogLastTime;
	}
	public Blog(){
		
	}
}
