/**
 * Node class for singly linked lists.
 * @author Boya Lee
 *
 */

public class Node {
	
	private int elem;
	private Node next;
	
	public Node(int elem) {
		this.elem = elem;
		next = null;
	}
	
	public void setElem(int elem) {
		this.elem = elem;
	}
	
	public int getElem() {
		return this.elem;
	}
	
	public void setNext( Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return this.next;
	}
}