package items.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import items.model.ImagesBean;
import items.model.ItemImagesService;


@WebServlet("/items/itemShowImage.controller")
public class ItemShowImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ItemShowImageServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImagesBean bean = null;
		InputStream is = null;
		OutputStream os = response.getOutputStream();
		String action = request.getParameter("action");
		
		if("show".equals(action)){	
			//存錯誤資訊
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			
			try {
				//接收資料
				String no = request.getParameter("imageNo");
				//驗證資料
				if(no.equals("")){
					errors.put("ImageError", "zzzzz");
				}
				if (is == null) {
					is = getServletContext().getResourceAsStream(
							"/imgs/NoImage.jpg");
				}
				
				if(!errors.isEmpty()){	
					request.getRequestDispatcher("/items/itemShowImage.jsp").forward(request, response);
					return;	//程式中斷
				}
				
				//轉換
				if(no!=null){
					int imageNo = Integer.parseInt(no);		
					ItemImagesService service = new ItemImagesService();
					
					bean = service.selectOneImage(imageNo);
							
					try {
						is= bean.getImage().getBinaryStream();
					} catch (SQLException e) {			
					}
				}		

				//寫出圖片
				int count = 0;
				byte[] bytes = new byte[1024];
				while ((count = is.read(bytes)) != -1) {
					os.write(bytes, 0, count);
				}
				os.flush();
				os.close();

				//轉交
				request.getRequestDispatcher("/items/itemShowImageSuccess.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		 
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
