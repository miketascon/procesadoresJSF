/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.procesadores.jpa.sessions;

import com.procesadores.jpa.entities.Procesadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dandres
 */
@Stateless
public class ProcesadoresFacade extends AbstractFacade<Procesadores> {
    @PersistenceContext(unitName = "procesadoresPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesadoresFacade() {
        super(Procesadores.class);
    }
    
}
