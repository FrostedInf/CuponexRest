/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Date;

/**
 *
 * @author alex
 */
public class Promocion {
    private int idPromocion;
    private String nombre;
    private String Descripcion;
    private String tipoPromocion;
    private String restriccion;
    private Date fechaInicio;
    private Date fechaFin;

    public Promocion() {
    }

    public Promocion(int idPromocion, String nombre, String Descripcion, String tipoPromocion, String restriccion, Date fechaInicio, Date fechaFin) {
        this.idPromocion = idPromocion;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.tipoPromocion = tipoPromocion;
        this.restriccion = restriccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public String getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(String restriccion) {
        this.restriccion = restriccion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
