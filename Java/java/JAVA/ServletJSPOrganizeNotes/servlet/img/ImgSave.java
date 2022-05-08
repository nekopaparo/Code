//from -> GOTOP Servlet & JSP 
package servlet.img;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig  //->getPart用，沒有會IllegalStateException
@WebServlet("/photo")
public class ImgSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final Pattern fileNameRegex = Pattern.compile("filename=\"(.*)\"");
	
	private String path; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		path = request.getServletContext().getRealPath("/HTML/images/product/");
		System.out.println(path);
		
		Part photo = request.getPart("photo");
		String filename = getSubmittedFileName(photo);
		//建立圖檔
		write(photo, filename);
		//轉址
		response.sendRedirect("HTML/CommodityManagement.jsp");
	}
	//檔名
	private String getSubmittedFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		Matcher matcher = fileNameRegex.matcher(header);
		matcher.find();
		
		String filename = matcher.group(1);
		if(filename.contains("\\")) {
			return filename.substring(filename.lastIndexOf("\\") + 1);
		}
		return filename;
	}
	//存檔
	private void write(Part photo, String filename) throws IOException, FileNotFoundException{
		
		try(//try-with-resource
			InputStream in = photo.getInputStream();//->IOException
			OutputStream out = new FileOutputStream(String.format("%s", path + filename)); //-> FileNotFoundException
		){ 
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			System.out.println("圖片建立成功");
		}
	}
}

