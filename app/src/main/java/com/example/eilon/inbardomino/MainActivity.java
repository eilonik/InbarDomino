package com.example.eilon.inbardomino;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private final int LEFT_IMAGE = -1;
    private final int RIGHT_IMAGE = 1;
    private boolean canSwipe = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView dominoImage = (ImageView)findViewById(R.id.dominoImage);
        dominoImage.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                if(canSwipe) {
                    canSwipe = false;
                    rotateImage(dominoImage, RIGHT_IMAGE);
                }
            }

            public void onSwipeLeft() {
                if(canSwipe) {
                    canSwipe = false;
                    rotateImage(dominoImage, LEFT_IMAGE);
                }
            }

            public void onSwipeBottom() {
                //Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                //getInitialState(dominoImage);
            }

        });
    }

    private void rotateImage(ImageView image, int direction) {
        switch (direction) {
            case LEFT_IMAGE:
                image.setImageResource(R.mipmap.domino_down_left);
                break;

            case RIGHT_IMAGE:
                image.setImageResource(R.mipmap.domino_down);
                break;
        }
    }

    private void getInitialState(ImageView image) {
        canSwipe = true;
        image.setImageResource(R.mipmap.domino_up);
    }
}
