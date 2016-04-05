package other;

public class SingletonTest {

	public static void main(String[] args) {
		try {
			Singleton singleton = Singleton.getInstance();
			System.out.println(singleton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
