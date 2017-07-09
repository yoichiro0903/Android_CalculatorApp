package com.example.yoichirowatanabe.calculatorapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String inputNum = "";
    private double[] discountPercent = new double[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRadioButtonChecked();
    }


    public void numButtonClick (View v){
        Button numButton = (Button) v;
        inputNum = inputNum + numButton.getText().toString();
        showInputNumToLayout(inputNum);
        calculateDiscountPercent(Integer.parseInt(inputNum), discountPercent[0]);
    }

    public void calculateDiscountPercent (int inputInt, double discountPercent) {
        Log.d("cal", "cal ok");
        int calResultNum = (int) Math.round(inputInt * discountPercent);
        String calResultNumString = String.valueOf(calResultNum);
        showResultNumToLayout(calResultNumString);
    }

    public void deleteButtonClick (View v) {
        Log.d("del", "delete ok");
        if (inputNum.length() == 1) {
            inputNum = inputNum.substring(0, inputNum.length() - 1);
            showInputNumToLayout(inputNum);
        } else if (inputNum.length() == 0) {
        } else {
            inputNum = inputNum.substring(0, inputNum.length() - 1);
            showInputNumToLayout(inputNum);
            calculateDiscountPercent(Integer.parseInt(inputNum), discountPercent[0]);

        }
    }




    public void showInputNumToLayout (String inputNumString) {
        TextView inputNumShowTV = (TextView) findViewById(R.id.inputTextView);
        inputNumShowTV.setText(inputNumString + "円の、");
    }

    public void showResultNumToLayout (String resultNumString) {
        TextView resultNumShowTV = (TextView) findViewById(R.id.resulTextView);
        resultNumShowTV.setText(resultNumString + "円です。");
    }


    public void getRadioButtonChecked() {
        //Get checked RadioButton
        RadioGroup percentRadioGroup = (RadioGroup)findViewById(R.id.percentRadioGroup);
        percentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup checkedRadioGroup, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.radio10Percent:
                        discountPercent[0] = 0.9;
                        break;
                    case R.id.radio20Percent:
                        discountPercent[0] = 0.8;
                        break;
                    case R.id.radio30Percent:
                        discountPercent[0] = 0.7;
                        break;
                    case R.id.radio40Percent:
                        discountPercent[0] = 0.6;
                        break;
                    case R.id.radio50Percent:
                        discountPercent[0] = 0.5;
                        break;
                    case R.id.radio60Percent:
                        discountPercent[0] = 0.4;
                        break;
                    case R.id.radio70Percent:
                        discountPercent[0] = 0.3;
                        break;
                    case R.id.radio80Percent:
                        discountPercent[0] = 0.2;
                        break;
                    case R.id.radio90Percent:
                        discountPercent[0] = 0.1;
                        break;
                    default:
                        discountPercent[0] = 1;
                        break;
                }
                if (inputNum.length() > 0){
                    calculateDiscountPercent(Integer.parseInt(inputNum), discountPercent[0]);
                    Log.d("radio", "onCheckedChanged:" + discountPercent[0]);
                }
            }
        });
    }



}
