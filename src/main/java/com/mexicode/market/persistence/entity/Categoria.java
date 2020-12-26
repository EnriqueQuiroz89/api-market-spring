package com.mexicode.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    /**Atributos*/
/**Campo1*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

/**Campo2*/
    private String descripcion;

/**Campo3*/
    private Boolean estado;

    /**Relacion entre entidades*/
    //Una categoria puede estar en muchos Productos
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;


    /**Getters an setters*/

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
