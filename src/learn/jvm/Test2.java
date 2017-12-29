package learn.jvm;

public class Test2 {
	private int id;
	public void setId(int id) throws IllegalStateException{
		try {
			this.id = id;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}