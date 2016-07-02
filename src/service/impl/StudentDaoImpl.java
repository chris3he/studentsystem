package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Students;
import service.StudentsDao;
import util.HibernateUtil;

public class StudentDaoImpl implements StudentsDao {

	// private static Session session;
	// static {
	// session=HibernateUtil.getSession();
	// }

	public List<Students> query() {
		Session session = HibernateUtil.getSession();
		Transaction ts = session.getTransaction();
		ts.begin();
		String hql = "from Students";
		Query query = session.createQuery(hql);
		List<Students> list = query.list();
		ts.commit();
		return list;
	}

	public void addStudent(Students s) {
		Session session = HibernateUtil.getSession();
		Transaction ts = session.getTransaction();
		ts.begin();
		session.save(s);
		ts.commit();
	}

	public void delStudent(String sid) {
		
	    Session session = HibernateUtil.getSession();
	    Transaction ts = session.getTransaction();
	    ts.begin();
	    String hql = "delete from Students where sid =?";
	    Query query = session.createQuery(hql);
	    query.setString(0, sid);
	    query.executeUpdate();
	    ts.commit();
	}

}
