/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.api.service;

import com.primus.test.ng.model.Book;
import java.util.List;

/**
 *
 * @author Olise.Okpala
 */
public interface BookRepository
{
    void add(Book book);
    List<Book> getAll();
    void update(Book book);    
}
