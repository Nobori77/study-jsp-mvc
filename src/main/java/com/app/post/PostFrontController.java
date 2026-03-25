package com.app.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.post.controller.PostDeleteOkController;
import com.app.post.controller.PostListController;
import com.app.post.controller.PostReadController;
import com.app.post.controller.PostUpdateController;
import com.app.post.controller.PostUpdateOkController;
import com.app.post.controller.PostWriteController;
import com.app.post.controller.PostWriteOkController;


public class PostFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=utf-8;");
	    
		String target = req.getRequestURI().split("\\.")[0].replace(req.getContextPath() + "/", "");
		Result result = null;
		
		System.out.println(target);
		
		if(target.equals("postwrite")) {
			result = new PostWriteController().excute(req, resp);
		}else if(target.equals("postwrite-ok")) {
			result = new PostWriteOkController().excute(req, resp);
		}else if(target.equals("postlist")) {
			result = new PostListController().excute(req, resp);
		}else if(target.equals("postread")) {
			result = new PostReadController().excute(req, resp);
		}else if(target.equals("postupdate")) {
			result = new PostUpdateController().excute(req, resp);
		}else if(target.equals("postupdate-ok")) {
			result = new PostUpdateOkController().excute(req, resp);
		}else if(target.equals("postdelete-ok")) {
			result = new PostDeleteOkController().excute(req, resp);
		}else {
//			Not found 404
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
//				포워드
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
	    
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}


}
