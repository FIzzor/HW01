package com.example.jps29.hw01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import java.text.NumberFormat;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editText1;
    private EditText editText2;
    private TextView input;
    private Button doubleButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addOperatorsToSpinner();
    }

    public void addOperatorsToSpinner(){
        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Select Operator");
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void calcAndDisplay(View v) {
        editText1 = (EditText) findViewById(R.id.valueInput1);
        editText2 = (EditText) findViewById(R.id.valueInput2);
        input = (TextView) findViewById(R.id.resultValue);
        spinner = (Spinner) findViewById(R.id.spinner);

        int value1 = Integer.parseInt(editText1.getText().toString());
        int value2 = Integer.parseInt(editText2.getText().toString());

        if(spinner.getSelectedItem().toString() == "+"){
            input.setText(Integer.toString(value1 + value2));
        }
        else if (spinner.getSelectedItem().toString() == "-"){
            input.setText(Integer.toString(value1 - value2));
        }
        else if (spinner.getSelectedItem().toString() == "*"){
            input.setText(Integer.toString(value1 * value2));
        }
        else if (spinner.getSelectedItem().toString() == "/"){
            input.setText(Integer.toString(value1 / value2));
        }
    }
}
