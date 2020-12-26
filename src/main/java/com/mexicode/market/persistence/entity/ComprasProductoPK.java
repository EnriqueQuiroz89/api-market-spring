package com.mexicode.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//NO lleva entity
@Embeddable  /**LA vamos a embever en otra clase*/
public class ComprasProductoPK  implements Serializable {
                                           //Interfaz de arriba

    /**No se indica @Id por que es compuesta y no es una @Entity*/
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    /**Getters and Setters*/
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
