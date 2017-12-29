package learn.juc;

public class Test001 extends Thread{
	
	public static void main(String[] args) {
		T2 t2 = new T2();
		new Thread(t2,"A" ).start();
		new Thread(t2,"B" ).start();
		new Thread(t2,"C" ).start();
		new Thread(t2,"D" ).start();
		new Thread(t2,"E" ).start();
	}
}

class T2 implements Runnable{

	public int count = 5;

	@Override
	public void run() {
		count--;
		System.out.println("由" + Thread.currentThread().getName()+"计算 count = " + count);
	}
}