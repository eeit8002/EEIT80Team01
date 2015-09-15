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

import item.category.model.ItemCategoryBean;
import item.category.model.ItemCategoryService;

@WebServlet("/support/manage/itemCategory/itemCategoryUpdate.controller")
public class ItemCategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemCategoryService service;
	@Override
	public void init() throws ServletException {
		service = new ItemCategoryService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String action = request.getParameter("action");
		
		if ("update".equals(action)) { // 來自itemCategoryUpdate.jsp的請求
			
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String itemCategoryStr =  request.getParameter("itemCategory");
				String categoryName = request.getParameter("categoryName");

				if(categoryName == null || categoryName.trim().length()==0){
					errors.put("categoryNameError", "請輸入商品分類名稱");
				}
				if(errors!=null && !errors.isEmpty()){
					RequestDispatcher rd = request.getRequestDispatcher("/support/manage/itemCategory/itemCategoryUpdate.jsp");
					rd.forward(request, response);
					return;
				} 

				//格式轉換
				int itemCategory = 0;
				if(itemCategoryStr!=null && itemCategoryStr.length()!=0){
					itemCategory = Integer.parseInt(itemCategoryStr);
				}
				
				ItemCategoryBean bean = new ItemCategoryBean();
				bean.setItemCategory(itemCategory);
				bean.setCategoryName(categoryName);
				service.update(bean);

				if (!errors.isEmpty()) {
					request.setAttribute("bean", bean); // 含有輸入格式錯誤的bean物件,也存入request
					RequestDispatcher failureView = request
							.getRequestDispatcher("/support/manage/itemCategory/itemCategoryList.jsp");
					failureView.forward(request, response);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				
				ItemCategoryBean update = service.update(bean);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				request.setAttribute("update", update); // 資料庫update成功後,正確的的bean物件,存入request
				String url = "/support/manage/itemCategory/itemCategoryList.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url); // 修改成功後,轉交itemCategoryList.jsp
				successView.forward(request, response);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errors.put("UpdateError", "修改資料失敗");
				RequestDispatcher failureView = request
						.getRequestDispatcher("/support/manage/itemCategory/itemCategoryList.jsp");
				failureView.forward(request, response);
			}
		}
	}
}
