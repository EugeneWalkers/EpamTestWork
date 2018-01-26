import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Library {
    ArrayList<Book> books;
    ArrayList<Article> articles;
    ArrayList<Journal> journals;
    ArrayList<Newspaper> newspapers;
    ArrayList<Pupil> pupils;

    public Library(){
        books = new ArrayList<>();
        articles = new ArrayList<>();
        journals = new ArrayList<>();
        newspapers = new ArrayList<>();
        pupils = new ArrayList<>();
    }

    public void readPupils(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file).getAbsoluteFile()));
            StringBuilder temp = new StringBuilder("");
            while (!temp.append(reader.readLine()).toString().equals("null")){
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

    public void readElements(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file).getAbsoluteFile()));
            StringBuilder temp = new StringBuilder("");
            while (!temp.append(reader.readLine()).toString().equals("null")){
                String[] data = temp.toString().split(" ", 3);
                switch(data[0].toLowerCase()){
                    case "book":
                        books.add(new Book(data[1], data[2]));
                        break;
                    case "newspaper":
                        newspapers.add(new Newspaper(data[1], data[2]));
                        break;
                    case "journal":
                        journals.add(new Journal(data[1], data[2]));
                        break;
                    case "article":
                        articles.add(new Article(data[1], data[2]));
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
}
