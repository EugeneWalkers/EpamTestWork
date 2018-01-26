public class Main {
    public static String listOfPupils = "pupils.txt";
    public static String listOfLibraryElements = "elements.txt";
    public static void main(String[] args){
        Library myLibrary = new Library();
        myLibrary.readPupils(listOfPupils);
        myLibrary.readElements(listOfLibraryElements);
    }
}
