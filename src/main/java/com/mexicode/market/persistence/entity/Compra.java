package com.mexicode.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {


    /**Atributos de la tabla compras a variables de la clase Compra*/
/**campo1*/
    @Id  //Es primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Debe ser irrepetible y de tipo numerico
    @Column(name = "id_compra")  //refiere al campo id_compra
    private Integer idCompra;
/**campo2*/
    @Column(name = "id_cliente")
    private String idCliente;
/**campo3*/
    //No cambia el nombre por ello se queda igual
    private LocalDateTime fecha;
/**campo4*/
    @Column(name = "medio_pago")
    private String medioPago;
/**campo5*/
    private String comentario;
/**campo6*/
    private String estado;

    @ManyToOne /**Muchas compras pueden tener un solo cliente*/ //No permitir crear nuevos clientes a traves de esta relacion
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    /**Me interesa acceder to All Products in a Compra*/
                                       //Todos los porcesos que se hagaen una BD van a incluir sus productos
    @OneToMany(mappedBy = "compra" , cascade = {CascadeType.ALL})
    private List<ComprasProducto> productos;



     /**Getters an Setters*/


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }
}
