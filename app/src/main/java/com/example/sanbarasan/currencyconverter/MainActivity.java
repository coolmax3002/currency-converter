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
    private String selectUnit = "";
    private String fromUnit="inch", toUnit="inch";
    private double multiple = 1;
    private double factor=1;
    private double factor2=1;
    private Map< List<String>, Double> currencyMap = new HashMap< List<String>, Double>();
    private Map< List<String>, Double> unitMap = new HashMap< List<String>, Double>();
    private ArrayList<ArrayList<String>> CurVal = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> unitVal = new ArrayList<ArrayList<String>>();



    public void setFromCur (String s) {fromCur=s; }

    public String getFromCur() { return fromCur; }

    public void setToCur (String s) {toCur=s; }

    public void setToUnit (String q) {toUnit=q;}

    public String getToUnit (){return toUnit;}

    public void setFromUnit (String h) {fromUnit=h;}

    public String getFromUnit () {return fromUnit;}

    public void setSeletedConv (String z) {selectConv=z;}

    public void setSelectedUnit (String g) {selectUnit=g;}

    public String getSelectedUnit (){return selectUnit;}

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
    public double secondFactor (String one, String two){
    for (int y = 0; y < unitVal.size(); y++) {
        if (((unitVal.get(y).get(0).compareTo(one)) == 0) && ((unitVal.get(y).get(1).compareTo(two)) == 0)) {
            return unitMap.get(unitVal.get(y));
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
               setSeletedConv( selector[b]);
                CovertValue.setText(null);
                amountOfMoney.setText(null);

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
        unitMap.put(unitVal.get(1),0.027777);
        unitMap.put(unitVal.get(2),25.4);
        unitMap.put(unitVal.get(3),2.54);
        unitMap.put(unitVal.get(4),0.0254);
        unitMap.put(unitVal.get(5),12.0);
        unitMap.put(unitVal.get(6),0.3333);
        unitMap.put(unitVal.get(7),304.8);
        unitMap.put(unitVal.get(8),30.84);
        unitMap.put(unitVal.get(9),0.3048);
        unitMap.put(unitVal.get(10),36.0);
        unitMap.put(unitVal.get(11),3.0);
        unitMap.put(unitVal.get(12),914.4);
        unitMap.put(unitVal.get(13),91.44);
        unitMap.put(unitVal.get(14),0.9144);
        unitMap.put(unitVal.get(15),0.0393701);
        unitMap.put(unitVal.get(16),0.00328084);
        unitMap.put(unitVal.get(17),0.001093);
        unitMap.put(unitVal.get(18),0.1);
        unitMap.put(unitVal.get(19),0.001);
        unitMap.put(unitVal.get(20),0.393701);
        unitMap.put(unitVal.get(21),0.0328084);
        unitMap.put(unitVal.get(22),0.0109361);
        unitMap.put(unitVal.get(23),10.0);
        unitMap.put(unitVal.get(24),0.01);
        unitMap.put(unitVal.get(25),39.3701);
        unitMap.put(unitVal.get(26),3.28084);
        unitMap.put(unitVal.get(27),1.09361);
        unitMap.put(unitVal.get(28),1000.0);
        unitMap.put(unitVal.get(29),100.0);





        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (selectConv.equalsIgnoreCase("Currency")) {
                    setFromCur(currency[i]);
                    factor = getFactor(getFromCur(), getToCur());

                }else if (selectConv.equalsIgnoreCase("Metrics")){
                    setFromUnit(metrics[i]);
                    factor2 = secondFactor(getFromUnit(), getToUnit());


                }
                amountOfMoney.setText(null);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                  //fromCur = currency[0];
            }
        });

        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (selectConv.equalsIgnoreCase("Currency")) {
                    setToCur(currency[i]);
                    factor = getFactor(getFromCur(), getToCur());

                } else if (selectConv.equalsIgnoreCase("Metrics")) {
                    setToUnit(metrics[i]);
                    factor2 = secondFactor(getFromUnit(), getToUnit());


                }

                amountOfMoney.setText(null);

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
                CovertValue.setText("");
            }

            @Override
            public void afterTextChanged(Editable USDTxt) {
                if (USDTxt.length() > 0 && USDTxt.length() < 10) {
                    if (selectConv.equalsIgnoreCase("Currency")) {
                        int USDVal = Integer.parseInt(USDTxt.toString());
                        CovertValue.setText(String.valueOf(USDVal * factor));

                    }else if (selectConv.equalsIgnoreCase("Metrics")){
                        int USDVal = Integer.parseInt(USDTxt.toString());
                        CovertValue.setText(String.valueOf(USDVal * factor2));
                        //CovertValue.setText(String.valueOf(factor2));
                    }
                }
            }
        });
    }
}
