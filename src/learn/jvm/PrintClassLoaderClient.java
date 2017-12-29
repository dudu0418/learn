package learn.jvm;

import java.lang.reflect.Method;

public class PrintClassLoaderClient {

	/*
	 * 测试根类加载器 路径 参数设置, 包内部的路径不需要设置 -Xbootclasspath/a:D:/workspace-oxygen/p0801/bin
	 * 
	 */
	public static void main(String[] args)
			throws Exception {

		Class<?> forName = Class.forName("learn.jvm.Client");
		Object newInstance = forName.newInstance();
		Method method = newInstance.getClass().getMethod("main", String[].class);
		String[] aa = {"123","abc"};
		/*
		 * 错误分析：由于main(String strs[])构造器只有一个String数组的参数所以这时编译器会把字符串数组
		 * 当作一个可变长度参数传给对象strs,而我们取得方法只有一个参数,所以就会出现wrong number of arguments的异常,
		 * 我们只要把字符串数组强制转换为一个Object对象就可以解决这个异常了。
		 */
		method.invoke( newInstance, (Object)aa);

		System.out.println(forName.getClassLoader());
		System.out.println("-----------------------------------");
		ClassLoader classLoader = PrintClassLoaderClient.class.getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader);
			classLoader = classLoader.getParent();
		}
	}
}