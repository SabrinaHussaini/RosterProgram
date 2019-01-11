/**
 * This class just deals with the doubly linked list node. It creates a getter for previous node and
 * a setter for previous node. 
 * @author sabrina hussaini
 *
 * @param <T> of type T 
 */
public class DoublyLinkedListNode<T> extends LinkedListNode<T>{
	// this is creating a previous node for doubly 
	protected DoublyLinkedListNode<T> previous;


	/**
	 * getter for previous node 
	 * @return
	 */
	public DoublyLinkedListNode<T> getPrev(){
		return previous;

	}
	/**
	 * this method is basically pointing the previous node to the past one
	 * A setter for the prev node
	 */
	public void setPrevNode(DoublyLinkedListNode<T> prevNode) {

		this.previous = prevNode;
	}
}
