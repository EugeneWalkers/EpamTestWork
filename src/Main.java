import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static String listOfPupils = "pupils.txt";
    public static String listOfLibraryElements = "elements.txt";
    public static String listOfOrders = "ordersOfPupils.txt";
    static int lowBorder1 = 1; // not included
    static int highBorder1 = 2; // included
    static int lowBorder2 = 2; // included
    static int highBorder2 = 2; // included

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.readPupils(listOfPupils); // read and write all users of the library
        myLibrary.readElements(listOfLibraryElements); // read and write all elements of the library (books, journals, etc.)
        myLibrary.readOrders(listOfOrders); // read and write all orders of persons
        String answer1 = myLibrary.getListOfElements();
        String answer2 = myLibrary.getReport1(lowBorder1, highBorder1);
        String answer3 = myLibrary.getReport2(lowBorder2, highBorder2);
        System.out.println(answer1);
        System.out.println("Report 1:\n" + answer2 + "\n");
        System.out.println("Report 2:\n" + answer3 + "\n");
        try {
            PrintWriter writer = new PrintWriter(new File("List of all elements.txt"));
            writer.println(answer1);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter writer = new PrintWriter(new File("Report 1.txt"));
            writer.println(answer2);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter writer = new PrintWriter(new File("Report 2.txt"));
            writer.println(answer3);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
