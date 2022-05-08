package been.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieBean {
	public void createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("name", "value"); //設定內容
		cookie.setPath("/Independent_Study/HTML"); //指定使用權限
		cookie.setMaxAge(3600); //存活時間
		cookie.setHttpOnly(true); //只限被伺服端存取，無法在用戶端讀取
		cookie.setSecure(true); //指定只能在https中傳遞 
		response.addCookie(cookie); //新增cookie
	}
	public void getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			cookie.getName(); //名稱
			cookie.getValue(); //內容
			cookie.getPath();
			cookie.getMaxAge();
		}
	}
}
