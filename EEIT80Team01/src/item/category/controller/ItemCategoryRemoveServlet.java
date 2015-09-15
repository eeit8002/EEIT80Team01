package item.category.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.category.model.ItemCategoryService;
@WebServlet("/support/manage/itemCategory/itemCategoryList.controller")
public class ItemCategoryRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemCategoryService service;
	@Override
	public void init() throws ServletException {
		service = new ItemCategoryService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String action = request.getParameter("action");
		
		if ("delete".equals(action)) { // 來自itemCategoryList.jsp

			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
	
			try {
				/***************************1.接收請求參數***************************************/
				String itemCategoryStr = request.getParameter("itemCategory");
				
				//格式轉換
				int itemCategory = 0;
				if(itemCategoryStr!=null && itemCategoryStr.length()!=0){
					itemCategory = Integer.parseInt(itemCategoryStr);
				}
				
				/***************************2.開始刪除資料***************************************/
				service.delete(itemCategory);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/support/manage/itemCategory/itemCategoryList.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(request, response);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errors.put("DeleteError", "刪除資料失敗");
				RequestDispatcher failureView = request
						.getRequestDispatcher("/support/manage/itemCategory/itemCategoryList.jsp");
				failureView.forward(request, response);
			}
		}
	}
}