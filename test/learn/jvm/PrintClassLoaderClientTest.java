package learn.jvm;

import org.junit.Test;

public class PrintClassLoaderClientTest {

	@Test
	public void testMain() throws Exception {
		String[] aa = {"a","b"};
		PrintClassLoaderClient.main( null );
	}
}
