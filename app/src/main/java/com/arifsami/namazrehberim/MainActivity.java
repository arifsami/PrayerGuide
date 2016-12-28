package com.arifsami.namazrehberim;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout l1;
    RelativeLayout r1;
    Display d;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = (RelativeLayout) findViewById(R.id.relative1);
        t1 = (TextView) findViewById(R.id.txt1);
        l1 = (LinearLayout) findViewById(R.id.layout1);

        //DisplayMetrics metrics = new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(metrics);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int width = size.x;
        int height = size.y;



        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) l1.getLayoutParams();
        
        l1.setLayoutParams(params);


        t1.setText("screen width: " + width + "\nscreen height: " + height +
                "\nview width: " + l1.getWidth() + "\nview height: " + l1.getHeight() +
                "\n\nview x : " + l1.getX() +
                "\nview y : " + l1.getY() +
                "\n\nx : " + l1.getLayoutParams().width +
                "\ny : " + l1.getLayoutParams().height);


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator anim = ObjectAnimator.ofFloat(l1, "x", width - (l1.getLayoutParams().width - 100));
                anim.setDuration(1000);
                anim.start();
            }
        });

        // Some existing RelativeLayout from your layout xml
        //RelativeLayout rl = (RelativeLayout) findViewById(R.id.my_relative_layout);

        //ImageView iv = new ImageView(this);



    }
}
