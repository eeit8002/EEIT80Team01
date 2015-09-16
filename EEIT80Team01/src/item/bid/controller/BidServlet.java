package item.bid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import item.bid.model.BidLogBean;
import item.bid.model.BidLogDAOService;
import item.bid.model.BidService;
import member.model.MemberBean;

public class BidServlet extends HttpServlet {
	private BidService bidService = null;
	private BidLogBean bidLogBean = null;
	private BidLogDAOService bidLogDaoService = null;
	private int itemId = 0;
	private double bidPrice = 0;
	private java.sql.Date bidTime = null;
	private String buyer = null;
	public BidServlet(){
		bidService = new BidService();
		bidLogDaoService = new BidLogDAOService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		MemberBean memberBean = (MemberBean)session.getAttribute("LoginOK");
		buyer = memberBean.getUserName();
		itemId = Integer.parseInt(request.getParameter("itemId"));
		bidPrice = Double.parseDouble(request.getParameter("bidPrice"));
		bidTime = new java.sql.Date(new java.util.Date().getTime());
		
		if(action.equalsIgnoreCase("direct")){
			if(bidService.changeItemStatus(itemId)){
				bidLogBean = bidService.insertDirectBuyer(itemId,bidTime,buyer);
				if(bidLogBean!=null){
					request.setAttribute("message","購買成功");
					request.getRequestDispatcher("${pageContext.request.contextPath}/product/product.jsp").forward(request, response);
				}
			}
			request.setAttribute("error","已售出!");
			request.getRequestDispatcher("${pageContext.request.contextPath}/product/product.jsp").forward(request, response);
		}
		
		if(action.equalsIgnoreCase("bid")){
			
			if(bidService.checkStatus(itemId)){
				bidService.toggleThread(itemId);
				if(bidPrice>=1 && bidService.validateBidPrice(bidPrice, itemId) && 
						bidService.validateBidTime(bidTime, itemId)){
					bidLogBean = new BidLogBean();
					bidLogBean.setItemId(itemId);
					bidLogBean.setBuyer(buyer);
					bidLogBean.setBidPrice(bidPrice);
					bidLogBean.setBidTime(bidTime);
					BidLogBean result = bidService.compareTopPrice(bidLogBean);
					bidService.toggleThread(itemId);
					if(result!=null){
						request.setAttribute("bean",result);
						request.setAttribute("message","下標成功");
						request.getRequestDispatcher("${pageContext.request.contextPath}/product/product.jsp").forward(request,response);
					}else{
						request.setAttribute("error","錯誤!出價請高於最高下標價");
						request.getRequestDispatcher("${pageContext.request.contextPath}/product/product.jsp").forward(request,response);
					}
				} else{
					request.setAttribute("error","下標失敗!");
					request.getRequestDispatcher("${pageContext.request.contextPath}/product/product.jsp").forward(request,response);
				}
				
			}
			request.setAttribute("error","錯誤!其他會員下標中或拍賣已結束");
			request.getRequestDispatcher("${pageContext.request.contextPath}/product/product.jsp").forward(request,response);
			
		}
		
		
		
		
		
	}

}
