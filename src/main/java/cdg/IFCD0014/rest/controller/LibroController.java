package cdg.IFCD0014.rest.controller;

import cdg.IFCD0014.rest.exception.LibroNotFoundException;
import cdg.IFCD0014.rest.model.Libro;
import cdg.IFCD0014.rest.service.ILibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibroController {
    private ILibroService servicio;

    public LibroController(ILibroService servicio) {
        this.servicio = servicio;
    }

    @GetMapping({"/saludo"})
    public Libro saludo() {
        Libro saludo = new Libro("ISBN", "La casa de Papel", "Victor Hugo");
        return saludo;
    }

    @GetMapping({"/libros"})
    public List<Libro> libros() {
        return this.servicio.findAll();
    }

    @PostMapping({"/libros"})
    public ResponseEntity<Libro> create(@RequestBody Libro libro) {
        try {
            Libro resultado = this.servicio.save(libro);
            return ResponseEntity.ok(resultado);
        } catch (LibroNotFoundException var3) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping({"/libros/{ISBN}"})
    public ResponseEntity<Libro> buscaLibro(@PathVariable String ISBN) {
        try {
            Libro resultado = this.servicio.buscaLibro(ISBN);
            return ResponseEntity.ok(resultado);
        } catch (LibroNotFoundException var3) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PatchMapping({"/libros/{ISBN}"})
    public ResponseEntity<Libro> update(@PathVariable String ISBN, @RequestBody Libro libro) throws LibroNotFoundException {
        try {
            Libro resultado = this.servicio.updateLibro(ISBN, libro);
            return ResponseEntity.ok(resultado);
        } catch (LibroNotFoundException var4) {
            return ResponseEntity.unprocessableContent().body(null);
        }
    }

    @DeleteMapping({"/libros/{ISBN}"})
    public ResponseEntity<Libro> delete(@PathVariable String ISBN) throws LibroNotFoundException {
        try {
            this.servicio.borraLibro(ISBN);
            return ResponseEntity.ok().body(null);
        } catch (LibroNotFoundException var3) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
