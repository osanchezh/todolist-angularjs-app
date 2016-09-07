package org.osanchezhuerta.angularjs.controller.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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


@Component("newsEntryController")
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
	@Path("ping/test")
    public ResponseMessage ping() {    
        //return new ResponseEntity<ResponseMessage>(ResponseMessage.info("connected"), HttpStatus.OK);
		return new ResponseMessage(Type.info,"test");
    }
    
}
