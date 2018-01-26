import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Pupil {
    private String name;
    private String surname;
    private GregorianCalendar dateOfBirth;
    TreeSet<Element> elements = new TreeSet<>();

    public Pupil(String surname, String name, GregorianCalendar dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString(){
        return name + " " + surname + "(" + dateOfBirth.get(Calendar.DATE)+"." + dateOfBirth.get(Calendar.MONTH) + "." + dateOfBirth.get(Calendar.YEAR) + ")";
    }
}
