package com.mexicode.market.persistence.entity;


import javax.persistence.*;

@Entity   //Le dira que se comportara como na mapeo de una tabla
@Table(name= "productos") //Indico a Java que esta clase refiere a la
                          //tabla productos
public class Producto {

    /**Mapeo de las proiedades*/
          //Todas las variables deben ir en Tipo Primitivo

/**Campo1*/
        //Por que es clave primaria de la tabla
    @Id
        //POr que dara identidad al regitro y lo quiero automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        //Por que NO se llaman igual en la tabla y en la clase
    @Column(name = "id_producto")
    private Integer idProducto;
/**Campo2*/
    //No lleva anotacion por que se llama igual
    private String nombre;
/**Campo3*/
    @Column(name= "id_categoria")
    private Integer idCategoria;
/**Campo4*/
    @Column(name= "codigo_barras")
    private String codigoBarras;
/**Campo5*/
    @Column(name= "precio_venta")
    private Double precioVenta;
/**Campo6*/
    @Column(name= "cantidad_stock")
    private Integer cantidadStock;
/**Campo7*/
    //MIsmo nombre --> Se queda igual
    private  Boolean estado;

    /**RELACION ENTRE ENTITIES*/
    @ManyToOne    /**Muchos productos a una categoria*/
    @JoinColumn(name= "id_categoria" , insertable = false, updatable= false)
                //Con que campo se enlaza??  Se puede insertar o modificar desde aqui??
    private Categoria categoria; /**Accedo a los atributos de la clase*/


    /**Getters and Setters for each column*/
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
