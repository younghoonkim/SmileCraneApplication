package com.ebaykorea.smilecraneapplication.smilecraneapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton leftButton;
    ImageButton rightButton;
    ImageButton upButton;
    ImageButton downButton;
    ImageButton bbaemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = (ImageButton) findViewById(R.id.leftButton);
        rightButton = (ImageButton) findViewById(R.id.rightButton);
        upButton = (ImageButton) findViewById(R.id.upButton);
        downButton = (ImageButton) findViewById(R.id.downButton);
        bbaemButton = (ImageButton) findViewById(R.id.bbaemButton);


        initButtonTouchListener(leftButton, "left");
        initButtonTouchListener(rightButton, "right");
        initButtonTouchListener(upButton, "up");
        initButtonTouchListener(downButton, "down");
        initButtonClickListener(bbaemButton, "bbaem");

    }
    private void initButtonClickListener(ImageButton ib, final String btnName){
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        btnName + " is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initButtonTouchListener(ImageButton ib, final String btnName){
        ib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageButton b = (ImageButton) v;

                int action = event.getAction();

                if(action==MotionEvent.ACTION_DOWN){
                    //버튼 눌렀을때
                    Toast.makeText(MainActivity.this,
                            btnName + " is down!", Toast.LENGTH_SHORT).show();
                }
                else if(action==MotionEvent.ACTION_UP){
                    //버튼 땠을때
                    Toast.makeText(MainActivity.this,
                            btnName + " is up!", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
    }

}
