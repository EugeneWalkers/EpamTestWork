public abstract class Element {
    protected String name;
    protected String autor;

    public Element(String autor, String name){
        this.autor = autor;
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
