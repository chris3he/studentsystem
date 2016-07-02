package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDao;
import service.impl.UserDaoImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	private Users user = new Users();

	public Users getModel() {
		return this.user;
	}

	public String login() {
		UsersDao dao = new UserDaoImpl();
		if (dao.userLogin(user)) {
			session.setAttribute("loginUserName", user.getAccount());
			return "login_success";
		} else
			return "login_failure";
	}

	@SkipValidation
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	public void validate() {// Ҫʹ��Ĭ�ϵ�����������Ȼ����쳣
		super.validate();
		if ("".equals(user.getName())) {
			this.addFieldError("userNameError", "�û�������Ϊ��");
		}
		if ("".equals(user.getPassword())) {
			this.addFieldError("userPasswordError", "�û����벻��Ϊ��");
		}
	}
}
