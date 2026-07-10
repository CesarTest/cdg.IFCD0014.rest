package cdg.IFCD0014.rest.service;

import cdg.IFCD0014.rest.exception.LibroNotFoundException;
import cdg.IFCD0014.rest.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILibroService {
    public List<Libro> findAll();
    public Libro save(Libro libro) throws LibroNotFoundException;
    public Libro buscaLibro(String isbn) throws LibroNotFoundException;
    public Libro updateLibro(String isbn, Libro libro) throws LibroNotFoundException;
    public void borraLibro(String isbn) throws LibroNotFoundException;
    }
