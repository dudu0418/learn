package learn.jvm;

public class CanReliveObj {

	public static CanReliveObj obj;
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("----in finally----CanReliveObj finalize called");
		obj = this;
	}
	
	@Override
	public String toString() {
		return "I am CanReliveObj";
	}
	
	/**
	 * 因为对象的finally方法在回收时只执行一次， 所以 在第二次执行做垃圾回收时不能再次执行 finally方法
	 * 
	 * 强烈建议 try-catch-finally 语句中进行资源的释放
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("开始测试");
		
		obj = new CanReliveObj();
		
		obj = null;
		System.gc();
		Thread.sleep(1000);
		if( obj == null)
		{
			System.out.println("obj is null");
		}
		else {
			System.out.println("obj 可用");
		}
		
		System.out.println("第二次GC");
		obj = null;
		System.gc();
		Thread.sleep(1000);
		if(obj == null) {
			System.out.println("obj is null");
		}
		else {
			System.out.println("obj 可用");
		}
	}
}