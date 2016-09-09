package org.osanchezhuerta.angularjs.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	private static Map<Long,List<CommentDetails>> mapCommentDetails = new HashMap<Long,List<CommentDetails>>(0);
	private static final AtomicLong counterPost = new AtomicLong();
	private static final AtomicLong counterComment = new AtomicLong();

    static{
    	lstPostDetails = populateDummyUsers();
    
    }

	@Override
	public List<PostDetails> searchPostsByCriteria() {
		return lstPostDetails;
	}
	
	@Override
	public PostDetails savePost(PostForm form) {
		PostDetails postDetails= new PostDetails();
		postDetails.setId(counterPost.incrementAndGet());
		postDetails.setContent(form.getContent());
		postDetails.setCreatedDate(new Date());
		postDetails.setStatus("ALL");
		postDetails.setTitle(form.getTitle());
		lstPostDetails.add(postDetails);
		return postDetails;
	}

	@Override
	public PostDetails updatePost(Long id, PostForm form) {
		PostDetails postDetailsR =null;
        for(PostDetails postDetails : lstPostDetails){
        	if(postDetails.getId().equals(id)){
        		postDetails.setContent(form.getContent());
        		postDetails.setTitle(form.getTitle());
        		postDetailsR = postDetails;
        	}
        }
		return postDetailsR;
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
		CommentDetails commentDetails = new CommentDetails();
		commentDetails.setContent(fm.getContent());
		commentDetails.setCreatedDate(new Date());
		commentDetails.setId(counterComment.incrementAndGet());
		if(mapCommentDetails.containsKey(id)){
			mapCommentDetails.get(id).add(commentDetails);
		}else{
			List<CommentDetails> lstCommentDetails = new ArrayList<CommentDetails>(0);
			lstCommentDetails.add(commentDetails);
			mapCommentDetails.put(id, lstCommentDetails);
		}
		

		return commentDetails;
	}

	@Override
	public boolean deletePostById(Long id) {
		
      int contadorEliminar=0;
	  for(int i=0;i<lstPostDetails.size();i++){
	        	if(lstPostDetails.get(i).getId().equals(id)){
	        		contadorEliminar=i;
	        	}
	        }		
	  return lstPostDetails.remove(contadorEliminar)!=null?true:false;
	  
	}

	@Override
	public void deleteCommentById(Long id) {
		if(mapCommentDetails.containsKey(id)){
			mapCommentDetails.remove(id);
		}
		
	}
	
	private static List<PostDetails> populateDummyUsers(){
		List<PostDetails> users = new ArrayList<PostDetails>();
		users.add(new PostDetails(counterPost.incrementAndGet(),"Sam", "NY", "sam@abc.com", new Date()));
		users.add(new PostDetails(counterPost.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com", new Date()));
		users.add(new PostDetails(counterPost.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com", new Date()));
		return users;
	}

	@Override
	public List<CommentDetails> findCommentsByPostId(Long id) {
		return mapCommentDetails.get(id);
	}



}
