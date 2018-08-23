package domain;

import java.util.Set;

public class Author {
    public String firstName;
    public String lastName;
    public Set<Book> books;

    public Author(String firstName, String lastName, final Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }
}
