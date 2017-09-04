/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.api.service;

import com.primus.test.ng.api.vo.BookInfo;
import com.primus.test.ng.model.Author;
import com.primus.test.ng.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Olise.Okpala
 */
@Stateless
public class BookService
{
    @Inject
    private BookRepository repo;
    
    public List<BookInfo> getBooks()
    {
        List<BookInfo> books = new ArrayList<>();
        for(Book b : repo.getAll())
        {
            BookInfo book = new BookInfo(b.getTitle(), b.getIsbn(), b.getPageCount());
            List<String> names = new ArrayList<>(b.getAuthors().size());
            b.getAuthors().forEach((author) ->
            {
                names.add(author.getFullName());
            });
            book.setAuthors(names);
            books.add(book);            
            
        }
        return books;
    }
    
}
