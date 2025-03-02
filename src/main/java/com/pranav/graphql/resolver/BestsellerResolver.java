package com.pranav.graphql.resolver;

import com.pranav.graphql.model.Bestseller;
import com.pranav.graphql.repository.BestsellerRepository;
import com.pranav.graphql.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class BestsellerResolver {
    private final BestsellerRepository bestsellerRepository;
    //private final BookRepository bookRepository;

    /*public BestsellerResolver(BestsellerRepository bestsellerRepository, BookRepository bookRepository) {
        this.bestsellerRepository = bestsellerRepository;
        this.bookRepository = bookRepository;
    }*/

    public BestsellerResolver(BestsellerRepository bestsellerRepository) {
        this.bestsellerRepository = bestsellerRepository;
    }

    /*@QueryMapping
    public List<Book> topBestsellers(@Argument String category) {
        Optional<Bestseller> bestseller = bestsellerRepository.findByCategory(category);

        if (bestseller.isEmpty()) {
            log.info("No bestsellers found for category: " + category);
            return Collections.emptyList();
        }

        List<Book> books = bookRepository.findAllById(bestseller.get().getBookIds());
        log.info("Books fetched: " + books);

        return books;
    }*/

    @QueryMapping
    public List<Bestseller> getAllBestSellers() {
        List<Bestseller> bestsellers = bestsellerRepository.findAll();
        if (bestsellers == null) {
            log.info("bestsellerRepository.findAll() returned null! Fixing it by returning an empty list.");
            return Collections.emptyList();
        }
        log.info("Fetched Bestsellers: {}", bestsellers);
        return bestsellers;
    }
}