package com.example.sanbarasan.currencyconverter;

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
        Map<Double,List<String>> currencyMap = new HashMap<Double, List<String>>();
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
        currencyMap.put(1.32, CurVal.get(0));
        currencyMap.put(0.91, CurVal.get(1));
        currencyMap.put(0.76, CurVal.get(2));
        currencyMap.put(104.39, CurVal.get(3));
        currencyMap.put(0.76, CurVal.get(4));
        currencyMap.put(0.69, CurVal.get(5));
        currencyMap.put(0.58, CurVal.get(6));
        currencyMap.put(79.14, CurVal.get(7));
        currencyMap.put(1.10, CurVal.get(8));
        currencyMap.put(1.45, CurVal.get(9));
        currencyMap.put(0.84, CurVal.get(10));
        currencyMap.put(114.80, CurVal.get(11));
        currencyMap.put(1.31, CurVal.get(12));
        currencyMap.put(1.73, CurVal.get(13));
        currencyMap.put(1.19, CurVal.get(14));
        currencyMap.put(136.83, CurVal.get(15));
        currencyMap.put(0.0096, CurVal.get(16));
        currencyMap.put(0.013, CurVal.get(17));
        currencyMap.put(0.0087, CurVal.get(18));
        currencyMap.put(0.0073, CurVal.get(19));

        String fromCur = firstSpinner.getOnItemClickListener().toString();
        String toCur = secondSpinner.getOnItemClickListener().toString();
        ArrayList<String> temp = new ArrayList<String>(); // added first array()
        Map.Entry<Double, List<String>> entry = currencyMap.entrySet().iterator().next();

        double newValue = 0.0;

        for (int z = 0; z <= 19; z++) {
            if (CurVal.get(z).equals(fromCur) && CurVal.get(z).equals(toCur)){
                newValue = entry.getKey();
            }

        }

            final double finalValue = newValue;

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
                    CovertValue.setText(String.valueOf(USDVal * finalValue));
                }
            }
        });
    }
}
