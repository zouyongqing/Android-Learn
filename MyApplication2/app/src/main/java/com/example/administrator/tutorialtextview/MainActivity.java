package com.example.administrator.tutorialtextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mmyTextView = (TextView)findViewById(R.id.myTextView);
        mmyTextView.setBackgroundColor(Color.RED);
        mmyTextView.setText("How Are you");
        mmyTextView.setTextColor(Color.rgb(0,255,0));
        mmyTextView.setHeight(100);
        mmyTextView.setTextSize(20);

        final EditText mmyEditText = (EditText)findViewById(R.id.myEditText);
        mmyEditText.setTextColor(Color.GREEN);
        String ttext1 = mmyEditText.getText().toString();

        mmyEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_UP)
                {
                    String string = ""+keyCode;
                    String tt = mmyEditText.getText().toString();
                    mmyTextView.setText(tt);
                }
                if (event.getAction()== KeyEvent.ACTION_DOWN&&(keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String ttext = mmyEditText.getText().toString();
                    mmyTextView.setText(ttext);
                    mmyEditText.setInputType(InputType.TYPE_NULL);
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mmyEditText.getWindowToken(),0);
                }
                return false;
            }
        });


    }
}
