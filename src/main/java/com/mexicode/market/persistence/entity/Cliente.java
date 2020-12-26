package com.mexicode.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")

public class Cliente {

    /**Atributos*/
/**Campo1*/
    @Id
    //@GeneratedValue no es necesario por que el cliente ya tiene un Id en su persona
    private String id;
/**Campo2*/
    private String nombre;
/**Campo3*/
    private String apellidos;
/**Campo4*/
    private Long celular;
/**Campo5*/
    private String direccion;
/**Campo6*/
    @Column(name = "correo_electronico")
    private String correoElectronico;
/**Campo7*/

/**RELACIONES ENTRE ENTITIES*/
@OneToMany(mappedBy = "cliente")  /**Un cliente puede tener muchas compras*/
 private List<Compra> compras;



/**Getters an Setters*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
