package learn.jvm;

import java.sql.Timestamp;
import java.util.Date;

public class Client {

	//  -XX:+TraceClassLoading
	public static void main( String[] aa ) {
		
		System.err.println(new Date());
		System.out.println(new Timestamp(new Date().getTime()));
		
		System.out.println(MyChild.v);
		System.out.println(FinalTest.ff);
		System.out.println(aa[0]+ aa[1]);
	}
}