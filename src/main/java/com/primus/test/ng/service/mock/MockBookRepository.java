/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.service.mock;

import com.primus.test.ng.api.service.BookRepository;
import com.primus.test.ng.model.Author;
import com.primus.test.ng.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author Olise.Okpala
 */
@ApplicationScoped
public class MockBookRepository implements BookRepository
{
    private static final List<Book> BOOK_STORE = new ArrayList<>();   

    @Override
    public void add(Book book)
    {
        if(book == null)
        {
            throw new IllegalArgumentException("Book cannot be null");
            
        }
        if(book.getAuthors().isEmpty()) //only because this is a demo - not thread safe
        {
            throw new IllegalArgumentException("At least one author is required");
        }
        boolean exists = BOOK_STORE.stream().anyMatch((b) -> {return book.getIsbn().equalsIgnoreCase(b.getIsbn());});
        if(exists)
        {
            throw new IllegalArgumentException("Book alreay exists");
        }
        BOOK_STORE.add(book);
    }

    @Override
    public List<Book> getAll()
    {
        if(BOOK_STORE.isEmpty())
        {
            initializeBooks();
        }
        return BOOK_STORE;
                
    }

    @Override
    public void update(Book book)
    {
        Optional<Book> existingBook = BOOK_STORE.stream().filter((b) -> b.getIsbn().equalsIgnoreCase(book.getIsbn())).findFirst();
        if(!existingBook.isPresent())
        {
            throw new IllegalArgumentException("Book does not exist");
        }
        Book previousBook = existingBook.get();
        previousBook = book;
    }

    private void initializeBooks()
    {
        Book book = new Book();
        book.setIsbn("0029299283773");
        book.setTitle("To Kill a Mocking Bird");
        book.setPageCount(250);
        Author author = new Author(1L, "Lee Harper");
        
        List<Author>  authors = new ArrayList<>();
        authors.add(author);
        book.setAuthors(authors);
        BOOK_STORE.add(book);
    }
    
}
