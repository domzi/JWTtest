package domain;

import java.util.HashSet;
import java.util.Set;

public class Book {
    public String name;
    public int edition;
    public Set<Author> authors;

    public Book(String name, int edition, final Set<Author> authors) {
        this.name = name;
        this.edition = edition;
        this.authors = authors;
    }
}
