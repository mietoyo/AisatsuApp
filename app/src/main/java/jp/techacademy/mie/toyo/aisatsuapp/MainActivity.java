package jp.techacademy.mie.toyo.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import static jp.techacademy.mie.toyo.aisatsuapp.R.id.textView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView mTextView;

    int hour;
    int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);


        mTextView = (TextView) findViewById(textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
           Log.d("UI_PARTS","おはようございます");
           Log.d("UI_PARTS", "こんにちは");
            Log.d("UI_PARTS", "こんばんは");
            Log.d("UI_PARTS", ">" + hour + ":" + minute);


            if (hour > 2 && hour < 10 ) {
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText("おはようございます");
            }

            if (hour > 10 && hour < 18  ) {
                TextView text = (TextView)findViewById(R.id.textView);
                text.setText("こんにちは");
            }
            if (hour < 2 || hour > 18 ) {
                TextView text = (TextView)findViewById(R.id.textView);
                text.setText("こんばんは");
            }


        } else if (v.getId() == R.id.button2) {
            showTimePickerDialog();
        }
    }



    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        MainActivity.this.hour = hourOfDay;
                        MainActivity.this.minute = minute;
                    }
                },

                2,
                00,
                false);
        timePickerDialog.show();
    }
}
