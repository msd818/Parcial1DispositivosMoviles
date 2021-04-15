package models;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Producto implements Comparable<Producto> {

    private String Name;
    private Integer Code;
    private Integer Valor;
    private String ProductoIVA;
    private String Descripcion;


    public Producto() {
    }


    public Producto(String name, Integer code, Integer valor, String productoIVA, String descripcion) {
        Name = name;
        Code = code;
        Valor = valor;
        ProductoIVA = productoIVA;
        Descripcion = descripcion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public Integer getValor() {
        return Valor;
    }

    public void setValor(Integer valor) {
        Valor = valor;
    }

    public String getProductoIVA() {
        return ProductoIVA;
    }

    public void setProductoIVA(String productoIVA) {
        ProductoIVA = productoIVA;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    //MAYOR A MENOR
    @Override
    public int compareTo(Producto o) {
        if(o.getValor()>Valor){
            return 1;
        }else if(o.getValor() > Valor){
            return 0;
        }else{
            return -1;
        }

    }
}
