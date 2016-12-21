package other;

public abstract class AbstractClass {
	
	int a;
	
	public void someMethod(){
	}
	
	public void method2(){
	}
	
	public void overloadedMethod(){};
	public void overloadedMethod(int x){};
	public void overloadedMethod(String s){};
	
	public abstract boolean overloadedAbstractMethod();
	public abstract boolean overloadedAbstractMethod(int s);
	public abstract boolean overloadedAbstractMethod(String s);
	public abstract boolean overloadedAbstractMethod(String s, char x);
	public abstract boolean overloadedAbstractMethod(char s, String x);
	

}
