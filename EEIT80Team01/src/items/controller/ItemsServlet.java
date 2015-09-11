package items.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import items.model.ItemsBean;
import items.model.ItemsDAOService;
import items.model.ItemsService;
@WebServlet("/items/itemAdd.controller")
public class ItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		HttpSession session = request.getSession();

				
		// 1. 讀取使用者輸入資料
		String title = request.getParameter("title");
		String startPriceStr = request.getParameter("startPrice");
		String directPriceStr = request.getParameter("directPrice");
		String bidStr = request.getParameter("bid");
		String endTimeStr = request.getParameter("endTime");
		String itemStatus = request.getParameter("itemStatus");
		//CRUD按鈕
		String itemsButton = request.getParameter("itemsButton");
		
		// 2. 進行必要的資料轉換
		double startPrice = 0;
		if(startPriceStr!=null && startPriceStr.length()!=0){
			startPrice = Double.parseDouble(startPriceStr);
		}
		double directPrice = 0;
		if(directPriceStr!=null && directPriceStr.length()!=0){
			directPrice = Double.parseDouble(directPriceStr);
		}
		int bid = 0;
		if(bidStr!=null && bidStr.length()!=0){
			bid = Integer.parseInt(bidStr);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date endTime = null;
		if(endTimeStr!=null && endTimeStr.length()!=0){
			try {
				endTime = sdf.parse(endTimeStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		// 3. 檢查使用者輸入資料
		
		
		// 存放錯誤訊息物件
				Map<String, String> errors = new HashMap<String, String>();
				request.setAttribute("error", errors);
				
		if(title==null || title.trim().length()==0){
			errors.put("titleError", "請輸入商品名稱");
		}
		if(startPriceStr==null || startPriceStr.trim().length()==0){
			startPriceStr = "0";
		}
		if(directPriceStr==null || directPriceStr.trim().length()==0){
			errors.put("directPriceError", "請輸入直購價格");
		}
		if(bidStr==null || bidStr.trim().length()==0){
			errors.put("bidError", "加價金額至少1元");
		}
		if(endTimeStr==null || endTimeStr.trim().length()==0){
			errors.put("endTimeError", "請輸入結標時間，格式為YYYY-MM-DD");
		}
		if(itemStatus==null || itemStatus.trim().length()==0){
			itemStatus = "";
		}
		if(errors!=null && !errors.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("/items/itemAdd.jsp");
			rd.forward(request, response);
			return;
		}
		
		//呼叫Model
		ItemsBean bean = new ItemsBean();
		bean.setSeller("aaaaa");	//可以使用session or 呼叫member
		bean.setBuyer("bbbbb");	//暫時輸入一個買家名稱，之後會設定成可以NULL
		bean.setItemCategory(1);
		bean.setTitle(title);
		bean.setStartPrice(startPrice);
		bean.setDirectPrice(directPrice);
		bean.setBid(bid);
		bean.setEndTime(endTime);
		bean.setItemDiscribe("");
		bean.setItemStatus(0);
		bean.setThreadLock(0);	//預設為0
		
		//根據Model執行結果導向View
		if(itemsButton!=null &&itemsButton.equals("Insert")){
			ItemsBean result = service.insert(bean);
			if(result==null){
				errors.put("action", "商品上架錯誤");
			}else{
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher("/items/itemsAdd.jsp").forward(request, response);
		}else if(itemsButton!=null && itemsButton.equals("Update")){
			ItemsBean result = service.update(bean);
			if(result==null){
				errors.put("action", "商品修改錯誤");
			}else{
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher("/items/itemR.jsp").forward(request, response);
		}else if(itemsButton!=null && itemsButton.equals("Delete")){
			boolean result = service.delete(bean);
			if(!result){
				request.setAttribute("delete", 0);
			}else{
				request.setAttribute("delete", 1);
			}
			request.getRequestDispatcher("/items/itemsUp.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

}
