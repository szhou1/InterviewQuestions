package other;

/**
 * this is a functional interface - it has only one method
 * @author szhou
 *
 */
interface Executable {
	int execute(int a);
}

interface StringExecutable{
	String execute(String a);
}

class Runner {
	public void run(Executable e){
		System.out.println("Executing code block...");
		e.execute(12);
	}
	public void run(StringExecutable e){
		System.out.println("Executing code block...");
		e.execute("Steve");
	}
}

public class LambdaExp {

	public static void main(String []args){
		Runner runner = new Runner();
		
		/*
		 * traditional method
		 */
		runner.run(new Executable(){
			public int execute(int a){
				System.out.println("hello there: " + a);
				return a;
			}
		});
		
		System.out.println("==============");
		
		/*
		 * new method
		 */
		runner.run( (int a) -> getNumber(a));
		
		System.out.println("==============");
		
		
		runner.run( (String a) -> {
			System.out.println("another thing: " + a);
			return a;
		});
		
		runner.run( (int a) -> 8);
	
	}

	private static int getNumber(int i) {
		return i;
	}
}
