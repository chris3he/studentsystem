package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {

//	private static final ThreadLocal<Session> s = new ThreadLocal<Session>();
	private static SessionFactory sf;
	private static SchemaExport export;
    private static Session session;
	static {
		Configuration config = new Configuration();
		config.configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// 创建会话工厂对象
		sf = config.buildSessionFactory(serviceRegistry);
		export = new SchemaExport(config);
		
	}

	public static Session getSession() {

		session =sf.getCurrentSession();
		return session;
	}
	public static SchemaExport getSchemaExport()
	{
		return export;
	}

}
