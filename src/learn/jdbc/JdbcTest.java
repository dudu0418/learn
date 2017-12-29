package learn.jdbc;

import java.sql.Driver;
import java.util.ServiceLoader;

public class JdbcTest {

	public static void main(String[] args) {
		ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
		for (Driver driver : load) {
			System.out.println(driver);
			System.out.println(System.getProperty("jdbc.drivers"));
		}
	}
}
