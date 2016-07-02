package service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Students;
import entity.Users;
import service.UsersDao;
import util.HibernateUtil;

public class UserDaoImpl implements UsersDao {// 用户逻辑实现类

	public void regist(Users u) {

		Session session = HibernateUtil.getSession();
		Transaction ts = null;
		// Session session = HibernateUtil.getSession();
		ts = session.beginTransaction();
		ts.begin();
		session.save(u);
		ts.commit();
	}

	public Boolean existStudent(Students s) {// 用户查询是否存在该学生
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		ts.begin();
		String sid = s.getSid();
		String hql = "from Student where sid=?";
		// Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, sid);
		List<Students> list = query.list();
		ts.commit();
		if (list.size() != 0) {

			return true;
		} else
			return false;
	}

	public List<Students> queryStudent(long sid) {
		Session session = HibernateUtil.getSession();
		String hql = "from Student where sid=?";
		Transaction ts = session.getTransaction();
		ts.begin();
		Query query = session.createQuery(hql);
		query.setParameter(0, sid);
		List<Students> list = query.list();
		ts.commit();
		return list;
	}

	public Boolean userLogin(Users user) {// 验证用户登录
		Session session = HibernateUtil.getSession();
		Transaction ts = session.getTransaction();

		/*
		 * 此处有两种方法一种是beginTransaction（）；
		 * beginTransaction就想到当于session.getTransaction（）+ts.start();
		 */
		ts.begin();
		long account = user.getAccount();
		String password = user.getPassword();
		String hql = "from Users where account=? and password=?";
		Query query = session.createQuery(hql);
		query.setLong(0, account);
		query.setString(1, password);
		List<Users> list = query.list();
		ts.commit();
		if (list.size()!=0) {

			return true;
		} else
			return false;
	}

}
