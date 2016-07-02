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

public class UserDaoImpl implements UsersDao {// �û��߼�ʵ����

	public void regist(Users u) {

		Session session = HibernateUtil.getSession();
		Transaction ts = null;
		// Session session = HibernateUtil.getSession();
		ts = session.beginTransaction();
		ts.begin();
		session.save(u);
		ts.commit();
	}

	public Boolean existStudent(Students s) {// �û���ѯ�Ƿ���ڸ�ѧ��
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

	public Boolean userLogin(Users user) {// ��֤�û���¼
		Session session = HibernateUtil.getSession();
		Transaction ts = session.getTransaction();

		/*
		 * �˴������ַ���һ����beginTransaction������
		 * beginTransaction���뵽����session.getTransaction����+ts.start();
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
