package com.example.proyecto_benjamingonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class insumos extends AppCompatActivity {

    private EditText nombre,codigo,precioUnidad,prestamo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);
        nombre=(EditText)findViewById(R.id.ednombre);
        codigo=(EditText)findViewById(R.id.edcodigo);
        precioUnidad=(EditText)findViewById(R.id.edprecio);
        prestamo=(EditText)findViewById(R.id.edstock);

    }

    public void Añadir(View v)
    {
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        if(!codigo.getText().toString().isEmpty())
        {
            ContentValues registro= new ContentValues();

            registro.put("codigo", codigo.getText().toString());
            registro.put("nombre", nombre.getText().toString());
            registro.put("precioUnidad", precioUnidad.getText().toString());
            registro.put("prestamo", prestamo.getText().toString());

            bd.insert("insumos",null, registro);
            bd.close();
            Toast.makeText(this,"Se ha guardado el insumo",Toast.LENGTH_LONG).show();
            codigo.setText("");
            nombre.setText("");
            precioUnidad.setText("");
            prestamo.setText("");

        }
        else
        {
            Toast.makeText(this,"Debe ingresar un insumo",Toast.LENGTH_LONG).show();
            codigo.setText("");
            nombre.setText("");
            precioUnidad.setText("");
            prestamo.setText("");
        }
    }

    public void Mostrar(View v)
    {
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        String id=codigo.getText().toString();
        if(!id.isEmpty())
        {
            Cursor fila = bd.rawQuery("SELECT nombre, precioUnidad, prestamo FROM insumos WHERE codigo="+id, null);
            if(fila.moveToFirst())
            {
                nombre.setText(fila.getString(0));
                precioUnidad.setText(fila.getString(1));
                prestamo.setText(fila.getString(2));
            }
            else
            {
                Toast.makeText(this,"El codigo seleccionado no existe",Toast.LENGTH_LONG).show();

            }
        }
        else
        {
            Toast.makeText(this,"Debe ingresar el código del insumo",Toast.LENGTH_LONG).show();
        }

    }
    public void Eliminar(View v)
    {
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        String id=codigo.getText().toString();



        if(!id.isEmpty())
        {
            bd.delete("insumos","codigo="+id,null);
            bd.close();
            Toast.makeText(this,"El insumo se ha sido eliminada",Toast.LENGTH_LONG).show();

        }
        else
            {
                Toast.makeText(this,"Ingrese un codigo valido",Toast.LENGTH_LONG).show();

            }

    }
    public void Actualizar(View v)
    {
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        String id=codigo.getText().toString();

        ContentValues cont= new ContentValues();

        cont.put("codigo", codigo.getText().toString());
        cont.put("nombre", nombre.getText().toString());

        cont.put("precioUnidad", precioUnidad.getText().toString());
        cont.put("prestamo", prestamo.getText().toString());

        if(!id.isEmpty())
        {
            bd.update("insumos", cont, "codigo="+id,null);
            Toast.makeText(this,"El insumo se ha actualizado",Toast.LENGTH_LONG).show();
            codigo.setText("");
            nombre.setText("");
            precioUnidad.setText("");
            prestamo.setText("");
        }
        else
        {
            Toast.makeText(this,"Ingrese un codigo valido",Toast.LENGTH_LONG).show();

        }

    }
}