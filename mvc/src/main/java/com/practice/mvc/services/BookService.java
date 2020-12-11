package com.practice.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.mvc.models.Book;
import com.practice.mvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Book book, Long id) {
		Book bookOg = findBook(id);
		bookOg.setTitle(book.getTitle());
		bookOg.setDescription(book.getDescription());
		bookOg.setLanguage(book.getLanguage());
		bookOg.setNumberOfPages(book.getNumberOfPages());
		bookRepository.save(bookOg);
    	return book;
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
}
