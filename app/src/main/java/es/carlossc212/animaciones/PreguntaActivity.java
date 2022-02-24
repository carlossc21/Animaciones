package es.carlossc212.animaciones;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class PreguntaActivity extends AppCompatActivity {

    Button ok;
    TextView tvPregunta;
    EditText etRespuesta;

    MediaPlayer md;


    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pregunta);



        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            Bitmap img = (Bitmap) data.getExtras().get("data");

                            Intent foto = new Intent(getApplicationContext(), FotoActivity.class);
                            foto.putExtra("imagen",img);
                            startActivity(foto);
                            finish();
                        }
                    }
                });



        ok = findViewById(R.id.btOk);

        ok.setOnClickListener(v->{
            if (Integer.parseInt(etRespuesta.getText().toString()) == Difficulty.getRespuesta()) {
                abrirCamara();
            }else{
                etRespuesta.setTextColor(Color.RED);

                md = new MediaPlayer();

                AssetFileDescriptor ad = null;

                try {
                    ad = getAssets().openFd("perder-incorrecto-no-valido.mp3");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        md.setDataSource(ad.getFileDescriptor(), ad.getStartOffset(), ad.getLength());
                        ad.close();
                        md.prepare();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                md.start();
            }
        });
        tvPregunta = findViewById(R.id.tvPregunta);

        tvPregunta.setText(Difficulty.generaPregunta());

        etRespuesta = findViewById(R.id.etRespuesta);
    }



    public void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {

            resultLauncher.launch(intent);
        }

    }
}