package cdg.IFCD0014.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Libro {
    @Id
    private String ISBN;
    private String title;
    private String author;
    public Libro(){};
    public Libro(String isbn, String title, String author) {
        this.ISBN = isbn;
        this.author = author;
        this.title = title;
    }
}
