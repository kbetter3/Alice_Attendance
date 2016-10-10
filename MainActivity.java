package com.rkqdnddl.alice_attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    String btn_string;
    EditText editText;
    int numLen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        editText.setFocusable(false);
        editText.setClickable(false);
    }

    @Override
    public void onClick(View view) {
        if(numLen < 4) {
            editText.setText(editText.getText().append(((Button) view).getText()));
            numLen++;
        }
    }

    public void delNum(View view) {
        if (numLen > 0) {
            editText.setText(editText.getText().delete(numLen - 1, numLen));
            numLen--;
        }
    }

    public void inOrOut(View view) {
        if (((Button)view).getText().equals(getResources().getString(R.string.in))) {
            editText.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        } else {
            editText.setBackgroundColor(getResources().getColor(R.color.colorRed));
        }

        Log.d("inOrOut1", ((Button)view).getText() + "");
        Log.d("inOrOut2", getResources().getString(R.string.in));
    }
}
