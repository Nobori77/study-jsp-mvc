package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;
import com.app.vo.PostVO;

public class PostUpdateOkController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		PostVO postVO = new PostVO();
		PostDAO postDAO = new PostDAO();
		
		String id = req.getParameter("id");
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");
		
		postVO.setId(Long.parseLong(id));
		postVO.setPostTitle(postTitle);
		postVO.setPostContent(postContent);
		
		postDAO.update(postVO);
		
		result.setPath("/mvc/postlist.post");
		result.setRedirect(true);
		return result;
	}

}
