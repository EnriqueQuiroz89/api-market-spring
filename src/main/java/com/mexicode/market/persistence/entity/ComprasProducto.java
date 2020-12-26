package com.mexicode.market.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    /**Atributos*/
    @EmbeddedId   //Cuando clave es compuesta
    private ComprasProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

/**rELACIONE*/
    @ManyToOne   /**Mucho productos en una compra*/
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)  /***/
    private  Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private  Producto producto;



    /**Getters y setters*/
    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
