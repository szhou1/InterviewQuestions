package other;

//import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

	@Test
	public void test(){
		LinkedList ll = new LinkedList();
		
		ll.add(10);
		assertEquals("[10]", ll.toString());
		ll.add(13);
		assertEquals("[10, 13]", ll.toString());
		
		System.out.println(ll);
		
		ll.addFirst(1);
		assertEquals("[1, 10, 13]", ll.toString());

		System.out.println(ll);
		ll.addLast(99);
		assertEquals("[1, 10, 13, 99]", ll.toString());
		ll.addLast(100);
		assertEquals("[1, 10, 13, 99, 100]", ll.toString());
		ll.add(55);
		assertEquals("[1, 10, 13, 99, 100, 55]", ll.toString());

		System.out.println(ll);
		
		ll.removeFirst();
		assertEquals("[10, 13, 99, 100, 55]", ll.toString());
		ll.removeLast();
		assertEquals("[10, 13, 99, 100]", ll.toString());		
		ll.add(22, 2);
		assertEquals("[10, 13, 22, 99, 100]", ll.toString());
		ll.remove(2);
		assertEquals("[10, 13, 99, 100]", ll.toString());
		
		System.out.println(ll);

	}

}
