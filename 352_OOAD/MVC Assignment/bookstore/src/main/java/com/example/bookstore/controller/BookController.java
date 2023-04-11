package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/add")
  public String showAddBookForm(Model model) {
    model.addAttribute("book", new Book());
    return "addBook";
  }

  @PostMapping("/add")
  public String addBook(Book book) {
    bookRepository.save(book);
    return "redirect:/books/list";
  }

  @GetMapping("/list")
  public String listBooks(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "listBooks";
  }
}
