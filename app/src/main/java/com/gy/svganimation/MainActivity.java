package com.gy.svganimation;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    private EditText editText;
    FrameLayout content;

    private AnimatedVectorDrawable animate1;
    private AnimatedVectorDrawable animate2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img_svg);
        editText = (EditText) findViewById(R.id.et);
        content= findViewById(R.id.content);



        animate1 = (AnimatedVectorDrawable)       getResources().getDrawable(R.drawable.draw_animator1);
        animate2 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.draw_animator2);

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
                img.setImageDrawable(animate1);
                animate1.start();
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    lost_foucs(view);
                }else {
                    img.setImageDrawable(animate1);
                    animate1.start();
                }
            }
        });
    }

    public void lost_foucs(View view){
        img.setImageDrawable(animate2);
        animate2.start();
    }
}
