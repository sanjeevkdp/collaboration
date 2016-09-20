package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Blog;

public interface BlogDao {
	void saveOrUpdate(Blog blog);

	void editBlog(Blog blog);
		
	Blog get(String blog_id);
		
		List<Blog> listAllBlog();
		
		Blog getBlogByName(String title);
}
