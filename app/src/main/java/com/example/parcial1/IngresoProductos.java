package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import id.ionbit.ionalert.IonAlert;
import models.Producto;

public class IngresoProductos extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtCode;
    private EditText txtValor;
    private EditText txtProductoIVA;
    private EditText txtDescripcion;
    private Button btnAgregar;
    private Button btnAtras;
    public static List<Producto> listaProducto= new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_productos);

        setContentView();

        btnAgregar.setOnClickListener(this);
        btnAtras.setOnClickListener(this);
    }

    public void setContentView() {
        txtName = findViewById(R.id.txtName);
        txtCode = findViewById(R.id.txtCode);
        txtValor = findViewById(R.id.txtValor);
        txtProductoIVA = findViewById(R.id.txtProductoIVA);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAtras = findViewById(R.id.btnAtras);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAgregar){
            String Name = txtName.getText().toString();
            int Code = Integer.parseInt(txtCode.getText().toString());
            int Valor = Integer.parseInt(txtValor.getText().toString());
            String ProductoIVA = txtProductoIVA.getText().toString();
            String Descripcion = txtDescripcion.getText().toString();

            CrearProducto(Name,Code,Valor,ProductoIVA,Descripcion);
        }

        else if(v.getId() == R.id.btnAtras){
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
        }
    }

    private void CrearProducto(String Name, int Code, int Valor, String ProductoIVA, String Descripcion) {
        if(Name.equals("")){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear el PRODUCTO...!")
                    .setContentText("Verifique el campo NOMBRE!")
                    .show();
            return;
        }else if(Code==0){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear el PRODUCTO...!")
                    .setContentText("Verifique el campo CODIGO!")
                    .show();
            return;
        }else if(Valor==0){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear el PRODUCTO...!")
                    .setContentText("Verifique el campo VALOR!")
                    .show();
            return;
        }else if(ProductoIVA.equals("")){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear el PRODUCTO...!")
                    .setContentText("Verifique el campo PRODUCTO EXECTO O NO DE IVA!")
                    .show();
            return;
        }else if(Descripcion.equals("")){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear el PRODUCTO...!")
                    .setContentText("Verifique el campo DESCRIPCIÓN!")
                    .show();
            return;
        }else{
            Producto producto = new Producto(Name, Code, Valor, ProductoIVA,Descripcion);

            this.listaProducto.add(producto);

            new IonAlert(this, IonAlert.SUCCESS_TYPE)
                    .setTitleText("PERFECTO!")
                    .setContentText("Se agrego una PRODUCTO!")
                    .show();
        }

        txtName.setText("");
        txtCode.setText("");
        txtValor.setText("");
        txtProductoIVA.setText("");
        txtDescripcion.setText("");

    }

}