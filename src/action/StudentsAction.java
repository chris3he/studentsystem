package action;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ModelDriven;

import entity.Students;
import service.StudentsDao;
import service.impl.StudentDaoImpl;
import util.HibernateUtil;

public class StudentsAction extends SuperAction implements ModelDriven<Students> {

	private Students student = new Students();

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Students getModel() {
		if (student != null) {
			return student;

		} else {
			student = new Students();
			return student;
		}
	}

	public String query() {
		StudentsDao sdi = new StudentDaoImpl();
		List<Students> list = sdi.query();
		session.setAttribute("students_list", list);
		return "Students_query_success";
	}

	public String add() {

		StudentsDao sd = new StudentDaoImpl();
		sd.addStudent(student);
		return "Students_add_success";
	}
    public String delete()
    {
    	String sid = request.getParameter("sid");
    	StudentsDao sd = new StudentDaoImpl();
        sd.delStudent(sid);
    	return "Students_query_success";
    }
}
