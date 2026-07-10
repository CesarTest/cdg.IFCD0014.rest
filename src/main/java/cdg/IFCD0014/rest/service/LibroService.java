package cdg.IFCD0014.rest.service;

import cdg.IFCD0014.rest.exception.LibroNotFoundException;
import cdg.IFCD0014.rest.model.Libro;
import cdg.IFCD0014.rest.repo.ILibroRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
@Service
public class LibroService implements ILibroService{
    private Libro libro;
    private ILibroRepo dao;
    private String isbn;

    public LibroService (ILibroRepo repo) {
        this.dao=repo;
    }

    public List<Libro> findAll() {
        return this.dao.findAll();
    }

    public Libro save(Libro libro) throws LibroNotFoundException {
        try {
            return (Libro)this.dao.save(libro);
        } catch (Exception var3) {
            throw new LibroNotFoundException("Error saving to DataBase");
        }
    }

    public Libro buscaLibro(String isbn) throws LibroNotFoundException {
        return (Libro)this.dao.findById(isbn).orElseThrow(LibroNotFoundException::new);
    }

    public Libro updateLibro(String isbn, Libro libro) throws LibroNotFoundException {
        if (this.dao.findById(isbn).isPresent()) {
            return (Libro)this.dao.save(libro);
        } else {
            throw new LibroNotFoundException(isbn.concat(" Not Found"));
        }
    }

    public void borraLibro(String isbn) throws LibroNotFoundException {
        if (this.dao.findById(isbn).isPresent()) {
            this.dao.deleteById(isbn);
        } else {
            throw new LibroNotFoundException(isbn.concat(" NotFound"));
        }
    }

}
