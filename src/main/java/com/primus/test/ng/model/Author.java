/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.model;

/**
 *
 * @author Olise.Okpala
 */
public class Author
{
    private Long id;
    private String fullName;

    public Author(Long id, String fullName)
    {
        this.id = id;
        this.fullName = fullName;
    }

    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
}
