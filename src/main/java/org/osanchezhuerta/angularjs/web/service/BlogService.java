package org.osanchezhuerta.angularjs.web.service;

import java.util.List;

import org.osanchezhuerta.angularjs.web.model.CommentDetails;
import org.osanchezhuerta.angularjs.web.model.CommentForm;
import org.osanchezhuerta.angularjs.web.model.PostDetails;
import org.osanchezhuerta.angularjs.web.model.PostForm;


public interface BlogService {
	PostDetails savePost(PostForm form);
	PostDetails updatePost(Long id, PostForm form);
	PostDetails findPostById(Long id);
	CommentDetails saveCommentOfPost(Long id, CommentForm fm);
    List<PostDetails> searchPostsByCriteria();
	boolean deletePostById(Long id);
	void deleteCommentById(Long id);
	List<CommentDetails> findCommentsByPostId(Long id);
}
