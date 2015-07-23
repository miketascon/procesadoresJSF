/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.procesadores.jsf.controller;

import com.procesadores.jpa.entities.Procesadores;
import com.procesadores.jpa.sessions.ProcesadoresFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author dandres
 */
@ManagedBean
@SessionScoped
public class ProcesadoresController implements Serializable{

   private Procesadores procesadoresActual;
   private List<Procesadores> listaProcesadores;
   @EJB
   private ProcesadoresFacade procesadoresFacade;
   
    public ProcesadoresController() {
    }

    public Procesadores getProcesadoresActual() {
        if (procesadoresActual == null) {
            procesadoresActual = new Procesadores();
        }
        return procesadoresActual;
    }

    public void setProcesadoresActual(Procesadores procesadoresActual) {
        this.procesadoresActual = procesadoresActual;
    }

    
    
    public ProcesadoresFacade getProcesadoresFacade() {
        return procesadoresFacade;
    }
    
    
     public String prepareCreate() {
        procesadoresActual = new Procesadores();
        return "/faces/Procesadores/Crear";
    }

    public String prepareEdit() {
        return "/faces/Procesadores/Editar";
    }

    public String prepareView() {
        return "/faces/Procesadores/Ver";
    }

    public String prepareList() {
        recargarLista();
        return "/faces/Procesadores/Lista";
    }

    private void recargarLista() {
        listaProcesadores = null;
    }

    public List<Procesadores> getListaProcesadores() {
        if (listaProcesadores == null) {
            try {
                listaProcesadores = getProcesadoresFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaProcesadores;
    }
    
    public String addProcesador() {
        try {
           
            getProcesadoresFacade().create(procesadoresActual);
            addSuccesMessage("Procesador registrado", "Procesador registrado Exitosamente.");
            recargarLista();
            return "/faces/Procesadores/Lista";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }

    }

    public String updateProcesador() {
        try {
            getProcesadoresFacade().edit(procesadoresActual);
            addSuccesMessage("Actualizar Registro", "Registro Actualizado Exitosamente.");
            recargarLista();
            return "/faces/Procesadores/Lista";

        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }

    }

    public String deleteProcesador() {
        try {
            getProcesadoresFacade().remove(procesadoresActual);
            addSuccesMessage("Eliminar Procesador", "Procesador Eliminado Exitosamente.");
            recargarLista();

        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());

        }
        return "/faces/Procesadores/Lista";
    }
    
     private void addErrorMessage(String title, String msq) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msq);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private void addSuccesMessage(String title, String msq) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msq);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public Procesadores getProcesadores(java.lang.Integer id) {
        return getProcesadoresFacade().find(id);
    }
    
}
