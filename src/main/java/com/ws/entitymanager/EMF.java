package com.ws.entitymanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("ws");
    
    public static EntityManagerFactory getEMF() {
    	return em;
    }
}


