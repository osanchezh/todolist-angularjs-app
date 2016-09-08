package org.osanchezhuerta.angularjs.controller.rest;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.osanchezhuerta.angularjs.web.model.ResponseMessage;
import org.osanchezhuerta.angularjs.web.model.ResponseMessage.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Component("pingController")
@Path("/api")
public class PingController{
	private static final Logger LOGGER =  LoggerFactory.getLogger(PingController.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUser(){
	     return "temporal";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("ping")
    public ResponseMessage ping (@Context final HttpServletResponse response) {    
        //return new ResponseEntity<ResponseMessage>(ResponseMessage.info("connected"), HttpStatus.OK);
		
	    //set HTTP code to "200"
	    response.setStatus(HttpServletResponse.SC_OK);
	    try {
	        response.flushBuffer();
	    }catch(Exception e){
	    	LOGGER.error(e.getMessage(), e);
	    }
	    
		return ResponseMessage.info("connected");
    }
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("me")
    public Map<String, Object> user(@Context final HttpServletResponse response) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "admin");
        
	    response.setStatus(HttpServletResponse.SC_OK);
	    try {
	        response.flushBuffer();
	    }catch(Exception e){
	    	LOGGER.error(e.getMessage(), e);
	    }
	    
        return map;
    }
    
}
