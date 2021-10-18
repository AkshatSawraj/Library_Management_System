/**
 * BookCompany - Application program that:
 *        Create an empty ArrayList and read the data from a text file and sorted as libraries to look more efficient. 
 *        Allow both employees and patrons to checkout, find, and list books.
 *        A data file containing a sample list of books is provided by four different types of books:
 *            -Children's book  -Cookbooks book  -Paperbacks Book  -Periodicals Book.
 *        Each book is uniquely identified using an ISBN and the the information for each type of book is
 *        described in the formatting section. 
 *        
 * @author (Akshat Sawaraj )
 * @version ( February 9th, 2021 )
 */
package sait.bms.application;

import java.io.*; // Standard import for all classes in the java.io package. 
import java.util.*; // Standard import for the Scanner class.
import sait.bms.managers.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

public class BookCompany{
	public static void main(String[] args) throws IOException{
		// Create a Scanner object attached to the keyboard
        Scanner input = new Scanner (System.in);
        int selection = 0;
        ArrayList<Object> ArrayBook = new ArrayList<Object>();  // Create single ArrayList to hold the books.
        addBooks(ArrayBook);  // Add the books to the ArrayList.
        selection = print(input);  // Assign the use input from keyboard to selection.

        while (selection != 5) 
        {
            // clear the screen
            System.out.printf ("\f");
            switch (selection) {
                case 1:  // Checkout a book.
                	System.out.print("Enter ISBN of book: ");
                    long ISBN = input.nextLong();  // Read the input from the user and assigned to the ISBN.
                    checkOutBook(ArrayBook,ISBN);  // Method CheckOutBook will called with two arguments.
                    break;
                case 2:  // Find books by title.
                	System.out.printf ("Enter title to search for: ");
                	String titleToSearch = input.nextLine();  // Read the input from the user and assigned to titleToSearch.
					findBooks(ArrayBook, titleToSearch);      // Method findBooks will called with two arguments.
                    break;
                case 3:  // Display books of a specific type.
                	displayByType(ArrayBook);  // Method displayByType will called with one arguments.
                    break;
                case 4:  // Produce a list of random books.
                	System.out.printf ("Enter number of books: ");
                	int numberOfBooks = input.nextInt();      // Read the input from the user and assigned to numberOfBooks.
					randomBook(ArrayBook, numberOfBooks);     // Method randomBook will called with two arguments.
                    break;
                case 5:  // Save and exit the program.
                	write(ArrayBook);   // Method write will called with one arguments.
                	break;
                default: // print out invalid input.
                    System.out.printf ("Invalid option%n");
            }
            System.out.printf ("Press Enter to continue...\n");
            input.nextLine();  // Read input from the user.
            selection = print(input);  // Assign the use input from keyboard to selection.
        }
    }
	
	/**
	 * addBooks - Method that parses the supplied "books.txt" file into a single ArrayList.
	 *            The ArrayList will be able to contain all book types ( children's books,
	 *            Cookbooks, Paperbacks, and Periodicals ). Will use the last digit of ISBN
	 *            to determine what a valid type of books needs to be created.  
	 * @param ArrayBook an ArrayList of Book.
	 * @throws FileNotFoundException Thrown when the specified pathname does not exist.
	 */
	public static void addBooks(ArrayList<Object> ArrayBook) throws FileNotFoundException {
   		File file = new File(System.getProperty("user.dir")+"/res/books.txt"); // Read the file from the pathname.
        Scanner inFile = new Scanner(file).useDelimiter (";");  // Scanner the file while using the delimiter.
        while(inFile.hasNextLine()){
            long ISBN = inFile.nextLong(); // Assign the ISBN while reading the file.
            long lastDigit = ISBN%10;      // Assign the last digit from the ISBN variable.
       
            if(lastDigit == 0 || lastDigit == 1)  // Check the lastDigit if it is 0 or 1, specified to the Children book.
            { 
                String call_Number = inFile.next();         // Hold the call_Number for the book. 
                int available = inFile.nextInt();           // Hold the available number of the book.
                int total = inFile.nextInt();               // Hold the total number of the book.
                String title = inFile.next();               // Hold the title name for the book.
                String authors = inFile.next();             // Hold the authors name for the book. 
                char format = inFile.nextLine().charAt(1);  // Hold the format for the book.
                // creating a new Children constructor and add the data to the ArrayList.
                ArrayBook.add(new ChildrensBook(ISBN,call_Number,available,total,title,format,authors));
                
                }
                else if(lastDigit == 2 || lastDigit == 3) { // If it's 2 or 3, specified to the Cookbook.
                	// creating a new Cookbooks constructor and add the data to the ArrayList.
                	ArrayBook.add(new Cookbook(ISBN,inFile.next(),inFile.nextInt(),inFile.nextInt(),inFile.next(),inFile.next(),(char)inFile.nextLine().charAt(1)));
                }
                else if(lastDigit >= 4 && lastDigit <= 7) { // If it's 4,5,6, or 7 specified to the Paperbook.
                	ArrayBook.add(new Paperback(ISBN,inFile.next(),inFile.nextInt(),inFile.nextInt(),inFile.next(),inFile.next(),inFile.nextInt(),(char)inFile.nextLine().charAt(1)));
                }
                else if(lastDigit == 8 || lastDigit == 9) { // Otherwise will be 8 or 9, specified to the Predicals book.
                	ArrayBook.add(new Periodical(ISBN,inFile.next(),inFile.nextInt(),inFile.nextInt(),inFile.next(),(char)(inFile.nextLine().charAt(1))));
                }
        }
        inFile.close();  // Close the file after you read all the data.
    }
   	
