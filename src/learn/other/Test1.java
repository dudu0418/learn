package learn.other;

import java.io.IOException;
import java.net.URL;

public class Test1 {

	public static void main(String[] args) throws IOException {
		System.out.println(
				Test1.class.getClassLoader().getResource("Test1.class"));
	}
}
