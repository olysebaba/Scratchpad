/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primus.test.ng.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Olise.Okpala
 */
@ApplicationPath("/api")
public class BaseApplication extends Application
{
    private Set<Object> singletons = new HashSet<>();

    @Override
    public Set<Class<?>> getClasses()
    {
        return Collections.EMPTY_SET;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }
}
