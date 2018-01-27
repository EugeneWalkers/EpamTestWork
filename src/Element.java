public abstract class Element implements Comparable<Element> {
    protected String name;
    protected String autor;

    public Element(String autor, String name) {
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

    public String toString() {
        return autor + " - " + name;
    }

    public int compareTo(Element element) {
        if (autor.compareTo(element.getAutor()) == 0) {
            return name.compareTo(element.getName());
        } else {
            return name.compareTo(element.getAutor());
        }
    }

    public boolean equals(Element e){
        return e.getAutor().equals(autor) && e.getName().equals(name);
    }
}
