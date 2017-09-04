/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.model;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Olise.Okpala
 */
public class Book
{
    private Long id;
    private String isbn;
    private String title;
    private int pageCount;
    private List<Author> authors;

    public Book()
    {
        this.authors = Collections.EMPTY_LIST;
    }
    
    

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
    
}
