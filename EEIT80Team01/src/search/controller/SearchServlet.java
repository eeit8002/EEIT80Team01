package search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import items.model.ItemsBean;
import search.model.SearchService;
@WebServlet("/search/queryAllMembers.do")
public class SearchServlet extends HttpServlet {
	public SearchServlet(){
		searchService = new SearchService();
	}
	private SearchService searchService = null;
	private List<ItemsBean> beans = null;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=" ";
		int option =-100;
		try {
			option = Integer.parseInt(request.getParameter("option"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		 keyword = request.getParameter("keyword");
		if(option==-100){
			beans = searchService.getItemsByKeyword(keyword);
			
			if(beans!=null){
				request.setAttribute("items",beans);
				request.getRequestDispatcher("/search/showItems.jsp").forward(request, response);
			}else{
				request.setAttribute("error","查無商品");
				request.getRequestDispatcher("/search/showItems.jsp").forward(request, response);
			}
		}else{
			beans = searchService.getItemsWithOption(option, keyword);
			if(beans!=null){
				request.setAttribute("items",beans);
				request.getRequestDispatcher("/search/showItems.jsp").forward(request, response);
			}else{
				request.setAttribute("error","查無商品");
				request.getRequestDispatcher("/search/showItems.jsp").forward(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
