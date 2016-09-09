package org.osanchezhuerta.angularjs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezhuerta.angularjs.web.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/todolist-angularjs-appctx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	@Qualifier("blogService")
	private BlogService blogService;
	
	@Test
	public void testUserService() throws Exception{
		LOGGER.debug(".INIT.");
		LOGGER.debug("userService.loadUsers().size()="+blogService.searchPostsByCriteria().size());
		
	}
	
	
	public BlogService getBlogService() {
		return blogService;
	}


	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

}
