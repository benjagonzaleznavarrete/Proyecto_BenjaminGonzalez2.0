package com.example.proyecto_benjamingonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class cliente_act extends AppCompatActivity {

    private Spinner sp1, sp2;
    private EditText texto;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_act);

        sp1=(Spinner)findViewById(R.id.spincliente);
        sp2=(Spinner)findViewById(R.id.spinner2);
        texto=(EditText) findViewById(R.id.et1);
        mensaje=(TextView) findViewById(R.id.tv1);

        ArrayList<String> listaclientes=(ArrayList<String>)getIntent().getSerializableExtra("listaclientes");
        ArrayAdapter adapt =new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listaclientes);

        ArrayList<String> listaplanes=(ArrayList<String>)getIntent().getSerializableExtra("listaplanes");
        ArrayAdapter adapt1 =new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listaplanes);

        sp1.setAdapter(adapt);
        sp2.setAdapter(adapt1);
        }

        public void Calcular(View v)
        {
            Planes plan= new Planes();
            String cliente= sp1.getSelectedItem().toString();
            String planes= sp2.getSelectedItem().toString();

            int saldo= Integer.parseInt(texto.getText().toString());
            int plus = Integer.parseInt(plan.getPlus());
            int plusultra=Integer.parseInt(plan.getPlusUltra());
            int resultado=saldo-plus;
            int resultadodos=saldo-plusultra;

            if(cliente.equals("Roberto")&&planes.equals("Plus"))
            {
                mensaje.setText("El valor del plan Plus es: "+resultado);
            }

            if(cliente.equals("Roberto")&&planes.equals("Plus Ultra"));
            {
                mensaje.setText("El valor del plan Plus Ultra es: "+resultadodos);
            }

            if(cliente.equals("Ivan")&&planes.equals("Plus"))
            {
                mensaje.setText("El valor del plan Plus es: "+resultado);
            }

            if(cliente.equals("Ivan")&&planes.equals("Plus Ultra"));
            {
                mensaje.setText("El valor del plan Plus Ultra es: "+resultadodos);
            }


        }


        }