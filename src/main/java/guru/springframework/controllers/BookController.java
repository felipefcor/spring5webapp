package guru.springframework.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BookController
{
    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }


    public String getBooks(Model model){
        model.addAttribute("book", bookRepository.findAll());
        return "books";
    }
}
