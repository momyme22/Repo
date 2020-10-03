package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tipcalculator.R;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText checkAmtEditText;
    private EditText partySzEditText;
    private Button computeTipBtn;
    private EditText tip15;
    private EditText tip20;
    private EditText tip25;
    private EditText total15;
    private EditText total20;
    private EditText total25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmtEditText = findViewById(R.id.checkAmountValue);
        partySzEditText = findViewById(R.id.partySizeValue);
        computeTipBtn = findViewById(R.id.buttonCompute);
        tip15 = findViewById(R.id.fifteenPercentTipValue);
        tip20 = findViewById(R.id.twentyPercentTipValue);
        tip25 = findViewById(R.id.twentyfivePercentTipValue);
        total15 = findViewById(R.id.fifteenPercentTotalValue);
        total20 = findViewById(R.id.twentyPercentTotalValue);
        total25 = findViewById(R.id.twentyfivePercentTotalValue);


        computeTipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    /** Called when the user click the COPMPUTE TIP button */
    public void calculateTip() {
        float check = 0.00f;
        float partySize = 0.00f;


        if (checkAmtEditText.getText().toString().length() <= 0 || partySzEditText.getText().toString().length() <= 0){
            displayMessage();
        }
        else {
            check = Float.parseFloat(checkAmtEditText.getText().toString());
            partySize = Float.parseFloat(partySzEditText.getText().toString());

            if (check <= 0 || partySize <= 0){
                displayMessage();
            }
            else {
                int finalTip15 = Math.round(check * 15/100 * 1/partySize);
                int finalTip20 = Math.round(check * 20/100 * 1/partySize);
                int finalTip25 = Math.round(check * 25/100 * 1/partySize);

                int finalTotal15 = Math.round(check/partySize) + finalTip15;
                int finalTotal20 = Math.round(check/partySize) + finalTip20;
                int finalTotal25 = Math.round(check/partySize) + finalTip25;

                tip15.setText("" + finalTip15);
                tip20.setText("" + finalTip20);
                tip25.setText("" + finalTip25);

                total15.setText("" + finalTotal15);
                total20.setText("" + finalTotal20);
                total25.setText("" + finalTotal25);
            }
        }
    }
    public void displayMessage(){
        tip15.setText("");
        tip20.setText("");
        tip25.setText("");

        total15.setText("");
        total20.setText("");
        total25.setText("");

        Toast.makeText(this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
    }
}