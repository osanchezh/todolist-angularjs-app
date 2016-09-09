package org.osanchezhuerta.angularjs.controller.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import org.osanchezhuerta.angularjs.web.domain.Post;
import org.osanchezhuerta.angularjs.web.model.CommentDetails;
import org.osanchezhuerta.angularjs.web.model.CommentForm;
import org.osanchezhuerta.angularjs.web.model.PostDetails;
import org.osanchezhuerta.angularjs.web.model.ResponseMessage;
import org.osanchezhuerta.angularjs.web.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.ws.rs.Consumes;


@Component("postController")
@Path("/api/posts")
public class PostController {
	private static final Logger LOGGER =  LoggerFactory.getLogger(PostController.class);
    
	@Autowired
	@Qualifier("blogService")
    private BlogService blogService;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<PostDetails> getAllPosts(
            @QueryParam("q") String keyword, //
            @QueryParam("status") Post.Status status) {

		LOGGER.debug("get all posts of q@" + keyword + ", status @" + status);
		List<PostDetails> posts = blogService.searchPostsByCriteria();
        LOGGER.debug("get posts size @" + posts.size());

        return posts;
    }
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public PostDetails getPost(@PathParam("id") Long id) {

    	LOGGER.debug("get postsinfo by id @" + id);

        PostDetails post = blogService.findPostById(id);

        LOGGER.debug("get post @" + post);
        return post;
    }
    

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/comments")
    public CommentDetails getCommentsOfPost(
    		@PathParam("id") Long id) {

		LOGGER.debug("get comments of post@" + id);

		CommentDetails commentsOfPost = blogService.findCommentsByPostId(id);

        //LOGGER.debug("get post comment size @" + commentsOfPost.getTotalElements());

        return commentsOfPost;
    }
    
    @POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/comments")
    public ResponseMessage createCommentOfPost(
    		@PathParam("id") Long id, CommentForm comment) {

    	LOGGER.debug("new comment of post@" + id + ", comment" + comment.toString());

        CommentDetails saved = blogService.saveCommentOfPost(id, comment);

        LOGGER.debug("saved comment @" + saved.getId());

        return ResponseMessage.success("comment.created");
    }
    
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
    
	
}
