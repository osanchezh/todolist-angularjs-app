package org.osanchezhuerta.angularjs.controller.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.osanchezhuerta.angularjs.web.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("commentController")
@Path("/api/comments")
public class CommentController {
	private static final Logger LOGGER =  LoggerFactory.getLogger(CommentController.class);

	@Autowired
	@Qualifier("blogService")
    private BlogService blogService;
    

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public void deleteComment(@PathParam("id") Long id, @Context final HttpServletResponse response) {
    
        	LOGGER.debug("get comments of post id @" + id);
 
    	    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    	    try {
    	        response.flushBuffer();
    	    }catch(Exception e){
    	    	LOGGER.error(e.getMessage(), e);
    	    }
    	    
        blogService.deleteCommentById(id);

    }


    public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
    
}
