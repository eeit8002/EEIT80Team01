package items.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import items.model.ItemsService;

@WebServlet("/items/itemList.controller")
public class ItemRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemsService service;
    public ItemRemoveServlet() {
        super();
    }

	@Override
	public void init() throws ServletException {
		service = new ItemsService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String action = request.getParameter("action");
		
		if("delete".equals(action)){
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			
			try {
				//接收參數
				String deleteButtonStr = request.getParameter("deleteButton");
				//轉換格式
				int deleteButton = 0;
				if(deleteButtonStr!=null && deleteButtonStr.length()!=0){
					deleteButton = Integer.parseInt(deleteButtonStr);
				}
				//呼叫永續層
				service.delete(deleteButton);
				
				//轉交
				String url = "/items/itemList.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			} catch (NumberFormatException e) {
				errors.put("deleteError", "商品刪除失敗");
				request.getRequestDispatcher("/items/itemList.jsp").forward(request, response);
			}
			
		}
		
	}

}
