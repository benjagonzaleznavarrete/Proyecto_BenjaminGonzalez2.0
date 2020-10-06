package com.example.proyecto_benjamingonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_act extends AppCompatActivity {
    private VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        videoview=(VideoView)findViewById(R.id.video);

        String ruta="android.resource://" + getPackageName() + "/"+ R.raw.video;
        Uri uri=Uri.parse(ruta);
        videoview.setVideoURI(uri);

        MediaController media= new MediaController(this);
        videoview.setMediaController(media);
    }
}