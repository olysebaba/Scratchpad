/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.api.vo;

import java.util.List;

/**
 *
 * @author Olise.Okpala
 */
public class BookInfo
{
    private final String title;
    private List<String> authors;
    private final String isbn;
    private  final int pageCount;

    public BookInfo(String title, String isbn, int pageCount)
    {
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
    }

    public String getTitle()
    {
        return title;
    }

    public List<String> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<String> authors)
    {
        this.authors = authors;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public int getPageCount()
    {
        return pageCount;
    }
    
    
}
