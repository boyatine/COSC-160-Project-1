//An orderedList (of integers or template if you wish) structure
// integers stored in this list must be in increasing order
// a merge sort method should be implemented (to impose above requirement)
// a searching method should be implemented (to facilitate queries)
public class OrderedList {
	private Node head;
	private boolean sortState = false;
	
	public OrderedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}
	
	public Node getMiddle(Node h) {
		 if (h == null) 
			 return h; 
		 Node fastptr = h.getNext(); 
	     Node slowptr = h; 
	          
	     // Move fastptr by two and slow ptr by one 
	     // Finally slowptr will point to middle node 
	     
	     while (fastptr != null) { 
	    	 fastptr = fastptr.getNext(); 
	         if(fastptr!=null) { 
	        	 slowptr = slowptr.getNext(); 
	        	 fastptr=fastptr.getNext(); 
	         } 
	     } 
	     return slowptr; 
	}
	
	public Node sortedMerge(Node a, Node b) { 
		Node result = null; 
        /* Base cases */
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        /* Pick either a or b, and recur */
        if (a.getElem() <= b.getElem())  
        { 
            result = a; 
            result.setNext(sortedMerge(a.getNext(), b));
        }  
        else 
        { 
            result = b; 
            result.setNext(sortedMerge(a, b.getNext()));
        } 
        return result; 
  
    } 
	
	public Node mergeSort(Node h) { 
		 
		if (h == null || h.getNext() == null)
			return h;
		
        // get the middle of the list 
        Node middle = getMiddle(head); 
        Node nextOfMiddle = middle.getNext(); 
  
        // set the next of middle node to null 
        middle.setNext(null); 
       
        // Apply mergeSort on left list 
        Node left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        Node right = mergeSort(nextOfMiddle); 
  
        // Merge the left and right lists 
        Node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    }
	
	public void add(int elem) {
		if (isEmpty())
			head = new Node(elem);
		else {
			Node temp = head.getNext();
			head = new Node(elem);
			head.setNext(temp);
		}
		
		sortState = false;
	}
	
	public boolean searchList(int elem) throws Exception {
		if (isEmpty()) 
			throw new Exception("List is empty, cannot search.");
		
		if(sortState == false) {
			mergeSort(head);
			sortState = true;
		}
		
		boolean foo = false;
		
		Node temp = head;
		
		while(temp != null) {
			if (temp.getElem() == elem) {
				foo = true;
				break;
			}
			temp = temp.getNext();
		}
		
		return foo;
	}
}