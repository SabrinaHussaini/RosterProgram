/**
 * This class has a purpose of using a linked list of type T to create 
 * a double linked list of type T. The methods in this class will properly 
 * delete, and add at specific places in the nodes. It also 
 * has all of the setters and getters which are created to help the program run. 
 * It uses head and tail to set nodes in proper places. 
 * 
 * @author sabrina hussaini
 *
 * @param <T> of type linked list T
 */
public class DoublyLinkedList<T>  extends LinkedList<T>{
	// variables for the trailor and header 
	public DoublyLinkedListNode<T> trailor;
	public DoublyLinkedListNode<T> header;


	/**
	 * this is the constructor for the doubly linked list which just sets the 
	 * nodes head and tail to null 
	 */
	public DoublyLinkedList() {
		trailor = null;
		header = null;
	}

	/**
	 * This is a getter for the first node
	 */
	public DoublyLinkedListNode<T> getFirstNode(){
		// check if the header is null and if it is then return null meaning nothing is before it
		if (header == null) {
			return null;
			// else return the node pointing to the header
		} else 
		{ 
			return (DoublyLinkedListNode<T>) this.header;
		}
	}

	/**
	 * a getter for the first which returns the datas first node
	 */
	public T getFirst() {
		// if the header is not full 
		if (header!=null) {
			// get the data in the first element, the header
			return header.getData();
		}
		// else just return as null
		else {
			return null;
		}

	}
	/**
	 * a getter for getting the last element in a list
	 * @return the temp nodes data
	 */
	public T getLast() {
		DoublyLinkedListNode<T> temp = header;
		// while the temp node next is not empty, set its temp to temp's next
		while (temp.getNext() != null ) {
			temp = (DoublyLinkedListNode<T>) temp.getNext();
		} 
		// return the temps data
		return temp.getData();

	}
	/**
	 * a getter for trailor. 
	 * @return the current node or return nothing
	 */
	public DoublyLinkedListNode<T> getTrailor(){
		DoublyLinkedListNode<T> currentNode = header;
		//if list is not empty 
		if(header !=null){
			while(currentNode.getNext()!=null){
				currentNode = (DoublyLinkedListNode<T>) currentNode.getNext();	
			}
			return currentNode;
		}
		// else return nothing
		else 
			return null;
	}
	/**
	 * this method is for delete previous of a node. 
	 * @param currentNode of type doubly linked list node <T>
	 */
	public void delete(DoublyLinkedListNode<T> currentNode) {
		// if both are set to null
		if (currentNode.getPrev() == null && currentNode.getNext() == null) {


		}
		// set the current node previous to header
		else if (currentNode.getPrev() == header) {
			header = currentNode;
			((DoublyLinkedListNode<T>) header).setPrevNode(null);	
		} 
		// else sets its prev, prev to current node
		else 
		{
			currentNode.setPrevNode(currentNode.getPrev().getPrev());

			currentNode.getPrev().setNext(currentNode);
			return;

		}
	}	

	/**
	 * a getter for the last node in a list. 
	 */
	public DoublyLinkedListNode<T> getLastNode(){
		// if the header is null return nothing
		if (header == null ) {
			return null;
			// else return the header
		} else 
		{
			DoublyLinkedListNode<T> temp =  header;
			while (temp.getNext() != null) {
				temp = (DoublyLinkedListNode<T>) temp.getNext();

			}

			return temp;
		}



	}
	/**
	 * inserting first element in a list. 
	 * @param data of type T
	 */
	public void insertFirst(T data) {
		// create a new node
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
		// set the data of the new node
		newNode.setData(data);

		// if the header is null then sets a new node as the head and a trailor as its node 
		if (header == null) {
			header = newNode;
			trailor = newNode;
			header.setNext(null);

		}
		// else insert the new node
		else {
			insertFirstNode(newNode);

		}

	}
	/**
	 * inserting the first node in a doubly linked list
	 * @param node of type doubly linked list node<T> 
	 */
	public void insertFirstNode (DoublyLinkedListNode<T> node) {
		header.setPrevNode(node);
		node.setNext(header);
		header = node;
	}
	/**
	 * a getter for the node
	 * @param index of type int
	 * @return a nodes data
	 */
	public T getNode(int index){
		DoublyLinkedListNode<T> temp = header;
		while (index > 0) {
			temp = (DoublyLinkedListNode<T>) temp.getNext();
			index--;

		}	
		return temp.getData();

	}
	/**
	 * inserting after an element in a list.
	 * @param currentNode which is name of a node
	 * @param data which is of type T
	 */
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data ) {
		// if the current node next is null then sets its data and the current node set next is the temp
		if (currentNode.getNext() == null) {
			DoublyLinkedListNode<T> temp = new DoublyLinkedListNode<T>();
			temp.setData(data);
			currentNode.setNext(temp);


			temp.setPrevNode(currentNode);
		}
		// else set the temp to its data 
		else {
			DoublyLinkedListNode<T> temp = new DoublyLinkedListNode<T>();
			temp.setData(data);

			((DoublyLinkedListNode<T>) currentNode.getNext()).setPrevNode(temp);


			temp.setNext(currentNode.getNext());
			currentNode.setNext(temp);

			temp.setPrevNode(currentNode);

		}
	}


	/**
	 * inserting at the end of an element in a list. 
	 * @param data type T
	 */
	public void insertLast(T data) {

		// create a temp node
		// if the header is not null
		if (header == null) {
			insertFirst(data);


		} else {
			// else add it after a node
			DoublyLinkedListNode<T> temps = new DoublyLinkedListNode<T>();
			temps.setData(data);
			insertAfter(getLastNode(), data);
		}

	}
	/**
	 * deleting the first element in a list. 
	 */
	public void deleteFirst() {
		// have to check if the node is null
		if (header != null) {
			if (header.getNext() != null) {
				header = (DoublyLinkedListNode<T>) header.getNext();
				header.setPrevNode(null);

			}
			else {
				header = null;
			}
		}

	}
	/**
	 * deleting the last element in the list
	 */
	public void deleteLast() {

		// if the element after the header is null then set the header to null
		if (header.getNext() == null) {
			header = null;
			return;
		}
		else {
			trailor = getTrailor();
			trailor.getPrev().setNext(null);
			trailor = trailor.getPrev();
		}
	}
	/**
	 * this is the to string method that shows how the list will be shown.
	 */
	public String toString() {
		// creating a temporary node that is set to header
		DoublyLinkedListNode<T> temp = header;
		// using string to show how the list is supposed to print
		String printableList  = "";
		// if the headerer is not null 
		if (temp != null){
			// while the header next is not null 
			while(temp.getNext() != null){
				// make the headerer equal to the next headerers
				printableList += temp.getData().toString() + "-> ";
				temp = (DoublyLinkedListNode<T>) temp.getNext();

			}
			printableList += temp.getData().toString();
		}

		return printableList;
	}
	/**
	 * this method is checking for its size to see what it will be at all times.
	 * 
	 */
	public int size() {
		// a counter initialized to zero
		int count = 0;
		// temp node is the headerer; used as a pointer kind of 
		DoublyLinkedListNode<T> currentNode =  header;

		//loop through the list and increment number of nodes
		while(currentNode != null){
			count = count + 1;
			currentNode = (DoublyLinkedListNode<T>) currentNode.getNext();
		}
		return count;
	}
}
