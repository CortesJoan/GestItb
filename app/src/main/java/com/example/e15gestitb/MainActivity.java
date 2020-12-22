package com.example.e15gestitb;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import java.sql.Time;


public class MainActivity extends AppCompatActivity {
    static String [] modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        modules = getResources().getStringArray(R.array.modules);
     }




}