import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Library {
    protected ArrayList<Pupil> pupils;
    protected ArrayList<Element> elements;

    public Library() {
        pupils = new ArrayList<>();
        elements = new ArrayList<>();
    }

    public void readPupils(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file).getAbsoluteFile()));
            StringBuilder temp = new StringBuilder("");
            while (!temp.append(reader.readLine()).toString().equals("null")) {
                String[] data = temp.toString().split(" ");
                String[] date = data[2].split("\\.");
                pupils.add(new Pupil(data[0], data[1], new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]))));
                temp.delete(0, temp.length());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readElements(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file).getAbsoluteFile()));
            StringBuilder temp = new StringBuilder("");
            while (!temp.append(reader.readLine()).toString().equals("null")) {
                String[] data = temp.toString().split(" ", 3);
                switch (data[0].toLowerCase()) {
                    case "book":
                        elements.add(new Book(data[1], data[2]));
                        break;
                    case "newspaper":
                        elements.add(new Newspaper(data[1], data[2]));
                        break;
                    case "journal":
                        elements.add(new Journal(data[1], data[2]));
                        break;
                    case "article":
                        elements.add(new Article(data[1], data[2]));
                        break;
                    default:
                        break;
                }
                temp.delete(0, temp.length());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int searchPupil(String pupil) {
        pupil = pupil.toLowerCase();
        for (int i = 0; i < pupils.size(); i++) {
            if (pupil.equals(pupils.get(i).toString().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public int searchElement(String element) {
        element = element.toLowerCase();
        for (int i = 0; i < elements.size(); i++) {
            if (element.equals(elements.get(i).toString().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void readOrders(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file).getAbsoluteFile()));
            StringBuilder temp = new StringBuilder("");
            while (!temp.append(reader.readLine()).toString().equals("null")) {
                String[] data = temp.toString().split(" ", 5);
                String person = data[0] + " " + data[1] + " " + data[2];
                int indexOfPerson = searchPupil(person);
                if (indexOfPerson != -1) {
                    String element = data[3] + " - " + data[4];
                    int indexOfElement = searchElement(element);
                    if (indexOfElement != -1) {
                        pupils.get(indexOfPerson).addReadElement(elements.get(indexOfElement));
                    }
                }
                temp.delete(0, temp.length());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getListOfElements() {
        StringBuilder answer = new StringBuilder("");
        String[] classes = {"class Book", "class Article", "class Journal", "class Newspaper"};
        for (int i = 0; i < classes.length; i++) {
            answer.append(classes[i].substring(6) + "s:\n");
            for (int j = 0; j < elements.size(); j++) {
                if (elements.get(j).getClass().toString().equals(classes[i])) {
                    answer.append(elements.get(j).toString() + "\n");
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }

    public String getReport1(int lowD, int highD) {
        StringBuilder answer = new StringBuilder("");
        pupils.sort(Comparator.comparingInt(Pupil::getNumberOfReadBooks));
        for (int i = 0; i < pupils.size(); i++) {
            int temp = pupils.get(i).getNumberOfReadBooks();
            if (temp > lowD && temp <= highD) {
                answer.append(pupils.get(i).getSurname() + " " + pupils.get(i).getName() + ": " + temp + "\n");
            }
        }
        return answer.toString();
    }

    public String getReport2(int lowD, int highD){
        StringBuilder answer = new StringBuilder("");
        pupils.sort((Pupil o1, Pupil o2) -> {
            int temp = o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
            if (temp == 0){
                return o2.getNumberOfReadBooks() - o1.getNumberOfReadBooks();
            }
            return temp;
        });
        for (int i = 0; i < pupils.size(); i++) {
            int temp = pupils.get(i).getNumberOfReadBooks();
            if (temp > lowD && temp <= highD) {
                answer.append(pupils.get(i).toString() + ": " + temp + "\n");
            }
        }
        return answer.toString();
    }
}
