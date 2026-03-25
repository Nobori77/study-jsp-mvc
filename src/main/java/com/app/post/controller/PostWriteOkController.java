package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;
import com.app.dao.ProductDAO;
import com.app.vo.PostVO;
import com.app.vo.ProductVO;

public class PostWriteOkController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		PostVO postVO = new PostVO();
		PostDAO postDAO = new PostDAO();
		
		postVO.setPostTitle(req.getParameter("postTitle"));
		postVO.setPostContent(req.getParameter("postContent"));
		
		postDAO.insert(postVO);
		
		result.setPath("postlist.post");
		result.setRedirect(true);
		return result;
	}

}
