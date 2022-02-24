package es.carlossc212.animaciones;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.WindowInsetsAnimation;

public class Pelota{
    public int[] direction = new int[]{-1,1}; //direction modifier (-1,1)
    public int x,y,size;
    public int speed = 20;
    public Paint paint;
    public RectF oval;

    public Pelota(int x, int y, int size, int color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.paint = new Paint();
        this.paint.setColor(color);
    }

    public void move(Canvas canvas) {
        this.x += speed*direction[0];
        this.y += speed*direction[1];
        this.oval = new RectF(x-size/2,y-size/2,x+size/2,y+size/2);

        //Do we need to bounce next time?
        Rect bounds = new Rect();
        this.oval.roundOut(bounds);

        if(!canvas.getClipBounds().contains(bounds)){
            if(this.x-size<0 || this.x+size > canvas.getWidth()){
                direction[0] = direction[0]*-1;

            }
            if(this.y-size<0 || this.y+size > canvas.getHeight()){
                direction[1] = direction[1]*-1;

            }
        }
    }
}
