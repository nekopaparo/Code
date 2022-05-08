package bean.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBean {
	protected void doGet(HttpServletRequest request) {
		request.getSession().invalidate(); //使當前的session無效
		HttpSession session = request.getSession();
		session.setAttribute("name", "value");
		session.getAttribute("name"); //獲取值
		session.removeAttribute("name"); //刪除
		session.setMaxInactiveInterval(60); //指定時間(秒)
	}
}
