package com.example.malet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    int quess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);

        quess = (int)(Math.random()*100);
        gameFinished = false;
    }
    public void onClick(View v)
    {
        if(!gameFinished)
        {
            int inp=Integer.parseInt(editText.getText().toString());
            if(inp>quess)
                textView.setText(getResources().getString(R.string.ahead));
            if(inp<quess)
                textView.setText(getResources().getString(R.string.behind));
            if(inp == quess)
            {
                textView.setText(getResources().getString(R.string.hit));
                button.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
            else {
                quess = (int)(Math.random()*100);
                button.setText(getResources().getString(R.string.input_value));
                textView.setText(getResources().getString(R.string.try_to_quess));
                gameFinished = false;
            }
            editText.setText("");
        }
    }
}
