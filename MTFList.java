//integers are initially stored in an arbitrary order
// a searching method should be implemented (to facilitate queries). this method should re-
//organize the list using the move-to-front strategy.
public class MTFList {
	private Node head;
	private Node prev;

	public MTFList() {
		head = null;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}
	
	public void add(int elem) {
		if (isEmpty())
			head = new Node(elem);
		else {
			Node temp = head.getNext();
			head = new Node(elem);
			head.setNext(temp);
		}
	}
	
	public boolean searchList(int elem) throws Exception {
		if (isEmpty()) 
			throw new Exception("List is empty, cannot search.");
		
		boolean found = Find(elem);
		
		if(found) {
			if(prev == null)
				head = head.getNext();
			else
				prev.setNext(prev.getNext().getNext());
			
			Node temp = head;
			head = new Node(elem);
			head.setNext(temp);
		}

		return found;
	}
	
	// Finds the node before the requested query and save it as 'prev'. If not found, returns false.
	private boolean Find(int elem) {
		if(isEmpty())
			return false;
		if(head.getElem() == elem)
			return true;
		
		prev = head;
		Node temp;
		while((temp = prev.getNext()) != null) {
			if(temp.getElem() == elem)
				return true;
			
			prev = temp;
		}
		
		prev = null;
		return false;
	}
}
