package com.example.sanbarasan.currencyconverter;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter.*;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {





    private String fromCur="USD", toCur="USD";
    private String selectConv="metric";
    private double factor=1;
    private Map< List<String>, Double> currencyMap = new HashMap< List<String>, Double>();
    private Map< List<String>, Double> unitMap = new HashMap< List<String>, Double>();
    private ArrayList<ArrayList<String>> CurVal = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> unitVal = new ArrayList<ArrayList<String>>();



    public void setFromCur (String s) {fromCur=s; }

    public String getFromCur() { return fromCur; }

    public void setToCur (String s) {toCur=s; }

    public void setSeletedConv (String z) {selectConv=z;}

    public String getSeletedConv () {return selectConv;}

    public String getToCur() { return toCur; }

    public double getFactor (String f, String t) {

        for (int z = 0; z < CurVal.size(); z++) {
            if (((CurVal.get(z).get(0).compareTo(f)) == 0) && ((CurVal.get(z).get(1).compareTo(t)) == 0)) {
                return currencyMap.get(CurVal.get(z));
            }
        }
        return 1;
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  EditText amountOfMoney = (EditText) findViewById(R.id.amountOfUsd);
        final TextView CovertValue = (TextView) findViewById(R.id.CADValue);
        final Spinner firstSpinner = (Spinner) findViewById(R.id.fromSpinner);
        final Spinner secondSpinner = (Spinner) findViewById(R.id.toSpinner);
        final Spinner whichUnit = (Spinner) findViewById(R.id.unitConvert);
        final String[] selector = {"Metrics", "Currency"};
        final String[] metrics = {"Inch","Feet","Yard","Millimeter","Centimeter","Meter"};
        final String[] currency = {"USD", "CAD", "EURO", "POUND", "YEN"};
        ArrayAdapter<String> TempUnitAdap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, selector);
        TempUnitAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        whichUnit.setAdapter(TempUnitAdap);

        ArrayAdapter<String> tempSelAdap  = new ArrayAdapter<String>(this, android .R.layout.simple_spinner_item, metrics);
        tempSelAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstSpinner.setAdapter(tempSelAdap);
        secondSpinner.setAdapter(tempSelAdap);

        whichUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int b, long l) {

                if (selector[b].equalsIgnoreCase("Currency")) {
                    ArrayAdapter<String> fVal = new ArrayAdapter<String>(firstSpinner.getContext(), R.layout.support_simple_spinner_dropdown_item, currency);
                    firstSpinner.setAdapter(fVal);
                    ArrayAdapter<String> sVal = new ArrayAdapter<String>(secondSpinner.getContext(), R.layout.support_simple_spinner_dropdown_item, currency);
                    secondSpinner.setAdapter(sVal);
                } else if (selector[b].equalsIgnoreCase("Metrics")) {
                    ArrayAdapter<String> fVal = new ArrayAdapter<String>(firstSpinner.getContext(), R.layout.support_simple_spinner_dropdown_item, metrics);
                    firstSpinner.setAdapter(fVal);
                    ArrayAdapter<String> sVal = new ArrayAdapter<String>(secondSpinner.getContext(), R.layout.support_simple_spinner_dropdown_item, metrics);
                    secondSpinner.setAdapter(sVal);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //CovertValue.setText(String.valueOf(select));


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
        for (int e=0;e < metrics.length; e++) {
            for (int r=0;r < metrics.length; r++) {
                if (e != r) {
                    ArrayList<String> temp2 = new ArrayList<String>(); // added first array()
                    temp2.add(metrics[e]);
                    temp2.add(metrics[r]);
                    unitVal.add(temp2);  //added second array
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

        unitMap.put(unitVal.get(0),0.0833);
        unitMap.put(unitVal.get(1),36.0);
        unitMap.put(unitVal.get(2),25.4);
        unitMap.put(unitVal.get(3),2.54);
        unitMap.put(unitVal.get(4),0.0254);
        unitMap.put(unitVal.get(5),12.0);
        unitMap.put(unitVal.get(6),25.4);
        unitMap.put(unitVal.get(7),25.4);
        unitMap.put(unitVal.get(8),25.4);
        unitMap.put(unitVal.get(9),25.4);
        unitMap.put(unitVal.get(10),25.4);
        unitMap.put(unitVal.get(11),36.0);
        unitMap.put(unitVal.get(12),25.4);
        unitMap.put(unitVal.get(13),25.4);
        unitMap.put(unitVal.get(14),25.4);
        unitMap.put(unitVal.get(15),25.4);
        unitMap.put(unitVal.get(16),25.4);
        unitMap.put(unitVal.get(17),25.4);
        unitMap.put(unitVal.get(18),25.4);
        unitMap.put(unitVal.get(19),25.4);
        unitMap.put(unitVal.get(20),25.4);
        unitMap.put(unitVal.get(21),25.4);
        unitMap.put(unitVal.get(22),25.4);
        unitMap.put(unitVal.get(23),25.4);
        unitMap.put(unitVal.get(24),25.4);
        unitMap.put(unitVal.get(25),25.4);
        unitMap.put(unitVal.get(26),25.4);
        unitMap.put(unitVal.get(27),25.4);
        unitMap.put(unitVal.get(28),25.4);
        unitMap.put(unitVal.get(29),25.4);
        unitMap.put(unitVal.get(30),25.4);




        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setFromCur(currency[i]);
                factor = getFactor(getFromCur(), getToCur());
                //CovertValue.setText(String.valueOf(factor));
                //CovertValue.setText(getFromCur());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                  //fromCur = currency[0];
            }
        });

        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setToCur(currency[i]);
                factor = getFactor(getFromCur(), getToCur());
                //CovertValue.setText(String.valueOf(factor));


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //fromCur = currency[0];
            }
        });


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
                if (USDTxt.length() > 0 && USDTxt.length() < 10) {
                    int USDVal = Integer.parseInt(USDTxt.toString());
                   // CovertValue.setText(String.valueOf(USDVal * factor));
                }
            }
        });
    }
}
