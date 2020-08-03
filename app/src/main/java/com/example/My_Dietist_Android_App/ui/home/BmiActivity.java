package com.example.My_Dietist_Android_App.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.My_Dietist_Android_App.R;

public class BmiActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private EditText heightEditText;
    private EditText weightEditText;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private RadioGroup radioGroup;
    private TextView bmiNumTextView;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        heightEditText = (EditText) findViewById(R.id.heightEditText);
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        maleRadioButton = (RadioButton) findViewById(R.id.maleRadioButton);
        femaleRadioButton = (RadioButton) findViewById(R.id.femaleRadioButton);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        bmiNumTextView = (TextView) findViewById(R.id.bmiNumTextView);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        radioGroup.setOnCheckedChangeListener(this);
    }
// bmi calculated and message shown whenever a radio button is selected
// a oncheckedchanged listener was implemented to monitor if and which radio button is checked
    @SuppressLint("SetTextI18n")
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        String heightString = heightEditText.getText().toString();
        float heightTemp = Integer.parseInt(heightString);
        String weightString = weightEditText.getText().toString();
        int weight = Integer.parseInt(weightString);
//        height entered in cm then converted | thought it would make the app easier to use
        float height = heightTemp/100;
        double bmi = weight/Math.pow(height,2);
        bmiNumTextView.setText(Double.toString(bmi));
        switch (checkedId){
            case R.id.maleRadioButton:
                if (bmi<19.5){
                    messageTextView.setText("Underweight");
                }
                else if(bmi<24.9){
                    messageTextView.setText("Average");
                }
                else if(bmi<29.9){
                    messageTextView.setText("Class I obesity");
                }
                else if(bmi<40){
                    messageTextView.setText("Class II obesity");
                }
                else{
                    messageTextView.setText("Class III obesity");
                }
                break;
            case R.id.femaleRadioButton:
                if (bmi<18.5){
                    messageTextView.setText("Underweight");
                }
                else if(bmi<23.5){
                    messageTextView.setText("Average");
                }
                else if(bmi<28.6){
                    messageTextView.setText("Class I obesity");
                }
                else if(bmi<40){
                    messageTextView.setText("Class II obesity");
                }
                else{
                    messageTextView.setText("Class III obesity");
                }
                break;
        }

    }
}