	/**
	 * checkOutBook - Method allows a patron to checkout a book using its ISBN. If the book is unavailable,
	 *                the user will be informed and the program will return back to the main menu. Otherwise,
	 *                if the book is available, the available count will be decremented and the book information will.
	 * @param ArrayBook an ArrayList of Book.
	 * @param ISBN the unique number of book.
	 */
	public static void checkOutBook(ArrayList<Object> ArrayBook, long ISBN) {
		Object found = findISBN(ArrayBook,ISBN);   // Called the method findISBN and assigned the value to the found.
        if(found == null) {                        // check if it's the value of found null or not.
        	System.out.println("Book not found!");
        }
        else {
        	if(((Book) found).getAvailable()>0)    // if it's not null will check the availability for the Book.
        	{
        		// Decrement the availability number for the book.
        		((Book) found).setAvailable(((Book) found).getAvailable()-1);
        		System.out.println("The book \""+((Book) found).getTitle()+"\" has been checked out.");
        		System.out.println("It can be located using a call number: "+((Book) found).getNumber());
        	}
        	else {
        		// Otherwise, the book is not available.
        		System.out.println("Book not available at the moment!");
        	}
        }
	}
	/** findISBN - given an Arraylist of books and a specific ISBN number. Find if the book with the ISBN 
     *             number exists and if so, return that book; otherwise, null.
     * @param ArrayBook an Arraylist of Books
     * @param ISBN the unique number of book
     * @return returns the Book object if found; otherwise, null.
     **/
    public static Object findISBN (ArrayList<Object> ArrayBook, long ISBN) {
    	for(Object book : ArrayBook) {
    		if(ISBN==((Book) book).getISBN()) {
    			return book;
    		}
    	}
    	return null;
    }
    
	/**
	 * findBooks - performs a case-insensitive search of books that containing the inputed title, and display them.
	 * @param ArrayBook - ArrayList of Book.
	 * @param findBooks - holding the input from the user to search by title.
	 */
	 public static void findBooks (ArrayList<Object> ArrayBook, String findBooks) {  
		 for (int i = 0; i < ArrayBook.size(); i++) 
		 {
			 Object bookFound = ArrayBook.get(i);  // Assign the data from the arraylist to the bookFound. 
			 // convert the user input to lowerCase and compared with the books title.
			 if (((Book) bookFound).getTitle().toLowerCase().contains(findBooks.toLowerCase())) 
			 {
				 System.out.printf("%nMatching books:%n");
				 System.out.println(bookFound);  // print the book information details.
		     }
		 }
	 }
	 
