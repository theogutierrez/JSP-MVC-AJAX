package model;

import javax.sql.DataSource;

/**
 *
 * @author rbastide
 */
public class DataSourceFactory {

	public enum DriverType {
		embedded, server
	};

	public static DataSource getDataSource(DriverType type) {
		DataSource result;

		switch (type) {
			case server:
				org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
				ds.setDatabaseName("sample");
				ds.setUser("app");
				ds.setPassword("app");
				// The host on which Network Server is running
				ds.setServerName("localhost");
				// port on which Network Server is listening
				ds.setPortNumber(1527);
				result = ds;
				break;
			default:
				org.apache.derby.jdbc.EmbeddedDataSource es = new org.apache.derby.jdbc.EmbeddedDataSource();
				es.setCreateDatabase("create");
				es.setDatabaseName("embedded_sample3");
				result = es;
		}

		return result;
	}

}
