package com.example.sanbarasan.currencyconverter;

import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  EditText amountOfMoney = (EditText) findViewById(R.id.amountOfUsd);
        final TextView CovertValue = (TextView) findViewById(R.id.CADValue);
        final Spinner firstSpinner = (Spinner) findViewById(R.id.fromSpinner);
        final Spinner secondSpinner = (Spinner) findViewById(R.id.toSpinner);
        String[] currency = {"USD", "CAD", "EURO", "POUND", "YEN"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currency);
        firstSpinner.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currency);
        secondSpinner.setAdapter(adapter2);
        Map<Integer,List<String>> currencyMap = new HashMap<Integer, List<String>>();
        ArrayList<ArrayList<String>> CurVal = new ArrayList<ArrayList<String>>();

        for (int i=0;i < currency.length; i++) {
            for (int j=0;j < currency.length; j++) {
                if (i != j) {
                    ArrayList<String> temp = new ArrayList<String>(); // added first array()
                    temp.add(currency[i]);
                    temp.add(currency[j]);
                    CurVal.add(temp);  //added second array
                }
            }
        }


        amountOfMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                CovertValue.setText("");
            }

            @Override
            public void afterTextChanged(Editable USDTxt) {
                if (USDTxt.length() > 0) {
                    int USDVal = Integer.parseInt(USDTxt.toString());
                    CovertValue.setText(String.valueOf(USDVal * 0.76));
                }
            }
        });
    }
}
