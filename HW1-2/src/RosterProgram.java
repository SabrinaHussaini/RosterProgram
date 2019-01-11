/**
 * This class was in control of the roster program. It would add, remove, and put the roaster in alphabetical order. 
 * The methods in this class were written to where the add method would take in where a specific node would be put in place. 
 * Meaning if it was in the beginning, the middle, or the end of a doubly linked list. The sort method had a purpose 
 * of correctly sorting the list but making sure it did not sort a list if it was in the waitlist students list. 
 * The remove method would correctly remove a node when the user would tell it to. And it would make sure to 
 * remove a node but add the waitlist node into the registered list if there was room. 
 * @author sabrina hussaini
 * @date 21 October 2018
 *
 */
public class RosterProgram {
	// For the registered students 
	public  DoublyLinkedList<String> registeredStudents = new DoublyLinkedList<String>();
	// for the waitlist students
	public DoublyLinkedList<String> waitlistStudents = new DoublyLinkedList<String>();
	// an int for the size
	protected int size;



	/**
	 * this is the constructor for students and waitlist which just takes in both instances
	 */
	public RosterProgram () {
		registeredStudents = new DoublyLinkedList<String>();
		waitlistStudents = new DoublyLinkedList<String>();

	}
	/**
	 * designed for a getter for students added, which is the registered students list
	 * @return return the students name
	 */
	public String getStudents() {
		return registeredStudents.toString();

	}
	/**
	 * Created to be a getter for the waitlist students
	 * @return the waitlist names in a list
	 */
	public String getWaitlistStudents() {
		return waitlistStudents.toString();
	}
	/**
	 * sets the size
	 * @param is in an int 
	 */
	public void setSize(int i) {
		size = i;

	}
	/**
	 * method for waitlist size so it only shows when needed
	 * @return
	 */
	public int waitlistSize() {
		int size = waitlistStudents.size();
		return size;
	}

	/**
	 * This method will add students name to the lists. It will add in the
	 *  beginning of the list, the middle, or the end of the list. 
	 * @param name which is the name it will add
	 */
	public void add (String name) {
		// insert students at front of the list if head is null and insert student next to head 
		if ( registeredStudents.size() < size) {
			// if the registered list is empty then add a name to the students list
			if (registeredStudents.getFirstNode() == null) {
				registeredStudents.insertFirst(name);




			} else

			{

				// will sort the lists by calling upon the sort roster method
				sortRoster(registeredStudents,name);


			}
		}
		// this will add a name to the waitlist students list 
		else {


			waitlistStudents.insertLast(name);



		}
	}




	/**
	 * this method puts the registered students list in order by comparing the 
	 * nodes and moving it in its specific place. But makes sure to not
	 * sort the waitlist students list as it should be put in the order it comes in. 
	 * @param list a string used to determine its list
	 * @param name string used for the name 
	 */
	public void sortRoster(DoublyLinkedList<String> list, String name) {
		// creates a new node
		DoublyLinkedListNode<String> newNode = new DoublyLinkedListNode<String>();
		// sets the name to the new node
		newNode.setData(name);
		// keep track of whether or not it is sorted
		Object sorted = null;

		// compares a name that is in the beginning 
		if (name.compareTo(list.getFirst()) < 0) {
			// inserts the new node into the list
			list.insertFirstNode(newNode);
			return;

		}
		// this is to see if the name is at the end of the list, so if name is greater than zero
		else if (name.compareTo(list.getLast()) > 0) {
			// inserts the name to the last part of the list
			list.insertLast(name);


			// if the list is not sorted then it compares
		} else {
			// will set a current node to the lists header
			DoublyLinkedListNode<String> currentNode = list.getFirstNode();
			while (sorted == null ) {

				// if the name goes after a temp node or before the next node
				if (name.compareTo(currentNode.getData()) > 0) {
					if (name.compareTo(currentNode.getNext().getData()) < 0) {
						// the temp node and name is inserted after in the list
						list.insertAfter(currentNode, name);


						break;
					}

					// compares two names to check if it is in the list already or not and if it is then it will send a helpful message
				}   if(name.compareTo(currentNode.getData()) == 0) {

					break;
				}
				// sets current node next to the current node  
				currentNode = (DoublyLinkedListNode<String>) currentNode.getNext(); 
			}
		}
	}



	/**
	 * this method removes the node by checking if whether or not it exists and where it is in the list and how to
	 * remove it from the list and where it should be placed next. 
	 * @param the name taken in
	 */
	public void remove (String name) {
		DoublyLinkedListNode<String> temp = registeredStudents.getFirstNode();
		// if the name exists = true
		boolean real = false;
		// if it is a real name
		boolean validName = false;


		// check if the name is in the enrolled list
		while (real == false) {
			if (temp.getData().equals(name)) {
				// if a node is the last node then delete it last
				if(temp == registeredStudents.getLastNode()) {
					registeredStudents.deleteLast();
					//real = true;
				}
				// else the list will delete its previous node
				else {
					registeredStudents.delete((DoublyLinkedListNode<String>) temp.getNext());
				}
				// while the size is greater than the size in the list 
				while (registeredStudents.size() < size ) {

					// if the first node on the waitlist is not null, meaning something exists there
					if (waitlistStudents.getFirstNode() != null) {
						// then it should add the name 
						add(waitlistStudents.getFirstNode().getData().toString());
						// the waitlist should delete it first
						waitlistStudents.deleteFirst();
					} break;
				}

				// if the temp node next node is empty 
			}	if (temp.getNext() == null) 
			{
				break;
				// set the nodes next to the temp node
			} temp = (DoublyLinkedListNode<String>) temp.getNext();

			// if the waitlist students first node is full
		}	if (waitlistStudents.getFirstNode() != null) 
		{
			// if the name does exist then the temp node info will equal to the name added
			while(validName == false) 
			{
				// if the temp name equals to the name being removed
				if (temp.getData().equals(name)) {
					if(temp == waitlistStudents.getLastNode()) {
						waitlistStudents.deleteLast();
						return;
					} else {
						waitlistStudents.delete(temp);

						validName = true;
						break;

					}
					// if the temp next node is empty then just leave it
				} if (temp.getNext() == null) {
					break;

				}
				// set the temp node next to the temp 
				temp = (DoublyLinkedListNode<String>) temp.getNext();

			}}

	}
}
