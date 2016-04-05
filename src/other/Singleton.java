package other;

public class Singleton {

	private static Singleton instance;
	
	private Singleton(){}
	
	public static Singleton getInstance() throws InterruptedException{
		Thread.sleep(2000);
		
		if(instance == null){
			synchronized (Singleton.class){
				instance = new Singleton();
			}
		}
		return instance;
	}
	
}
