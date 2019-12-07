package com.b3company.sharedpreferances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static String prefsName = "myPrefs";
    public static String COUNTER_PREF_KEY = "counter_key";

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        count = sharedPreferences.getInt(COUNTER_PREF_KEY,0);

        TextView textView = findViewById(R.id.tvShow);
        Button button = findViewById(R.id.btn);

        textView.setText("" + count);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt(COUNTER_PREF_KEY, count++);

            }
        });
    }
}
