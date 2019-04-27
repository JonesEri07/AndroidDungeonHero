package com.cre8ivec.ericj.dungeonhero.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.utility.Rooms.CaveRoom;

import org.xml.sax.AttributeList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.jar.Attributes;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawPadFragment extends Fragment {


    public DrawPadFragment() {
        // Required empty public constructor
    }



    private MyCanvas myCanvas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View v = inflater.inflate(R.layout.fragment_draw_pad, container, false);
        if (myCanvas == null)
            myCanvas = new MyCanvas(getContext(), null);
        return myCanvas;
    }

    public void setToDraw() {
        myCanvas.setToDraw();
    }

    public void setToErase() {
        myCanvas.setToErase();
    }

   public class MyCanvas extends View {
        Paint paint;
        Path path;
        Paint eraser;

        private boolean draw = true;


        public MyCanvas(Context context, AttributeSet attributes) {
            super(context, attributes);
            paint = new Paint();
            path = new Path();

            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8f);

            eraser = new Paint();
            eraser.setAntiAlias(true);
            eraser.setColor(getResources().getColor(R.color.paper));
            eraser.setStrokeJoin(Paint.Join.ROUND);
            eraser.setStyle(Paint.Style.STROKE);
            eraser.setStrokeWidth(12f);


            setBackgroundColor(getResources().getColor(R.color.paper));
        }

        public void setToErase() {
            draw = false;
        }

        public void setToDraw() {
            draw = true;
        }

        protected void onDraw(Canvas canvas) {
            if (draw) {
                super.onDraw(canvas);
                canvas.drawPath(path, paint);
            }
            else {
                super.onDraw(canvas);
                canvas.drawPath(path, eraser);
            }
        }

        public boolean onTouchEvent(MotionEvent event) {
            float xpos = event.getX();
            float ypos = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(xpos, ypos);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(xpos, ypos);
                    break;
                case MotionEvent.ACTION_UP:
                    break;

                    default:
                        return false;

            }
            invalidate();
            return true;
        }
   }
}