package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText height,weight;
    TextView resultvalue;
    String calculation, BMIresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=findViewById(R.id.edHeight);
        weight=findViewById(R.id.edWeight);
        resultvalue=findViewById(R.id.result);
    }

    public void calculateBMI(View view)
    {
        String s1= weight.getText().toString();
        String s2=height.getText().toString();

        float weightvalue=Float.parseFloat(s1);
        float heightvalue=Float.parseFloat(s2)/100;
        
        float bmi= weightvalue/(heightvalue*heightvalue);

        if(bmi<16)
        {
            BMIresult="Severe Under Weight";
        }
        else if(bmi<18.5)
        {
            BMIresult="Under Weight";
        }
        else if(bmi>18.5 && bmi<24.5)
        {
            BMIresult="Normal Weight";
        }
        else if(bmi> 25 && bmi<29.5)
        {
            BMIresult="Over Weight";
        }
        else {
            BMIresult="Obese";
        }
        calculation="Result:\n\n" + bmi+ "\n"+ BMIresult;
        resultvalue.setText(calculation);

    }
}
