package learn.jvm;

import java.lang.ref.SoftReference;

public class SoftRef {

	public static class User{
		public User (int id, String name ) {
			this.id = id;
			this.name = name;
			byte[] b = new byte[ 1024 * 925 * 700 ];
		}
		public int id;
		public String name;
		
		@Override
		public String toString() {
			return "[id=" + String.valueOf(id)+",name="+name+"]";
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		User u = new User(1, "user1");
		SoftReference<User> userSoftRef = new SoftReference<User>(u);
		u=null;
		
		System.out.println(userSoftRef.get());
		System.gc();
		System.out.println("After GC:");
		System.out.println(userSoftRef.get());

		byte[] b = new byte[ 1024 * 925 * 700 ];
		//关键是需要在此处 加 断点， 给gc一些时间
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t1.join();
		System.out.println("After byte[]");
		System.gc();
		System.gc();
		System.gc();
		System.out.println(userSoftRef.get());
	}
}
