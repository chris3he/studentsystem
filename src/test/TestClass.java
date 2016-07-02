package test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import entity.Students;
import util.HibernateUtil;
import util.TableUtil;

public class TestClass {

	// public static void main(String[] args) {
	// Student s=new Student();
	// s.setName("I");
	// s.setId(2013);
	// s.setPhonenum("18482175962");
	// s.setSex("male");
	// s.setClassnum(0703);
	// Session session = HibernateUtil.getSession();
	// Transaction ts = session.getTransaction();
	// ts.begin();
	// session.save(s);
	// }
//	@Test
//	public void testStudent() {

//		Configuration config = new Configuration();
//		config.configure();
//		// 创建服务注册对象
//		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
//				.buildServiceRegistry();
//		// 创建会话工厂对象
//		SessionFactory sf = config.buildSessionFactory(serviceRegistry);
//		Session session = sf.getCurrentSession();
//		Transaction ts = session.beginTransaction();
//		Students s1 = new Students();
//		Students s2 = new Students();
//		s1.setSid("201313070317");
//		s1.setName("何快洛");
////		s1.setId("1");
//		s1.setSex("男");
//		s1.setClassnum("03");
//		s1.setPhonenum("18482175962");
//		s1.setPassword("123");
//		s2.setSid("201313070316");
////		s2.setId("2");
//		s2.setName("王尼玛");
//		s2.setSex("男");
//		s2.setClassnum("03");
//		s2.setPhonenum("184884888941");
//		s2.setPassword("1223456");
//		System.out.println(s1);
//	    session.save(s1);
//	    session.save(s2);
//	    ts.commit();
//		TableUtil.createTable();
//	}
	public static void main(String[] args) {
		TableUtil.createTable();
	}
}
