package org.osanchezhuerta.angularjs.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.osanchezhuerta.angularjs.web.model.CommentDetails;
import org.osanchezhuerta.angularjs.web.model.CommentForm;
import org.osanchezhuerta.angularjs.web.model.PostDetails;
import org.osanchezhuerta.angularjs.web.model.PostForm;
import org.osanchezhuerta.angularjs.web.service.BlogService;
import org.springframework.stereotype.Service;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

	private static List<PostDetails> lstPostDetails = new ArrayList<PostDetails>(0);
	private static final AtomicLong counter = new AtomicLong();
    static{
    	lstPostDetails = populateDummyUsers();
    }

	@Override
	public List<PostDetails> searchPostsByCriteria() {
		return lstPostDetails;
	}
	
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
		PostDetails tpostDetails = null;
        for(PostDetails postDetails:lstPostDetails){
        	if(postDetails.getId().equals(id)){
        		tpostDetails = postDetails;
        	}
        }
		return tpostDetails;
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
	
	private static List<PostDetails> populateDummyUsers(){
		List<PostDetails> users = new ArrayList<PostDetails>();
		users.add(new PostDetails(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com", new Date()));
		users.add(new PostDetails(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com", new Date()));
		users.add(new PostDetails(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com", new Date()));
		return users;
	}

	@Override
	public CommentDetails findCommentsByPostId(Long id) {
		return null;
	}



}
