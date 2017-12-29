package learn.juc;
import java.util.*;

public class TestArrayListAndVectorSync {
	//尝试将ArrayList修改为Vector进行测试
	public static List<Integer> list = new Vector<>();
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new TestThread1();
		thread.start();
		Thread thread2 = new TestThread1();
		thread2.start();
		thread.join();
		thread2.join();
		System.out.println("list Size:" + list.size());
	}
}
class TestThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++){
			TestArrayListAndVectorSync.list.add(1);
		}
	}
}