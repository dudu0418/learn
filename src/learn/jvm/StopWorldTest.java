package learn.jvm;

import java.util.HashMap;
import java.util.UUID;

public class StopWorldTest {

	public static class MyThread extends Thread{
		HashMap<UUID, byte[]> map = new HashMap<UUID, byte[]>();
		@Override
		public void run() {
			try {
				while(true) {
					if(map.size()*512/1024/1024>=900) {
						map.clear();
						System.out.println("clean map");
					}
					byte[] b1;
					for (int i = 0; i < 100; i++) {
						b1 = new byte[512];
						map.put(UUID.randomUUID(), b1);
					}
					Thread.sleep(1);
				}
			} catch (Exception e) {
			}
		}
	}
	
	public static class PrintThread extends Thread{
		public static final long starttime = System.currentTimeMillis();
		@Override
		public void run() {
			try {
				while(true) {
					long t = System.currentTimeMillis() - starttime;
					System.out.println(t/1000 + "." + t% 1000);
					Thread.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		PrintThread printThread = new PrintThread();
		myThread.start();
		printThread.start();
	}
}