	 /**
	  * displayByType - Method allows a patron to view a list of books with a specific type.
	  *                 The user will also enter a format, diet, genre, or frequency 
	  *                 (depending on the type of book) and the book list will display.  
	  * @param ArrayBook - ArrayList of Book.
	  */
	 public static void displayByType(ArrayList<Object> ArrayBook) {
	    	Scanner input = new Scanner (System.in);                  // Create a Scanner import to read data from user. 
	    	ArrayList<Object> searchedArray = new ArrayList<>(0);     // create a new empty ArrayList to hold the book information.
	    	System.out.println("#	Type");
	        System.out.println("1	Children's Books");
	        System.out.println("2	Cookbooks");
	        System.out.println("3	Paperbacks");
	        System.out.println("4	Periodicals");
	     	System.out.print("Enter type of book: ");
	     	int type = input.nextInt();  // Hold the user input for the book type.
	     	System.out.println("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
	     	char frequency = input.next().charAt(0); // Hold the user input for which frequency of book you want to display.
	     	for(Object i : ArrayBook) 
	     	{
	     		long lastDigit = ((Book) i).getISBN()%10; // Hold the last digit for the ISBN.
	     		// check the last digit, the type, and the frequency of the book.
	     		if((lastDigit == 0 || lastDigit == 1) && type == 1 && ((Book) i).getFrequency() == frequency) 
	     		{
	     			searchedArray.add(i);  // Add the book information to the array list to display.
	     			}
	     		else if((lastDigit == 2 || lastDigit == 3) && type ==2 && ((Book) i).getFrequency() == frequency) 
	     		{
	     			searchedArray.add(i);  // Add the book information to the array list to display.
	     			}
	     		else if((lastDigit>=4 && lastDigit<=7) && type ==3 && ((Book) i).getFrequency() == frequency) 
	     		{
	       			searchedArray.add(i);  // Add the book information to the array list to display.
	       			}
	     		else if((lastDigit==8 || lastDigit==9) && type ==4 && ((Book) i).getFrequency() == frequency) 
	     		{
	   				searchedArray.add(i);  // Add the book information to the array list to display.
           			}
	     		}
	     	if(searchedArray.size()!=0) // If the size of the array list not equal to 0, will display the book information.
	     	{
	     		for(Object b : searchedArray)
	     		{
	     			System.out.println(b);
	     			}
	     	    }
	     	else  // Otherwise, the size of the array list equal to 0 and will display no result.
	     	{
	     		System.out.println("Sorry! Not results found.");
	     		}
	     	}
	 
	/**
	 * randomBook - printing random book/s from the ArrayList.
	 * @param ArrayBook - ArrayList of book.
	 * @param numberOfBooks - holding the input from the user of how many books you want to print.
	 */
   	private static void randomBook(ArrayList<Object> ArrayBook, int numberOfBooks) {
		for(int i = 0; i < numberOfBooks; i++) 
		{
			Collections.shuffle(ArrayBook);              // Select random book for the array list.
			Book randomBook = (Book) ArrayBook.get(i);   // Hold the array list.
			System.out.printf("%nRandom books:%n");      
			System.out.println(randomBook);              // Print the book information details.
		}
		System.out.println();
	}
	
   	/**
   	 * write - Method will call when the program exits, that takes books stored in the array list 
   	 *         and save them back to the "Books_Edited.txt" file in the proper format. 
   	 * @param ArrayBook - ArrayList of Book.
   	 * @throws IOException - Thrown when the file could not be accessed.
   	 */
   	public static void write(ArrayList<Object> ArrayBook) throws IOException {
		File outputFile = new File(System.getProperty("user.dir")+"/res/books.txt");
        PrintWriter output = new PrintWriter(outputFile);
        // for each loop.
		for(Object writeArray : ArrayBook) {  // 'writeArray will loop through all books in arraylist ArrayBook.  
			output.print(((Book) writeArray).getISBN()+";"+
                    ((Book) writeArray).getNumber()+";"+
                    ((Book) writeArray).getAvailable()+";"+
                    ((Book) writeArray).getTotal()+";"+
                    ((Book) writeArray).getTitle()+";"+
                    (((Book) writeArray).getAuthors()==""?(""):((((Book) writeArray).getAuthors()+";")))+
                    (((Book) writeArray).getFormat()=='x'?(""):((((Book) writeArray).getFormat()+";")))+
                    (((Book) writeArray).getPublisher()==""?(""):((((Book) writeArray).getPublisher()+";")))+
                    (((Book) writeArray).getDiet()=='x'?(""):((((Book) writeArray).getDiet()+";")))+
                    (((Book) writeArray).getYear()==0?(""):((((Book) writeArray).getYear()+";")))+
                    (((Book) writeArray).getGenre()=='x'?(""):((((Book) writeArray).getGenre()+";")))+
                    (((Book) writeArray).getFrequency()=='x'?("\n"):((((Book) writeArray).getFrequency()+";\n"))));
		}
		output.close();
	}
   	
   	/**
   	 * print - Method will call to print the menu again and read the input from the user.
   	 * @param input - read input from the user keyboard.
   	 * @return - will return the value of the user select.
   	 */
   	public static int print(Scanner input) {
        System.out.printf ("\f");
        System.out.printf ("Welcome in ABC Book Company: How May We Assist You?\n");
        System.out.printf ("1 Checkout Book%n");
        System.out.printf ("2 Find Books by Title%n");
        System.out.printf ("3 Display Books by Type%n");
        System.out.printf ("4 Produce Random Book List%n");
        System.out.printf ("5 Save & Exit%n%n");
        System.out.printf ("Enter option: ");
        int select = input.nextInt(); // read input from the user and assigned to select.
        input.nextLine(); // consume \n
        return select;
    }
}
