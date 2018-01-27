import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Pupil {
    private String name;
    private String surname;
    private GregorianCalendar dateOfBirth;
    private TreeSet<Element> elements = new TreeSet<>();
    private int numberOfReadBooks;

    public Pupil(String surname, String name, GregorianCalendar dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        numberOfReadBooks = 0;
    }

    public void addReadElement(Element element) {
        if (element.getClass().toString().equals("class Book") && elements.add(element)) {
            numberOfReadBooks++;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        return surname + " " + name + " " + dateOfBirth.get(Calendar.DATE) + "." + dateOfBirth.get(Calendar.MONTH) + "." + dateOfBirth.get(Calendar.YEAR);
    }

    public int getNumberOfReadBooks() {
        return numberOfReadBooks;
    }

}
