package other;

public class LinkedList {
	
	public Node first = null;
	public Node last = null;
	
	class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	
	public void addFirst(int data){
		Node newNode = new Node(data);
		if(first == null){
			newNode.next = null;
			newNode.prev = null;
			first = newNode;
			last = newNode;
		}else{
			first.prev = newNode;
			newNode.prev = null;
			newNode.next = first;
			first = newNode;
		}
	}
	
	public void addLast(int data){
		Node newNode = new Node(data);
		
		if(last == null){
			newNode.next = null;
			newNode.prev = null;
			first = newNode;
			last = newNode;
		}else{
			last.next = newNode;
			newNode.prev = last;
			newNode.next = null;
			last = newNode;
		}
	}
	
	public void removeFirst(){
		if(first == null){
			return;
		}else{
			first = first.next;
			first.prev = null;
		}
	}
	
	public void removeLast() {
		if(last == null){
			return;
		}
		else{
			last = last.prev;
			last.next = null;
		}
	}

	public void add(int data){
		addLast(data);
	}
	
	public void add(int data, int index){
		int i = 0;
		for(Node curr = first; curr.next!=null; curr = curr.next, i++){
			System.out.println(i + " : " + curr.data);
			if(i == index){
				System.out.println("insert");
				// insert here
				Node newNode = new Node(data);
				newNode.next = curr;
				newNode.prev = curr.prev;
				curr.prev.next = newNode;
				curr.prev = newNode;
			}
		}
	}
	
	public void remove(int index){
		int i = 0;
		for(Node curr = first; curr.next!=null; curr = curr.next, i++){
			if(i == index){
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
			}
		}
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Node curr = first;
		while(curr != null){
			if(curr==last){
				sb.append(curr.data + "]");
			}else{
				sb.append(curr.data + ", ");
			}
			curr = curr.next;
		}
		return sb.toString();
	}

}
