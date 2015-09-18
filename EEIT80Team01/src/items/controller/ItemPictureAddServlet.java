package items.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import items.model.ItemImagesService;


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
		
		
	}

}
