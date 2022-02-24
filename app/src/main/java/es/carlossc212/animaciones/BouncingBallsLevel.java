package es.carlossc212.animaciones;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class BouncingBallsLevel extends View {

    private ArrayList<Pelota> pelotas = new ArrayList<>();

    public BouncingBallsLevel(Context context,int mode, AttributeSet attrs) {
        super(context, attrs);
        init(mode);
    }
    public BouncingBallsLevel(Context context, int mode) {
        super(context);
        init(mode);
    }
    private void init(int mode){

        switch (mode){
            case Difficulty.EASY:
                pelotas = Difficulty.easy();
                break;
            case Difficulty.MEDIUM:
                pelotas = Difficulty.medium();
                break;
            case Difficulty.HARD:
                pelotas = Difficulty.hard();
                break;
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw the balls
        for(Pelota pelota : pelotas){
            //Move first
            pelota.move(canvas);
            //Draw them
            canvas.drawOval(pelota.oval,pelota.paint);
        }
        invalidate(); // See note
    }
}
