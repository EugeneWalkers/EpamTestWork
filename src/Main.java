public class Main {
    public static String listOfPupils = "pupils.txt";
    public static String listOfLibraryElements = "elements.txt";
    public static String listOfOrders = "ordersOfPupils.txt";
    static int lowBorder1 = 1; // not included
    static int highBorder1 = 2; // included
    static int lowBorder2 = 1; // not included
    static int highBorder2 = 2; // included

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.readPupils(listOfPupils); // read and write all users of the library
        myLibrary.readElements(listOfLibraryElements); // read and write all elements of the library (books, journals, etc.)
        myLibrary.readOrders(listOfOrders); // read and write all orders of persons
        System.out.println(myLibrary.getListOfElements());
        System.out.println("Report 1:\n" + myLibrary.getReport1(lowBorder1, highBorder1) + "\n");
        System.out.println("Report 2:\n" + myLibrary.getReport2(lowBorder2, highBorder2) + "\n");
    }
}
