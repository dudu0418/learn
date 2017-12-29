package learn.jvm;

import java.nio.FloatBuffer;

public class MyParent {
	static {
		System.out.println("parent init");
	}
	public static int v =100;
}

class MyChild extends MyParent{
	static {
		System.out.println("child init");
	}
}

class FinalTest{
	public static final String ff = "hello";
}