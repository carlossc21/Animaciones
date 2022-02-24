package es.carlossc212.animaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Chronometer;

import java.util.Timer;

public class JuegoActivity extends AppCompatActivity {


    private final int DURACION = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(new BouncingBallsLevel(this, (int)getIntent().getExtras().get("modo")));

        System.out.println(Difficulty.generaPregunta() + Difficulty.getRespuesta());

        new Handler().postDelayed(()->{
            Intent i = new Intent(JuegoActivity.this, PreguntaActivity.class);
            startActivity(i);
            finish();
        }, DURACION);



    }
}