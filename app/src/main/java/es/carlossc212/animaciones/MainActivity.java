package es.carlossc212.animaciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SubtitleData;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    MediaPlayer md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(getLayoutInflater().inflate(R.layout.activity_main, null));

        md = new MediaPlayer();

        AssetFileDescriptor ad = null;

        try {
            ad = getAssets().openFd("intro.mp3");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                md.setDataSource(ad.getFileDescriptor(), ad.getStartOffset(), ad.getLength());
                ad.close();
                md.prepare();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        md.start();


        findViewById(R.id.btEasy).setOnClickListener(this);
        findViewById(R.id.btMedium).setOnClickListener(this);
        findViewById(R.id.btHard).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        Intent i = new Intent(this, JuegoActivity.class);
        md.stop();


        switch (id){
            case R.id.btEasy:
                i.putExtra("modo",Difficulty.EASY);
                startActivity(i);
                finish();
                break;
            case R.id.btMedium:
                i.putExtra("modo",Difficulty.MEDIUM);
                startActivity(i);
                finish();
                break;
            case R.id.btHard:
                i.putExtra("modo",Difficulty.HARD);
                startActivity(i);
                finish();
                break;

        }
    }
}