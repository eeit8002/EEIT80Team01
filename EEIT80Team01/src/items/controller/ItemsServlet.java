package items.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import items.model.ItemsService;

public class ItemsServlet extends HttpServlet {
	private ItemsService service;
	
	@Override
	public void init() throws ServletException {
		service = new ItemsService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
		String itemIdStr = request.getParameter("itemId");
		String seller = request.getParameter("seller");
		String buyer = request.getParameter("buyer");
		String title = request.getParameter("title");
		String startPriceStr = request.getParameter("startPrice");
		String directPriceStr = request.getParameter("directPrice");
		String bidStr = request.getParameter("bid");
		String endTimeStr = request.getParameter("endTime");
		String itemStatus = request.getParameter("itemStatus");
		String threadLockStr = request.getParameter("threadLock");
		
		
		
	}

}
