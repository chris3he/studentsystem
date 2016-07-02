package util;

import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TableUtil {

	private static SchemaExport se = HibernateUtil.getSchemaExport();
	public static void createTable()
	{
		se.create(true,true);
	}
}
