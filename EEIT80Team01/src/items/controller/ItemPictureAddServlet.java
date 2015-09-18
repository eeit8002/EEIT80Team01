package items.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import items.model.ImagesBean;
import items.model.ItemImagesService;
import items.model.ItemsBean;


@WebServlet("/ItemPictureAddServlet")
public class ItemPictureAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemImagesService service;
    public ItemPictureAddServlet() {
        super();
    }


	@Override
	public void init() throws ServletException {
		service = new ItemImagesService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String picture = request.getParameter("picture");
		String sendButton = request.getParameter("sendButton");
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		if(picture==null || picture.length()==0){
			errors.put("PictureError", "至少上傳一張圖片");
		}
		
//		ImagesBean bean = new ImagesBean();
//		bean.setItemId(1);
//		bean.setItemNo(1);
//		File file = new File("C:/Users/Student/Desktop/01.jpg");
//		long size = file.length();
//		FileInputStream fis = new FileInputStream(file);
//		
//		
//		
//		if(itemsButton!=null &&itemsButton.equals("Insert")){
//			ItemsBean result = service.insert(bean, fis, size);
//			if(result==null){
//				errors.put("action", "商品上架錯誤");
//			}else{
//				request.setAttribute("insert", result);
//			}
//			request.getRequestDispatcher("/items/itemSuccess.jsp").forward(request, response);
//		}
	}

}
