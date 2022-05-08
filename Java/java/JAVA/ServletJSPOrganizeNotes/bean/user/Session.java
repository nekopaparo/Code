package bean.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {
	private HttpServletRequest request = null;
	private HttpSession session = null;

	Session(HttpServletRequest request) {
		this.session = request.getSession();
		this.request = request;
	}

	public void add(String name, String value) {
		session.setAttribute("name", "value");
	}

	public void get(String name) {
		session.getAttribute(name); // 獲取值
	}

	public void remove(String name) {
		session.removeAttribute("name"); // 刪除
	}

	public void setTime(int second) {
		session.setMaxInactiveInterval(second); // 指定session有效時間(秒)
	}

	public void removeSession() {
		request.getSession().invalidate(); // 使當前的session無效
	}
}
