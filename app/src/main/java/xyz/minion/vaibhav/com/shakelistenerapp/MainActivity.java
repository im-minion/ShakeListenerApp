package xyz.minion.vaibhav.com.shakelistenerapp;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button sendBtn;
    private ShakeListener mShaker;
    private TextView tv;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        initView();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Shake and see the magic !", Toast.LENGTH_LONG).show();
                tv.setText("0");
                counter = 0;
                //start counting
                mShaker.setOnShakeListener(new ShakeListener.OnShakeListener() {
                    @Override
                    public void onShake() {
                        vibe.vibrate(500);
                        counter++;
                        tv.setText(" " + counter);
                    }
                });
            }
        });
    }

    private void initView() {
        sendBtn = (Button) findViewById(R.id.Clickme);
        tv = (TextView) findViewById(R.id.counterText);
        mShaker = new ShakeListener(this);
    }
}
