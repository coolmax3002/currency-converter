package com.example.sanbarasan.currencyconverter;

import android.content.DialogInterface;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
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
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, currency);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        firstSpinner.setAdapter(spinnerArrayAdapter);
        secondSpinner.setAdapter(spinnerArrayAdapter);


        Map< List<String>, Double> currencyMap = new HashMap< List<String>, Double>();
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

        currencyMap.put(CurVal.get(0), 1.32);
        currencyMap.put(CurVal.get(1), 0.91);
        currencyMap.put(CurVal.get(2),0.76);
        currencyMap.put(CurVal.get(3), 104.39);
        currencyMap.put(CurVal.get(4), 0.76);
        currencyMap.put(CurVal.get(5), 0.69);
        currencyMap.put(CurVal.get(6),0.58);
        currencyMap.put(CurVal.get(7), 79.14);
        currencyMap.put(CurVal.get(8), 1.10);
        currencyMap.put(CurVal.get(9),1.45);
        currencyMap.put(CurVal.get(10), 0.84);
        currencyMap.put(CurVal.get(11),114.80);
        currencyMap.put(CurVal.get(12),1.31);
        currencyMap.put(CurVal.get(13),1.73);
        currencyMap.put(CurVal.get(14),1.19);
        currencyMap.put(CurVal.get(15),136.83);
        currencyMap.put(CurVal.get(16),0.0096);
        currencyMap.put(CurVal.get(17),0.013);
        currencyMap.put(CurVal.get(18),0.0087);
        currencyMap.put(CurVal.get(19),0.0073);


        String fromCur = "USD", toCur="CAD";

        for (int z = 0; z < CurVal.size(); z++) {
            if (((CurVal.get(z).get(0).compareTo(fromCur)) == 0) && ((CurVal.get(z).get(1).compareTo(toCur)) == 0)) {
                CovertValue.setText(String.valueOf(currencyMap.get(CurVal.get(z))));
                //CovertValue.setText(String.valueOf(z));
                //boo = true;
            }
        }

        amountOfMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //CovertValue.setText("");
            }

            @Override
            public void afterTextChanged(Editable USDTxt) {
                if (USDTxt.length() > 0) {
                    int USDVal = Integer.parseInt(USDTxt.toString());
                    //CovertValue.setText(String.valueOf(USDVal * 1));
                }
            }
        });
    }
}
