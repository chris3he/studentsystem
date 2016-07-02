package action;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class SuperAction extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, ServletContextAware {
//所有要用到request，response，context的Action可以继承此父类。
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext context;
	protected HttpSession session;

	public void setServletContext(ServletContext context) {
		this.context = context;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		this.session = request.getSession();

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

}

