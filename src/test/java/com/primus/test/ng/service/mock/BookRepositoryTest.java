/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.service.mock;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.primus.test.ng.model.Author;
import com.primus.test.ng.model.Book;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Olise.Okpala
 */
public class BookRepositoryTest
{
    
    public BookRepositoryTest()
    {
    }

    @Test
    public void testBookInitialisation()
    {
        MockBookRepository repository = new MockBookRepository();
        int bookCount = repository.getAll().size();
        assertTrue(bookCount > 0, "List is empty");
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullBookNotAdded()
    {
        MockBookRepository repository = new MockBookRepository();
        repository.add(null);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyAuthorNotAdded()
    {
        MockBookRepository repository = new MockBookRepository();
        Book book = new Book();
        repository.add(book);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDuplicateBookNotAdded()
    {
        MockBookRepository repository = new MockBookRepository();
        Book existingBook = repository.getAll().get(0);
        Book book = new Book();
        book.setIsbn(existingBook.getIsbn());
        book.setTitle("Things fall apart");
        book.setAuthors(existingBook.getAuthors()); //to ensure the right failure is triggered
        repository.add(book);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testOnlyPreviouslyAddedBookCanBeEdited()
    {
        MockBookRepository repository = new MockBookRepository();
        Book book = new Book();
        String existingISBN = repository.getAll().get(0).getIsbn();
        String newISBN = existingISBN + "29292992";
        book.setIsbn(newISBN);
        repository.update(book);
    }
    
    @Test
    public void testBookAddition()
    {
        MockBookRepository repository = new MockBookRepository();
        int oldCount = repository.getAll().size();
        Book book = new Book();
        book.setTitle("Domain Driven Design");
        book.setIsbn("2283844774");
        book.setPageCount(200);
        
        List authors = Arrays.asList(new Author(2L , "Eric Evans"));
        book.setAuthors(authors);
        repository.add(book);
        int newCount = repository.getAll().size();
        
        assertTrue(newCount == oldCount + 1, "Book not added");
    }
}
