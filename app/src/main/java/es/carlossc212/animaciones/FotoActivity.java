package es.carlossc212.animaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {

    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        Bitmap img = (Bitmap) getIntent().getExtras().get("imagen");

        imagen = findViewById(R.id.imagen);

        imagen.setImageBitmap(img);
    }
}