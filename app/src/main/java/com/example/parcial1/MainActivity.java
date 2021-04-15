package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.jar.Attributes;

import id.ionbit.ionalert.IonAlert;
import models.Producto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static List<Producto> listaProducto = new ArrayList<>();

    private Button btnAgregarProducto;
    private Button btnExentosOno;
    private Button btnProductosCostosos;
    private Button btnProductosEconomicos;
    private Button btnPromedio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IngresoProductos ingreso = new IngresoProductos();
        listaProducto = ingreso.listaProducto;

        for(int i=0; i<listaProducto.size();i++){
            Log.d("VALIDACION", "onCreate: NOMBRE"+ listaProducto.get(i).getName());
        }


        btnAgregarProducto = findViewById(R.id.btnAgregarProducto);
        btnExentosOno = findViewById(R.id.btnExentosOno);
        btnProductosCostosos = findViewById(R.id.btnProductosCostosos);
        btnProductosEconomicos = findViewById(R.id.btnProductosEconomicos);
        btnPromedio = findViewById(R.id.btnPromedio);

        btnAgregarProducto.setOnClickListener(this);
        btnExentosOno.setOnClickListener(this);
        btnProductosCostosos.setOnClickListener(this);
        btnProductosEconomicos.setOnClickListener(this);
        btnPromedio.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarProducto) {
            Intent myIntent = new Intent(this, IngresoProductos.class);
            startActivity(myIntent);
        }
        // VALIDAR SI ESTAN EXENTOS DEL IVA O NO
        else if (v.getId() == R.id.btnExentosOno) {

            String datos = "";

            for (int i = 0; i < this.listaProducto.size(); i++) {
                if ((this.listaProducto.get(i).getProductoIVA().equals("SI")) || (this.listaProducto.get(i).getProductoIVA().equals("NO"))) {

                    datos = datos + "\n"+ this.listaProducto.get(i).getName() + " " + this.listaProducto.get(i).getProductoIVA() + " esta exento del IVA  ";
                }
            }
            new IonAlert(this)
                    .setTitleText("LISTA DE PRODUCTOS SI ESTAN EXENTOS O NO DEL IVA ")
                    .setContentText(datos)
                    .show();

        } else if (v.getId() == R.id.btnProductosCostosos) {

            Collections.sort(listaProducto);

            int tope=0;

            if(listaProducto.size()>=10){
                tope=10;
            }else{
                tope=listaProducto.size();
            }

            String datos= "";

            for (int i = 0; i < tope; i++) {
                datos = datos + this.listaProducto.get(i).getName() + " tiene un costo de " + this.listaProducto.get(i).getValor()+"  ";
            }

            new IonAlert(this)
                    .setTitleText("LISTA DE PRODUCTOS MAS COSTOSOS")
                    .setContentText(datos)
                    .show();

        } else if (v.getId() == R.id.btnProductosEconomicos) {

            Collections.sort(listaProducto, new Comparator<Producto>() {
                public int compare(Producto obj1, Producto obj2) {
                    return obj1.getValor().compareTo(obj2.getValor());
                }
            });

            int tope=0;

            if(listaProducto.size()>=10){
                tope=10;
            }else{
                tope=listaProducto.size();
            }

            String datos= "";

            for (int i = 0; i < tope; i++) {
                datos = datos + this.listaProducto.get(i).getName() + " tiene un costo de " + this.listaProducto.get(i).getValor()+"  ";
            }

            new IonAlert(this)
                    .setTitleText("LISTA DE PRODUCTOS MAS ECONOMICOS")
                    .setContentText(datos)
                    .show();

        }

    }
         
}
