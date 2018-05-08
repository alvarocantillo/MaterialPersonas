package com.holamundo.materialpersonas;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersonas extends AppCompatActivity {
    private EditText txtcedula;
    private EditText txtnombre;
    private EditText txtApellido;
    private Spinner cmbsexo;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);
        txtcedula=findViewById(R.id.txtCedula);
        txtnombre=findViewById(R.id.txtNombre);
        txtApellido=findViewById(R.id.txtApellido);
        cmbsexo=findViewById(R.id.cmbsexo);

        opc=this.getResources().getStringArray(R.array.sexo);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbsexo.setAdapter(adapter);

        fotos= new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        String ced, nom, apelli,id;
        int sexo, foto;
        foto=Datos.fotoAleatoria(fotos);
        ced=txtcedula.getText().toString();
        nom=txtnombre.getText().toString();
        apelli=txtApellido.getText().toString();
        sexo=cmbsexo.getSelectedItemPosition();
        id=Datos.getId();

        Persona p=new Persona(id,foto,ced,nom,apelli,sexo);
        p.guardar();
        Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        txtcedula.setText("");
        txtnombre.setText("");
        txtApellido.setText("");
        cmbsexo.setSelection(0);
        txtcedula.requestFocus();
    }
    public  void onBackPressed(){
        finish();
        Intent i= new Intent(CrearPersonas.this,Principal.class);
        startActivity(i);
    }
}
