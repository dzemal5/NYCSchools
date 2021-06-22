package com.crnkic.a20210621_dzemalcrnkic_nycschools;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.databinding.ActivityMainBinding;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewBinding = null;
    }
}