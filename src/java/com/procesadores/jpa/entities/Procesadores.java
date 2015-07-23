/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.procesadores.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dandres
 */
@Entity
@Table(name = "procesadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesadores.findAll", query = "SELECT p FROM Procesadores p"),
    @NamedQuery(name = "Procesadores.findByIdProcesador", query = "SELECT p FROM Procesadores p WHERE p.idProcesador = :idProcesador"),
    @NamedQuery(name = "Procesadores.findByMarca", query = "SELECT p FROM Procesadores p WHERE p.marca = :marca"),
    @NamedQuery(name = "Procesadores.findByModelo", query = "SELECT p FROM Procesadores p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Procesadores.findByFechaVenta", query = "SELECT p FROM Procesadores p WHERE p.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Procesadores.findByPrecio", query = "SELECT p FROM Procesadores p WHERE p.precio = :precio"),
    @NamedQuery(name = "Procesadores.findByEntregado", query = "SELECT p FROM Procesadores p WHERE p.entregado = :entregado")})
public class Procesadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procesador")
    private Integer idProcesador;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @Column(name = "entregado")
    private Boolean entregado;

    public Procesadores() {
    }

    public Procesadores(Integer idProcesador) {
        this.idProcesador = idProcesador;
    }

    public Integer getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(Integer idProcesador) {
        this.idProcesador = idProcesador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesador != null ? idProcesador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesadores)) {
            return false;
        }
        Procesadores other = (Procesadores) object;
        if ((this.idProcesador == null && other.idProcesador != null) || (this.idProcesador != null && !this.idProcesador.equals(other.idProcesador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.procesadores.jpa.entities.Procesadores[ idProcesador=" + idProcesador + " ]";
    }
    
}
