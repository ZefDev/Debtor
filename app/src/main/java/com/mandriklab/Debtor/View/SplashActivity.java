package com.mandriklab.Debtor.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mandriklab.Debtor.R;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash_screen);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
