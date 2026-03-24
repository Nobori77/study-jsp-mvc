package com.app.product.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.vo.ProductVO;

public class ProductReadController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	    Result result = new Result();
	    ProductDAO productDAO = new ProductDAO();
	    
	    Long id = Long.parseLong(req.getParameter("id"));
	    
	    Optional<ProductVO> product = productDAO.select(id);
	    
	    if(product.isPresent()) {
	        req.setAttribute("product", product.get());
	    }
		
		result.setPath("/read.jsp");
	    result.setRedirect(false);
		return result;
	}

}
