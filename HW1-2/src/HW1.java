import java.util.*;
import java.io.File;
import java.util.Scanner;
/**
 * this class has my file reader where it uses scanner to read the file
 * created that has the names but also has the input that the user wants. 
 * 
 * @author sabrinahussaini
 *
 */
public class HW1 {
	// calls the roster program in this class
	private static RosterProgram roster = new RosterProgram();
	// variable for size
	public static int size; 

	/**
	 * main method that contains two scanners and uses try and catch
	 * @param args
	 */
	public static void main(String[] args) {
		// calls upon the text file
		File file = new File("Assignment1Data.txt");
		// scanner for user input
		Scanner userInput = new Scanner (System.in);
		// a string for line and the user response
		String line;
		String user_response;

		//will print out first to make its max a certain size
		System.out.println("Hello, what would you like the max size to be?");
		// the size depends on what the user inputs
		size = userInput.nextInt();
		// the roster is set to the size 
		roster.setSize(size);



		try {

			Scanner fileInput = new Scanner(file);		
			// if the file input that has all of the names has a next line
			while (fileInput.hasNextLine()) {
				user_response = userInput.nextLine();
				System.out.println("1.Please press a on the keyboard if you would like to add a name to the registered list" );
				System.out.println("2.Please click d on the keyboard if you would like to delete a name from the registered list ");
				System.out.println("____________________________________________");




				// if the user clicks on a then it will add the name 
				if (user_response.equals("a")) {
					line = fileInput.nextLine();
					//System.out.println(line);
					roster.add( line);
					String registered_students = roster.getStudents();
					String waitlist_students = roster.getWaitlistStudents();

					System.out.println("***********");
					System.out.println("the registered students are:" + registered_students);
					System.out.println("***********");


					if(roster.waitlistSize() != 0 ) {


						System.out.println("-----------------");
						System.out.println("the waitlist students are:" + waitlist_students.toString());
						System.out.println("-----------------");

					}




					//print method that prints out whos in class and whos in waitlist 
					// if the user clicks on d then it will delete the name 
				} else if (user_response.equals("d")) {
					line = fileInput.nextLine();
					roster.remove(line);
					String registered_students = roster.getStudents();
					String waitlist_students = roster.getWaitlistStudents();

					// out prints to show the students in each
					System.out.println("***********");
					System.out.println("the registered students are:" + registered_students);
					System.out.println("***********");


					if(roster.waitlistSize() != 0 ) {


						System.out.println("-----------------");
						System.out.println("the waitlist students are:" + waitlist_students.toString());
						System.out.println("-----------------");

					}

				}
			}


			fileInput.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



}
