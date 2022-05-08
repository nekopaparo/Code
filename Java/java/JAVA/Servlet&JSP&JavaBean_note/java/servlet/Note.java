package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Note")
public class Note extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRealPath("."); //網站真實位置
		
		
		//設定UTF-8
		request.setCharacterEncoding("UTF-8"); //接收中文
		response.setCharacterEncoding("UTF-8"); //回應中文
		//同上
		response.setContentType("text/html; charset=UTF-8"); //接收+回應
		
		request.setAttribute("name", "value");
		
		//轉址,沒有return false會繼續執行之後的程式碼可能會出錯，像是這個執行第二個轉址時會有IllegalStateException錯誤
		response.sendRedirect("/test.html");
		request.getRequestDispatcher("/WEB-INF/test.htmlNote").forward(request, response); //傳參數
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
