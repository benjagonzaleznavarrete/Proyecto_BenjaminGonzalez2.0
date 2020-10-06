package com.example.proyecto_benjamingonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class menu_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images={R.drawable.a, R.drawable.b, R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf=(ViewFlipper)findViewById(R.id.slider);

        for(int i=0; i<images.length;i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView view= new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2300);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right );
    }

    public void localizacion(View v)
    {
        Intent i = new Intent(this, map_act.class);
        startActivity(i);
    }

    public void info(View v)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }

    public void clientes(View v)
    {
        ArrayList<String> clientes=new ArrayList<String>();
        ArrayList<String> planes=new ArrayList<String>();
        clientes.add("Roberto");
        clientes.add("Ivan");

        planes.add("Xtreme");
        planes.add("Mindfullness");

        Intent i= new Intent(this, cliente_act.class);
        i.putExtra("listaclientes",clientes);
        i.putExtra("listaplanes",planes);
        startActivity(i);
    }

}