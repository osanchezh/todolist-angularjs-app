package org.osanchezhuerta.angularjs.controller.rest;

import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("pingController")
@Path("/api/posts")
public class PostController {
	private static final Logger LOGGER =  LoggerFactory.getLogger(PostController.class);

}
