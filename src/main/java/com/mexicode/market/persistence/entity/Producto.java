package com.mexicode.market.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity   //Le dira que se comportara como na mapeo de una tabla
@Table(name= "productos") //Indico a Java que esta clase refiere a la
                          //tabla productos
public class Producto {
}
