package com.example.qthjen.floatingactionbuttonanimation;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab, fabDelete, fabEmail, fabMap, fabAdd;
    Animation moveLeft, moveRight, moveBottom, moveTop,
            backLeft, backRight, backTop, backBottom;

    boolean moveAndBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fabDelete = (FloatingActionButton) findViewById(R.id.fabDelete);
        fabEmail = (FloatingActionButton) findViewById(R.id.fabEmail);
        fabMap = (FloatingActionButton) findViewById(R.id.fabMap);
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);

        moveLeft = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_left);
        moveRight = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_right);
        moveTop = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_top);
        moveBottom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_bottom);

        backLeft = AnimationUtils.loadAnimation(MainActivity.this, R.anim.back_left);
        backRight = AnimationUtils.loadAnimation(MainActivity.this, R.anim.back_right);
        backTop = AnimationUtils.loadAnimation(MainActivity.this, R.anim.back_top);
        backBottom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.back_bottom);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( moveAndBack == false) {
                    Move();
                    moveAndBack = true;
                } else {
                    Back();
                    moveAndBack = false;
                }

            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
                if ( moveAndBack == true) {
                    Back();
                    moveAndBack = false;
                }
            }
        });

        fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
                if ( moveAndBack == true) {
                    Back();
                    moveAndBack = false;
                }
            }
        });

        fabMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Bottom", Toast.LENGTH_SHORT).show();
                if ( moveAndBack == true) {
                    Back();
                    moveAndBack = false;
                }
            }
        });

        fabEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Top", Toast.LENGTH_SHORT).show();
                if ( moveAndBack == true) {
                    Back();
                    moveAndBack = false;
                }
            }
        });

    }

    private void Move() {

        FrameLayout.LayoutParams paramsLeft = (FrameLayout.LayoutParams) fabAdd.getLayoutParams();
        paramsLeft.rightMargin = (int) (fabAdd.getWidth() * 1.7); // set view cách center = 1.7 = 170% in R/anim/move_elft
        /** => vị trí view fabAdd là 0% vị trí center là 170% animation chạy từ 170% về 0% là từ center qua trái **/
        fabAdd.setLayoutParams(paramsLeft);
        fabAdd.startAnimation(moveLeft);

        FrameLayout.LayoutParams paramRight = (FrameLayout.LayoutParams) fabDelete.getLayoutParams();
        paramRight.leftMargin = (int) (fabDelete.getWidth() * 1.7);
        fabDelete.setLayoutParams(paramRight);
        fabDelete.startAnimation(moveRight);

        FrameLayout.LayoutParams paramTop = (FrameLayout.LayoutParams) fabEmail.getLayoutParams();
        paramTop.bottomMargin = (int) (fabEmail.getWidth() * 1.7);
        fabEmail.setLayoutParams(paramTop);
        fabEmail.startAnimation(moveTop);

        FrameLayout.LayoutParams paramBottom = (FrameLayout.LayoutParams) fabMap.getLayoutParams();
        paramBottom.topMargin = (int) (fabMap.getWidth() * 1.7);
        fabMap.setLayoutParams(paramBottom);
        fabMap.startAnimation(moveBottom);

    }

    private void Back() {

        FrameLayout.LayoutParams paramsLeft = (FrameLayout.LayoutParams) fabAdd.getLayoutParams();
        paramsLeft.rightMargin -= (int) (fabAdd.getWidth() * 1.7);
        fabAdd.setLayoutParams(paramsLeft);
        fabAdd.startAnimation(backLeft);

        FrameLayout.LayoutParams paramRight = (FrameLayout.LayoutParams) fabDelete.getLayoutParams();
        paramRight.leftMargin -= (int) (fabDelete.getWidth() * 1.7);
        fabDelete.setLayoutParams(paramRight);
        fabDelete.startAnimation(backRight);

        FrameLayout.LayoutParams paramTop = (FrameLayout.LayoutParams) fabEmail.getLayoutParams();
        paramTop.bottomMargin -= (int) (fabEmail.getWidth() * 1.7);
        fabEmail.setLayoutParams(paramTop);
        fabEmail.startAnimation(backTop);

        FrameLayout.LayoutParams paramBottom = (FrameLayout.LayoutParams) fabMap.getLayoutParams();
        paramBottom.topMargin -= (int) (fabMap.getWidth() * 1.7);
        fabMap.setLayoutParams(paramBottom);
        fabMap.startAnimation(backBottom);

    }

}
