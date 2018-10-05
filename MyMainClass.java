import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//The main method should construct the two list structures, read in the input file populating both lists appropriately, perform the sequential retrievals for each list separately, and finally display the retrieval results to the console. (The main method should also be efficient.) The following steps should be executed by the main method:
//A. Read input file and store data items in both lists.
//B. Record the time needed to complete the sequence of retrievals for the Ordered Array Structure.
//Include the time needed to initially sort the list.
//C. Record the time needed to complete the sequence of retrievals for the MTF Linked List
//Structure.
//D. Display the total retrieval times for both Lists, and declare which was faster.
public class MyMainClass {

	public static void main(String[] args) throws NumberFormatException, Exception {
		OrderedList list1 = new OrderedList();
		MTFList list2 = new MTFList();
		File file = new File("poisson_verylarge.txt");
		BufferedReader reader = null;

		try {
			// ******OrderedList******
			reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    
		    text = reader.readLine(); // Skip the line pertaining to # of elements

		    text = reader.readLine();
		    
		    String[] str = text.trim().split("\\s+"); // Trim according to whitespace
		    
		    long orderedListStart = System.nanoTime();
		    
		    for (int i = 0; i < str.length; i++) {
		    	list1.add(Integer.parseInt(str[i]));
		    }
		    
		    text = reader.readLine(); // Skip the line pertaining to # of queries
		    
		    text = reader.readLine();
		    
		    reader.close();
		    
		    str = text.trim().split("\\s+");
		    
		    for (int i = 0; i < str.length; i++) {
		    	list1.searchList(Integer.parseInt(str[i]));
		    }

		    long orderedListEnd = System.nanoTime();
		    
		    // *****MTFList*****
			reader = new BufferedReader(new FileReader(file));
			
			text = reader.readLine(); // Skip the line pertaining to # of elements

		    text = reader.readLine();
		    
		    str = text.trim().split("\\s+"); // Trim according to whitespace
		    
		    long mtfListStart = System.nanoTime();
		    
		    for (int i = 0; i < str.length; i++) {
		    	list2.add(Integer.parseInt(str[i]));
		    }
		    
		    text = reader.readLine(); // Skip the line pertaining to # of queries
		    
		    text = reader.readLine();
		    
		    reader.close();
		    
		    str = text.trim().split("\\s+");
		    
		    for (int i = 0; i < str.length; i++) {
		    	list2.searchList(Integer.parseInt(str[i]));
		    }

		    long mtfListEnd = System.nanoTime();
			
		    System.out.println("The ordered list took " + (orderedListEnd - orderedListStart) + " nanoseconds "
		    		+ "or " + (orderedListEnd - orderedListStart)/1000000000 + " seconds");
		    System.out.println("The MTF list took " + (mtfListEnd - mtfListStart) + " nanoseconds "
		    		+ "or " + (mtfListEnd - mtfListStart)/1000000000 + " seconds");
		 
		} catch (IOException e) {
		    System.out.println("uh oh");
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
	} 
}
