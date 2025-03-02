package com.pranav.graphql.resolver;

import com.pranav.graphql.model.Book;
import com.pranav.graphql.repository.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver {
    private final BookRepository bookRepository;

    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable(value = "books")
    @QueryMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book getBookById(@Argument String id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with ID: "+ id));
    }

    @MutationMapping
    public Boolean deleteBookById(@Argument String id) {
        if(bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @MutationMapping
    public Book addBook(@Argument String title,
                        @Argument String author,
                        @Argument int pages) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPages(pages);
        return bookRepository.save(book);
    }
}