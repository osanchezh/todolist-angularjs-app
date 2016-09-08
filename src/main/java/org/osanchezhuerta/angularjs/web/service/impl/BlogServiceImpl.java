package org.osanchezhuerta.angularjs.web.service.impl;

import org.osanchezhuerta.angularjs.web.model.CommentDetails;
import org.osanchezhuerta.angularjs.web.model.CommentForm;
import org.osanchezhuerta.angularjs.web.model.PostDetails;
import org.osanchezhuerta.angularjs.web.model.PostForm;
import org.osanchezhuerta.angularjs.web.service.BlogService;
import org.springframework.stereotype.Service;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Override
	public PostDetails savePost(PostForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDetails updatePost(Long id, PostForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDetails findPostById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDetails saveCommentOfPost(Long id, CommentForm fm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePostById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteCommentById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
